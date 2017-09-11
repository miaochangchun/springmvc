package com.miao.test.util;

/**
 * Created by 10048 on 2017/9/6.
 * 分页辅助类
 */
public class Page {
    private int curPage;        //当前第几页
    private int perPageRows ;   //每页显示的记录数
    private int rowCount;       //记录数据总数
    private int pageCount;      //总页数

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPerPageRows() {
        return perPageRows;
    }

    public void setPerPageRows(int perPageRows) {
        this.perPageRows = perPageRows;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Page{" +
                "curPage=" + curPage +
                ", perPageRows=" + perPageRows +
                ", rowCount=" + rowCount +
                ", pageCount=" + pageCount +
                '}';
    }
}
