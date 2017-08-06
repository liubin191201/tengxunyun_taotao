package com.taotao.search.service;

import com.taotao.common.pojo.SearchResultBean;

public interface SearchService {
	
	/**
	 * 查询服务内容
	 * @auther fengruiqi
	 * 2017年5月15日  下午4:19:10
	 * @param queryString
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	SearchResultBean searchResult(String queryString, Long page, Long pageSize) throws Exception;
}
