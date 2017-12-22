package com.even.bean;

public class SysDept {
    private Long id;

    private String deptName;

    private Long deptLeaderId;

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

    public Long getDeptLeaderId() {
        return deptLeaderId;
    }

    public void setDeptLeaderId(Long deptLeaderId) {
        this.deptLeaderId = deptLeaderId;
    }
}