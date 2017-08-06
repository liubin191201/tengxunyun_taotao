package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.base.BaseAction;
import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容管理action
 * @author fenguriqi
 * 2017年5月13日 上午11:34:33
 * ContentAction
 */
@Controller
@RequestMapping("content")
public class ContentAction extends BaseAction{

	@Autowired
	private ContentService   contentService;
	
	/**
	 * 新增内容到数据库汇总
	 * @auther fengruiqi
	 * 2017年5月13日  上午11:35:47
	 * @param bean
	 * @return
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public AnswerResult  save(TbContent  bean){
		
		AnswerResult  result=contentService.saveContent(bean);
		
		HttpClientUtil.doGet(super.DELETE_CONTENT_SYNC_KEY+bean.getCategoryId());
		return result;
	}
	
}
