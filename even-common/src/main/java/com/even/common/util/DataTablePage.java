package com.even.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by even on 2017/11/2.
 */
public class DataTablePage<T> {
    private int draw;  //请求
    private int recordsTotal; //总记录数
    private int recordsFiltered;   //过滤之后，实际的行数
    private List<T> data; //返回数据

    private int start; //起始页
    private int length; //每页记录数

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DataTablePage(){
        super();
    }

    public DataTablePage(Page<T> page) {
        //使用PageInfo封装
        PageInfo<T> pageInfo = new PageInfo(page);
        setRecordsTotal(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        setRecordsFiltered(recordsTotal);
        setData(pageInfo.getList());
    }

    public DataTablePage(PageInfo pageInfo){
        setRecordsTotal(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        setRecordsFiltered(recordsTotal);
        setData(pageInfo.getList());
    }
}
