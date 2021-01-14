package com.webdiapp.common.vo;

public class Pagination {

	private Integer pageSize;
	private Integer curPage;
	private Integer total;

	public Pagination() {}

	public Pagination(Integer curPage, Integer pageSize, Integer totalCount) {
        this.setCurPage(curPage);
        this.setPageSize(pageSize);
        this.setTotal(totalCount);
	}

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
