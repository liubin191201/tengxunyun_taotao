package com.taotao.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.SearchResultBean;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.search.service.SearchService;

/**
 * 发布服务
 * @author fenguriqi
 * 2017年5月15日 下午5:10:12
 * SearchController
 */
@RestController
@RequestMapping(value="selectSearch")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/q")
	public AnswerResult search(@RequestParam(defaultValue="kw")String queryString, @RequestParam(defaultValue="1")Long page, @RequestParam(defaultValue="60")Long pageSize) {
		if (StringUtils.isBlank(queryString)) {
			return AnswerResult.build(400, "查询条件不能为空");
		}
		try {
			//解决get乱码问题
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			SearchResultBean searchResult = searchService.searchResult(queryString, page, pageSize);
			return AnswerResult.ok(searchResult);
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
		
	}
}
