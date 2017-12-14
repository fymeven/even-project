package com.even.common.util;

import java.io.Serializable;

/**
 * Created by even on 2017/12/14.
 */
public class PageModel implements Serializable{
    private int rows;//请求行数
    private int page;//请求页码
    private String sidx;//排序参数
    private String sord;//排序方式（ASC,DESC）
    private String search;//搜素参数
    private String orderBy;

    public String getOrderBy() {
        if (orderBy==null){
            this.orderBy=getSidx()+" "+getSord();
        }
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
