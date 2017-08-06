package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUITreeNodePojo;

/**
 * 内容分类service
 * @author fenguriqi
 * 2017年4月23日 下午8:40:03
 * ContentCatgoryService
 */
public interface ContentCatgoryService {

	/**
	 * 查询内容分类节点信息
	 * @auther fengruiqi
	 * 2017年4月23日  下午8:41:34
	 * @param parentId
	 * @return
	 */
	List<EasyUITreeNodePojo>   getContentCatList(Long parentId);
	
	
	/**
	 * 增加一个节点
	 * @auther fengruiqi
	 * 2017年5月7日  下午4:31:50
	 * @param parentId
	 * @param name
	 * @return
	 */
	AnswerResult   addNode(Long parentId,String name);
	
	/**
	 * 修改重命名
	 * @auther fengruiqi
	 * 2017年5月7日  下午10:14:55
	 * @param parentId
	 * @param name
	 * @return
	 */
	AnswerResult   updateName(Long parentId,String name);
	
	/**
	 * 删除节点
	 * @auther fengruiqi
	 * 2017年5月7日  下午8:52:56
	 * @param parentId
	 * @return
	 */
	public AnswerResult  deleteNode(Long id,Long parentId);
	
	
	
}
