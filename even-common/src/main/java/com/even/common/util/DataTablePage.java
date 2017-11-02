package com.even.common.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by even on 2017/11/2.
 */
public class DataTablePage<T> {
    private int draw;  //请求
    private int recordsTotal; //总记录数
    private int recordsFiltered;   //过滤之后，实际的行数
    private List<T> aaData; //返回数据

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

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> data) {
        this.aaData = aaData;
    }

    public DataTablePage(PageInfo pageInfo){
        setRecordsTotal(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        setRecordsTotal(recordsFiltered);
        setAaData(pageInfo.getList());
    }
}
