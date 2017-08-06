package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面展示
 * @author fengruiqi
 *
 */
@Controller
public class PageController {

	
	/**
	 * 展示首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndexContent(){
		return "index";
	}
	@RequestMapping("{page}")
	public String showAllPage(@PathVariable String page){
		return page;
		
	}
	
	
}
