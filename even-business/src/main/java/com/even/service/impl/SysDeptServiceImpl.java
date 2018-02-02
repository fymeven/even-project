package com.even.service.impl;

import com.even.bean.SysDept;
import com.even.bean.SysDeptExample;
import com.even.common.util.BeanCopyUtil;
import com.even.common.util.JsTreeBuildFactory;
import com.even.common.util.ResponseResult;
import com.even.dao.SysDeptMapper;
import com.even.io.sysDept.request.SysDeptRequest;
import com.even.model.JsTree;
import com.even.service.ISysDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("sysDeptServiceImpl")
public class SysDeptServiceImpl implements ISysDeptService {
    @Resource
    private SysDeptMapper sysDeptMapper;

    @Override
    public ResponseResult add(SysDeptRequest sysDeptRequest) {
        SysDept sysDept = new SysDept();
        BeanCopyUtil.copyProperties(sysDept,sysDeptRequest);
        int result = sysDeptMapper.insert(sysDept);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult update(SysDeptRequest sysDeptRequest) {
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(sysDeptRequest.getId());
        BeanCopyUtil.copyProperties(sysDept,sysDeptRequest);
        int result = sysDeptMapper.updateByPrimaryKey(sysDept);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public ResponseResult delete(Long id) {
        int result = sysDeptMapper.deleteByPrimaryKey(id);
        return result>0 ? ResponseResult.SUCCESS : ResponseResult.ERROR;
    }

    @Override
    public SysDept detail(Long id) {
        return sysDeptMapper.selectByPrimaryKey(id);
    }

    @Override
    public JsTree getDeptTree(SysDeptRequest sysDeptRequest) {
        List<SysDept> sysDepts = sysDeptMapper.selectByExample(new SysDeptExample());
        List<JsTree> nodes=new ArrayList<>();
        for (SysDept sysDept : sysDepts) {
            JsTree node=new JsTree();
            node.setId(sysDept.getId().toString());
            node.setText(sysDept.getDeptName());
            node.setParentId(sysDept.getParentId().toString());
            nodes.add(node);
        }
        return JsTreeBuildFactory.buildRoot(nodes, JsTreeBuildFactory.RootEnum.DEPT);
    }

    @Override
    public ResponseResult list() {
        List<SysDept> sysDepts = sysDeptMapper.selectByExample(new SysDeptExample());
        return ResponseResult.SUCCESS(sysDepts);
    }
}
