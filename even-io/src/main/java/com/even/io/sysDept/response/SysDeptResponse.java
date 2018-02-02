package com.even.io.sysDept.response;

import com.even.io.base.request.BaseRequest;

public class SysDeptResponse extends BaseRequest {
    private Long id;

    private String deptName;

    private Long deptManagerId;

    private String deptManagerName;

    private Long parentId;

    private String parentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Long deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDeptManagerName() {
        return deptManagerName;
    }

    public void setDeptManagerName(String deptManagerName) {
        this.deptManagerName = deptManagerName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}