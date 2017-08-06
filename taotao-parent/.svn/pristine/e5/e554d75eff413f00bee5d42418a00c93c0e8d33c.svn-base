package com.taotao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.SearchResultBean;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.portal.base.BaseService;
import com.taotao.portal.service.SearchService;



/**
 * 查询服务
 * <p>Title: SearchServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月22日下午4:51:50
 * @version 1.0
 */
@Service
public class SearchServiceImpl extends BaseService implements SearchService {

	@Override
	public SearchResultBean search(String queryString, Long page, Long rows) {
		//创建查询参数
		Map<String, String> param = new HashMap<>();
		param.put("queryString", queryString);
		param.put("page", page + "");
		param.put("rows", rows+"");
		//调用taotao-search的服务进行搜索
		String json = HttpClientUtil.doGet(super.SELECT_SEARCH_LIST, param);
		AnswerResult result = AnswerResult.format(json);
		if (result.getStatus() == 200) {
			AnswerResult result2 = AnswerResult.formatToPojo(json, SearchResultBean.class);
			SearchResultBean searchResult = (SearchResultBean) result2.getData();
			return searchResult;
		}
		
		return new SearchResultBean();
		
	}

	
	

}
