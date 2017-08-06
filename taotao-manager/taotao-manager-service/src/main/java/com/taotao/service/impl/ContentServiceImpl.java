package com.taotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/**
 * 内容实现services
 * @author fenguriqi
 * 2017年5月13日 上午11:10:41
 * ContentServiceImpl
 */
@Service
public class ContentServiceImpl implements ContentService {

	/**
	 * 注入contentmap
	 */
	@Autowired
	private TbContentMapper  tbContentMapper ;
	
	/**
	 * 保存记录到数据库中
	 */
	@Override
	public AnswerResult saveContent(TbContent  bean) {
		bean.setCreated(new Date());
		bean.setUpdated(new Date());

		tbContentMapper.insert(bean);
	
		return AnswerResult.ok();
	}

}
