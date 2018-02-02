package com.even.service;

import com.even.bean.SysDept;
import com.even.common.util.ResponseResult;
import com.even.io.sysDept.request.SysDeptRequest;
import com.even.model.JsTree;

/**
 * Created by fymeven on 2017/10/28.
 */
public interface ISysDeptService {

    ResponseResult add(SysDeptRequest sysDeptRequest);

    ResponseResult update(SysDeptRequest sysDeptRequest);

    ResponseResult delete(Long id);

    SysDept detail(Long id);

    JsTree getDeptTree(SysDeptRequest sysDeptRequest);

    ResponseResult list();
}
