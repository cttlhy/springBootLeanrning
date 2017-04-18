package com.cc.sys.core.util;

import java.io.Serializable;
import java.util.Collection;

import com.github.pagehelper.Page;

/**
 * 分页查询结束后将对应的查询结果封装成QueryResponseBean对象
 * @author chenchao
 *
 * @param <T>
 */
public class QueryResponseBean<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private PageParameter pageParameter = null;
	private Page<T> result = null;

	public QueryResponseBean() {
	}

	public QueryResponseBean(PageParameter pageParameter, Page<T> result) {
		this.pageParameter = pageParameter;
		this.result = result;
	}

	public PageParameter getPageParameter() {
		if (this.pageParameter == null) {
			this.pageParameter = new PageParameter();
		}
		return this.pageParameter;
	}

	public void setPageParameter(PageParameter pageParameter) {
		this.pageParameter = pageParameter;
	}

	public Page<T> getResult() {
		return this.result;
	}

	public void setResult(Page<T> result) {
		if ((result != null) && (this.pageParameter == null)) {
			this.pageParameter = new PageParameter();
			this.pageParameter.setPage(result.getPageNum());
			this.pageParameter.setRows(result.getPageSize());
			this.pageParameter.setTotalCount(result.getTotal());
			this.pageParameter.setTotalPage(result.getPages());
		}
		this.result = result;
	}

	public void setResult(Collection<T> result, String jvm7Flag) {
		this.result = ((Page<T>) result);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryRespBean [pageParameter=");
		builder.append(this.pageParameter);
		builder.append(", result=");
		builder.append(this.result);
		builder.append("]");
		return builder.toString();
	}
}
