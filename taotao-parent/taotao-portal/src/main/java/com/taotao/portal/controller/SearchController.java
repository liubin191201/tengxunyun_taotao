package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotao.common.pojo.SearchResultBean;
import com.taotao.portal.service.SearchService;

/**
 * 商品搜索
 * @author fenguriqi
 * 2017年5月15日 下午6:40:18
 * SearchController
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/search")
	public String search( @RequestParam("q") String queryString, 
			@RequestParam(defaultValue="1") Long page,
			@RequestParam(defaultValue="60")Long rows
			,Model model) throws Exception {
		//解决乱码问题 
		queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
		SearchResultBean searchResult = searchService.search(queryString, page,rows);
		model.addAttribute("query", queryString);
		model.addAttribute("totalPages", searchResult.getPageCount());
		model.addAttribute("itemList", searchResult.getList());
		model.addAttribute("page", searchResult.getPageNum());
		
		return "search";
	}
}
