package com.taotao.search.dao;

import com.taotao.common.pojo.SearchResultBean;

import org.apache.solr.client.solrj.SolrQuery;

public interface ItemDao {
	
	/**
	 * 查询item
	 * @auther fengruiqi
	 * 2017年5月15日  下午4:21:10
	 * @param solrQuery
	 * @return
	 * @throws Exception
	 */
	SearchResultBean searchItem(SolrQuery solrQuery) throws Exception;
}
