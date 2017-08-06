package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ConstantUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbContent;
import com.taotao.portal.base.BaseService;
import com.taotao.portal.bean.AdvertiseBean;
import com.taotao.portal.service.ContentService;


/**
 * 查询大广告内容
 * @author fenguriqi
 * 2017年5月13日 下午4:41:20
 * ContentServiceImpl
 */
@Service
public class ContentServiceImpl extends BaseService implements ContentService {
	
	
	
	/**
	 * 查询打广告内容
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	@Override
	public List<AdvertiseBean> getContentList(Long cid) {
		String resStr=HttpClientUtil.doGet(super.SELECT_CONTENT_INDEX+cid);
		
		AnswerResult result=AnswerResult.formatToList(resStr, TbContent.class);
		List<AdvertiseBean> list=new ArrayList<AdvertiseBean>();
		if(result.getStatus()==200){
			List<TbContent> listContent=(List<TbContent>) result.getData();
			for(TbContent content:listContent){

				AdvertiseBean bean=new AdvertiseBean();
				bean.setSrc(content.getPic());
				bean.setHeight(ConstantUtils.ADVERTISE_INDEX_HEIGHT);
				bean.setWidth(ConstantUtils.ADVERTISE_INDEX_WIDTH);
				bean.setHeightB(ConstantUtils.ADVERTISE_INDEX_HEIGHT);
				bean.setWidthB(ConstantUtils.ADVERTISE_INDEX_WIDTH);
				bean.setSrcB(content.getPic2());
				bean.setHref(content.getContent());
				bean.setAlt(content.getTitle());
				list.add(bean);
			}
			
		}
		
		
		return list;
	}

}
