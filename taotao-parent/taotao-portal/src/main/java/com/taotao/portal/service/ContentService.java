package com.taotao.portal.service;

import java.util.List;

import com.taotao.portal.bean.AdvertiseBean;

/**
 * 大广告页查询
 * @author fenguriqi
 * 2017年5月13日 下午4:26:04
 * ContentService
 */
public interface ContentService {

	/**
	 * 
	 * @auther fengruiqi
	 * 2017年5月13日  下午4:27:09
	 * @param cid
	 * @return
	 */
	public List<AdvertiseBean>  getContentList(Long cid);
}
