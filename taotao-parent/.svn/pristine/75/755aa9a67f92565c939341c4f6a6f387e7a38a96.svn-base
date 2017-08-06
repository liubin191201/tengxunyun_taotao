package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.rest.service.ItemService;

/**
 * 商品信息管理
 * @author fenguriqi
 * 2017年5月23日 上午8:34:57
 * ItemController
 */
@RequestMapping("/item")
@RestController
public class ItemAnction {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 查询商品基本信息
	 * @auther fengruiqi
	 * 2017年5月22日  下午8:42:39
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/id/{itemId}")
	public AnswerResult getItemById(@PathVariable Long itemId) {
		try {
			TbItem tbItem = itemService.getItem(itemId);
			return AnswerResult.ok(tbItem);
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}
	
	/**
	 *查询商品描述详情 
	 * @auther fengruiqi
	 * 2017年5月22日  下午9:08:25
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/desc/{itemId}")
	public AnswerResult getItemDescById(@PathVariable Long itemId) {
		try {
			TbItemDesc itemDesc = itemService.getItemDesc(itemId);
			return AnswerResult.ok(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}
	
	/**
	 * 查询商品规格
	 * @auther fengruiqi
	 * 2017年5月22日  下午9:08:53
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/param/{itemId}")
 	public AnswerResult getItemParamById(@PathVariable Long itemId) {
		try {
			
			TbItemParamItem itemParamItem = itemService.getItemParam(itemId);
			return AnswerResult.ok(itemParamItem);
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}
	
}
