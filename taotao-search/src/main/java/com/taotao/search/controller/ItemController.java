package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.search.service.ItemService;

/**
 * 向外面提供服务的内容
 * @author fenguriqi
 * 2017年5月15日 下午2:57:44
 * ItemController
 */
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 将所有的数据库信息表内容查询到solr里面
	 * @auther fengruiqi
	 * 2017年5月15日  下午2:57:18
	 * @return
	 */
	@RequestMapping("/importSearch")
	public AnswerResult importAll() {
		try {
			AnswerResult result = itemService.importAllSearch();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}
}
