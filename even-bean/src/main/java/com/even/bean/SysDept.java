package com.even.bean;

public class SysDept {
    private Long id;

    private String deptName;

    private Long deptManageId;

    private Long parentId;

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

    public Long getDeptManageId() {
        return deptManageId;
    }

    public void setDeptManageId(Long deptManageId) {
        this.deptManageId = deptManageId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}