package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUIDateResult;
import com.taotao.service.ItemParamService;

/**
 * 规格参数列表action
 * @author fenguriqi
 * 2017年4月9日 下午2:52:50
 * ItemParamAction
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamAction {
    
	
	@Autowired
	private ItemParamService  itemParamService;
	
	/**
	 * 查询规格参数列表
	 * @auther fengruiqi
	 * 2017年4月9日  下午4:23:02
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/list")
	public EasyUIDateResult getItemParamList(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		EasyUIDateResult  result=itemParamService.getItemParamList(page, rows)  ;
		return   result ;
	}
	
    
	/**
	 * 保存规格参数
	 * @auther fengruiqi
	 * 2017年4月9日  下午8:58:56
	 * @param paramData
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save/{cid}")
	public AnswerResult add(String paramData,@PathVariable Long cid){
		return itemParamService.add(cid,paramData);
	}
	
	/**
	 * 根据cid查询规格参数
	 * @auther fengruiqi
	 * 2017年4月9日  下午9:58:52
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/cid/{cid}")
	@ResponseBody
	public AnswerResult selectCid(@PathVariable Long cid){
		return itemParamService.selectCid(cid);
	}
	
	/**
	 * 验证；类目是否存在
	 * @auther fengruiqi
	 * 2017年4月9日  下午10:43:14
	 * @param cid
	 * @return
	 */
	@RequestMapping(value="/query/itemcatid/{cid}")
	@ResponseBody
	public AnswerResult checkItem(@PathVariable Long cid){
		return itemParamService.checkItem(cid);
		
	}
	
	
}
