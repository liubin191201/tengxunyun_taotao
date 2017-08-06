package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemService;

@Controller
@RequestMapping("page")
public class ItemAction {

	@Autowired
	private ItemService  itemService;
	
	/**
	 * 根据id去查询数据
	 * @auther fengruiqi
	 * 2017年4月15日  下午1:13:30
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	private String getItemHtml(@PathVariable Long itemId,Model model) {
		String itemHtml = itemService.getItemParam(itemId);
		model.addAttribute("myHtml", itemHtml);
		return "itemParam";
	}
}
