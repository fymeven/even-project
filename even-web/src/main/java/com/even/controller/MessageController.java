package com.even.controller;

import com.even.bean.SysUser;
import com.even.bean.SysUserExample;
import com.even.common.util.ShiroUtil;
import com.even.dao.SysUserMapper;
import com.even.io.sysUser.enums.SysUserEnum;
import com.even.service.ISysMessageService;
import com.even.websocket.WebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by even on 2017/11/27.
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Resource
    private ISysMessageService messageService;
    @Resource
    private SysUserMapper sysUserMapper;
    /**
     * webSocket p2p私聊页面
     * @return
     */
    @RequestMapping(value = "/privateChat",method = RequestMethod.GET)
    public String page(){
        return "message/privateChat";
    }


    //获取在线用户列表
    @ResponseBody
    @RequestMapping(value = "/getOnlineUserList",method = RequestMethod.GET)
    public List<SysUser> getOnlineUserList(){
        List<Long> userIdList = new ArrayList<>();
        for (Long userId : WebSocketHandler.userSocketSessionMap.keySet()) {
            if (ShiroUtil.getUserId() != userId)// 在线列表中排除本人
                userIdList.add(userId);
        }
        List<SysUser> userList = new ArrayList<>();
        if (!userIdList.isEmpty()){
            SysUserExample example= new SysUserExample();
            example.createCriteria().andIsDelEqualTo(SysUserEnum.isDel.NOMAL.getByteValue()).andIdIn(userIdList);
            userList = sysUserMapper.selectByExample(example);
        }
        return userList;
    }
}
