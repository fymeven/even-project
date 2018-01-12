package com.even.bean;

import java.util.Date;

public class SysLog {
    private Long id;

    private Date operateTime;

    private Long operateUserId;

    private String opreateIp;

    private String logContent;

    private Integer logType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Long operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getOpreateIp() {
        return opreateIp;
    }

    public void setOpreateIp(String opreateIp) {
        this.opreateIp = opreateIp == null ? null : opreateIp.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }
}