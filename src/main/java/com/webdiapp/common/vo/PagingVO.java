package com.webdiapp.common.vo;

import com.webdiapp.common.vo.Pagination;

public class PagingVO<T> {
	// 分页数据：pageSize，pageNumber，totalCount等
	private Pagination pagination;
	// 查询出来的分页数据
	private T list;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public T getList() {
		return list;
	}

	public void setList(T list) {
		this.list = list;
	}
}
