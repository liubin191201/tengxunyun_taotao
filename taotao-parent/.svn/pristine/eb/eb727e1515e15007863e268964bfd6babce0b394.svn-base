package com.taotao.rest.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.rest.bean.ItemCatResultBean;
import com.taotao.rest.service.TbItemCatService;

/**
 * 商品
 * @author fenguriqi
 * 2017年4月16日 上午9:57:55
 * ItemCatAction
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatAction {

	@Autowired
	private TbItemCatService itemCatService;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public Object getItemCatList(String callback) {
		ItemCatResultBean result = itemCatService.getItemCat();
		//判断是否是jsonp调用
		if (StringUtils.isBlank(callback)) {
			return result;
		}
		//jsonp包装
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
		mappingJacksonValue.setJsonpFunction(callback);
		
		return mappingJacksonValue;
	}
}
