package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUITreeNodePojo;
import com.taotao.common.utils.ConstantUtils;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentCatgoryService;

/**
 * 内容分类service
 * @author fenguriqi
 * 2017年4月23日 下午8:42:24
 * ContentCatgoryServiceImpl
 */
@Service
public class ContentCatgoryServiceImpl implements ContentCatgoryService {

	/**
	 * 注入map
	 */
	@Autowired
	private TbContentCategoryMapper    tbContentCategoryMapper;
	
	/**
	 * 查询节点
	 */
	@Override
	public List<EasyUITreeNodePojo> getContentCatList(Long parentId) {
		TbContentCategoryExample  example=new TbContentCategoryExample();
		Criteria  criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list=tbContentCategoryMapper.selectByExample(example);
		List<EasyUITreeNodePojo> resulList=new ArrayList<>();
		
		for(TbContentCategory  node:list){
			EasyUITreeNodePojo nodeList=new EasyUITreeNodePojo(node.getId(),node.getName(),node.getIsParent()?"closed":"open");
			resulList.add(nodeList);
		}
		
		return resulList;
		
	}

	/**
	 * 增加一个节点
	 */
	@Override
	public AnswerResult addNode(Long parentId, String name) {
		TbContentCategory  bean=new TbContentCategory();
		bean.setName(name);
		bean.setIsParent(false);
		bean.setParentId(parentId);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		bean.setSortOrder(ConstantUtils.CONTENT_SORT_ORDER_FIRST);
		
		bean.setStatus(ConstantUtils.CONTENT_STATUS_NORMAL);
		bean.setUpdated(new Date());
		bean.setCreated(new Date());
		
		/**插库*/
		tbContentCategoryMapper.insert(bean);
		TbContentCategory parentNode = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		if (!parentNode.getIsParent()) {
			parentNode.setIsParent(true);
			//更新父节点isParent列
			tbContentCategoryMapper.updateByPrimaryKey(parentNode);
		}
		
		Long id=bean.getId();
		return AnswerResult.ok(id);
		
	}

	/**
	 * 根据节点id删除信息
	 */
	@Override
	public AnswerResult deleteNode(Long id,Long parentId) {
		
		TbContentCategory bean=tbContentCategoryMapper.selectByPrimaryKey(id);
		if(bean.getIsParent()){
			TbContentCategoryExample example=new TbContentCategoryExample();
			Criteria  criteria=example.createCriteria();
			criteria.andParentIdEqualTo(id);
			tbContentCategoryMapper.deleteByExample(example);
		}
			tbContentCategoryMapper.deleteByPrimaryKey(id);
		return AnswerResult.ok();
	}
	
	/**
	 * 重命名
	 */
	@Override
	public AnswerResult updateName(Long id, String name) {
		TbContentCategory  bean=new TbContentCategory();
		bean.setId(id);
		bean.setName(name);
		tbContentCategoryMapper.updateByPrimaryKeySelective(bean);
		
		return AnswerResult.ok();
	}

}
