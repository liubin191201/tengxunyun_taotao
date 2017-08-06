package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUITreeNodePojo;
import com.taotao.service.ContentCatgoryService;

/**
 * 内容分类管理
 * @author fenguriqi
 * 2017年5月7日 下午3:50:07
 * ContentCatAction
 */
@Controller
@RequestMapping(value="/content/category")
public class ContentCatAction {

	/**
	 * 注入
	 */
	@Autowired
	private ContentCatgoryService   contentCatgoryService;
	
	/**
	 * 根据父节点id来查询内容
	 * @auther fengruiqi
	 * 2017年5月7日  下午3:53:16
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public List<EasyUITreeNodePojo>  getContentCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<EasyUITreeNodePojo>  list=contentCatgoryService.getContentCatList(parentId);
		return list;
	}
	
	/**
	 * 创建一个节点
	 * @auther fengruiqi
	 * 2017年5月7日  下午4:30:29
	 * @param parentId
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="create")
	public AnswerResult  add(Long parentId,String name){
		AnswerResult result=contentCatgoryService.addNode(parentId, name);
		return result;
	}
	
	/**
	 * 删除节点 及子节点
	 * @auther fengruiqi
	 * 2017年5月7日  下午10:13:02
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public AnswerResult  delete(Long id,Long parentId){
		AnswerResult  result=contentCatgoryService.deleteNode(id,parentId);
		return result;
	}
	
	/**
	 * 重命名
	 * @auther fengruiqi
	 * 2017年5月7日  下午10:13:51
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public 	AnswerResult  update(Long id,String name){
		AnswerResult result=contentCatgoryService.updateName(id,name);
		return result;
	}
}
