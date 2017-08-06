package com.taotao.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.base.BaseConfig;
import com.taotao.portal.bean.AdvertiseBean;
import com.taotao.portal.service.ContentService;


/**
 * 
 * @author fenguriqi
 * 2017年4月15日 下午7:10:55
 * IndexAction
 */
@Controller
public class IndexAction extends BaseConfig{

	@Autowired
	private ContentService   contentService;
	
	
	/**
	 * 首页大广告展示
	 * @auther fengruiqi
	 * 2017年4月15日  下午7:11:46
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		
		List<AdvertiseBean>  list=contentService.getContentList(Long.parseLong(super.CONTENT_ADVERTIES_CID));
		String json=JsonUtils.objectToJson(list);
		model.addAttribute("ad1", json);
		return "index";
	}
}
