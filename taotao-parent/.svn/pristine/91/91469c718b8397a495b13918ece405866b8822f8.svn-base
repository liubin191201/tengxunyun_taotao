package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.TbContentService;
import com.taotao.rest.util.RedisKeyUtil;

/**
 * 内容查询
 * @author fenguriqi
 * 2017年5月13日 下午1:50:42
 * ContentServiceImple
 */
@Service
public class ContentServiceImple implements TbContentService {

	@Autowired
	private TbContentMapper tbContentMapper;
	
	/**
	 * 注入jedis源
	 */
	@Autowired
	private JedisClient  jedisClient;
	
	/**
	 * 根据cid查询具体信息内容
	 * 1设置查询条件
	 * 2返回查询结果
	 */
	@Override
	public AnswerResult getContentList(Long cid) {
		//添加缓存
		try {
			String result=jedisClient.hget(RedisKeyUtil.REDIS_ADVERTIES_CONTENT_KEY,cid+"");
			if(!StringUtils.isEmpty(result)){
				List<TbContent> listResult=JsonUtils.jsonToList(result, TbContent.class);
				return AnswerResult.ok(listResult);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		TbContentExample  tbContentExample=new TbContentExample();
		Criteria  criteria=tbContentExample.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list=new ArrayList<TbContent>();
		try {
			list=tbContentMapper.selectByExampleWithBLOBs(tbContentExample); 		
			
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
		
		try {
			if(!list.isEmpty()){
				jedisClient.hset(RedisKeyUtil.REDIS_ADVERTIES_CONTENT_KEY, cid+"",JsonUtils.objectToJson(list));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return AnswerResult.ok(list);
	}
	
	/**
	 * 删除缓存数据
	 */
	@Override
	public AnswerResult SynchronizeContent(String cid) {
		/**
		 * 删除缓存数据
		 */
		jedisClient.hdel(RedisKeyUtil.REDIS_ADVERTIES_CONTENT_KEY, cid);
		
		return AnswerResult.ok();
	}

}
