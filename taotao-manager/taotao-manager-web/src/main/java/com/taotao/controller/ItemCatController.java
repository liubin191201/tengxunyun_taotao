package com.taotao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNodePojo;
import com.taotao.service.ItemCatService;

/**
 * action
 * @author fenguriqi
 * 2017年1月22日 下午9:58:25
 * ItemController
 */
@RequestMapping("item/cat")
@Controller
public class ItemCatController {
 
	@Autowired
	private ItemCatService itemCatService;
	
	
	/**
	 * 查询商品类目
	 * @auther fengruiqi
	 * 2017年2月3日  下午10:05:21
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")  
	@ResponseBody
	public  List<EasyUITreeNodePojo>  getItemCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<EasyUITreeNodePojo> listPojo=itemCatService.getItemCatList(parentId);
		return listPojo;
	}
	
	
	
}
