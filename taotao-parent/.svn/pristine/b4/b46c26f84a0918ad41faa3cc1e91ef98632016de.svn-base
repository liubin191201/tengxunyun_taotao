package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.rest.service.TbContentService;

/**
 * 返回content内容
 * @author fenguriqi
 * 2017年5月13日 下午2:01:27
 * ContentAction
 */
@RestController
@RequestMapping("content")
public class ContentAction {

	/**
	 * 注入contentService
	 */
	@Autowired
	private TbContentService   tbContentService;
	
	/**
	 * 查询内容公告
	 * @auther fengruiqi
	 * 2017年5月13日  下午2:04:46
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value="/{categoryId}")
	public AnswerResult getContentList(@PathVariable  Long categoryId){
		AnswerResult  result=tbContentService.getContentList(categoryId);
		return result;
	}
	
	/**
	 * 删除缓存同步
	 * @auther fengruiqi
	 * 2017年5月14日  下午9:11:54
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/sync/{cid}")
	public AnswerResult  SynchronizeContent(@PathVariable Long cid){
		String id=cid+"";
		return tbContentService.SynchronizeContent(id);
	}
	
}
