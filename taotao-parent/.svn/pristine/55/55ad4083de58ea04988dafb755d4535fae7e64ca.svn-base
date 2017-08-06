package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.portal.bean.ItemBean;
import com.taotao.portal.service.ItemService;

/**
 * 商品详情页展示
 * <p>Title: ItemController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月24日上午11:00:25
 * @version 1.0
 */
@Controller
@RequestMapping("/item/")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 查询商品信息
	 * @auther fengruiqi
	 * 2017年5月23日  上午8:22:28
	 * @param itemId
	 * @param model
	 * @return
	 */
	@RequestMapping("{itemId}")
	private String getItemById(@PathVariable Long itemId, Model model) {
		ItemBean item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "item";
	}
	
	/**
	 * 查询商品描述信息
	 * @auther fengruiqi
	 * 2017年5月23日  上午10:09:32
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value="desc/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	private String getItemDesc(@PathVariable Long itemId) {
		String string = itemService.getItemDesc(itemId);
		return string;
	}
	
	/**
	 * 查询规格参数
	 * @auther fengruiqi
	 * 2017年5月23日  上午10:09:42
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value="param/{itemId}", produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	private String getItemParam(@PathVariable Long itemId) {
		String string = itemService.getItemParam(itemId);
		return string;
	}
	
}
