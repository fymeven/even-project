package com.even.common.util;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by even on 2017/11/2.
 */
public class JqGridTablePage<T> implements Serializable {
    private int currentPage;  //当前页
    private int totalPage; //总页数
    private int totalRecords;   //总记录数
    private List<T> data; //返回数据

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public JqGridTablePage(Page<T> page) {

    }
}
