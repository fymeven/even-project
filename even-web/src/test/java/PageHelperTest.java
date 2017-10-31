import com.even.bean.SysUser;
import com.even.io.sysUser.request.SysUserRequest;
import com.even.service.ISysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration("classpath:spring/spring-application.xml")
//无论成功与否都进行事务回滚
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class PageHelperTest {
    private static final Logger logger= LogManager.getLogger(PageHelperTest.class.getName());

    @Resource
    private ISysUserService sysUserService;

    @Test
    public void testSelectAll() {
        Page<SysUserRequest> page = PageHelper.startPage(1, 3);
        //selectAll查询出的List即为上面定义的page
        List<SysUser> list= sysUserService.selectAllUser();
        //注意：
        //使用PageHelper.startPage只是针对接下来的一条查询语句，
        //如果又查询了一次数据，则还需要使用一次PageHelper.startPage
        //使用PageInfo封装
        PageInfo<SysUserRequest> info = new PageInfo<SysUserRequest>(page);
        logger.info("info.getPages:{}" + info.getPages());
    }
}
