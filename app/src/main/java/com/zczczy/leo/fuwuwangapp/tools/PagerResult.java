package com.zczczy.leo.fuwuwangapp.tools;

import java.util.List;

/**
 * Created by Leo on 2015/4/29.
 */
public class PagerResult<T> {


    // <summary>
    // 页号
    // </summary>
    public int PageIndex;
    // <summary>
    // 页大小
    // </summary>
    public int PageSize;
    // <summary>
    // 总行数
    // </summary>
    public int RowCount;
    // <summary>
    // 总页数
    // </summary>
    public int PageCount;
    // <summary>
    // 当前页数据
    // </summary>
    public List<T> ListData;


   /* private int PageIndex;

    private int PageSize;

    private int RowCount;

    private int PageCount;

    private List<T> ListData;


    public List<T> getListData() {
        return ListData;
    }

    public void setListData(List<T> listData) {
        ListData = listData;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getRowCount() {
        return RowCount;
    }

    public void setRowCount(int rowCount) {
        RowCount = rowCount;
    }*/
}
