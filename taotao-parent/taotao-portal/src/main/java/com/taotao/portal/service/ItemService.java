package com.taotao.portal.service;

import com.taotao.portal.bean.ItemBean;

public interface ItemService {
	
	/**
	 * 查询商品信息
	 * @auther fengruiqi
	 * 2017年5月23日  上午8:22:41
	 * @param itemId
	 * @return
	 */
	ItemBean getItemById(long itemId);
	
	/**
	 * 查询商品描述
	 * @auther fengruiqi
	 * 2017年5月23日  上午10:11:08
	 * @param itemId
	 * @return
	 */
	String getItemDesc(long itemId);
	/**
	 * 查询商品规格 参数
	 * @auther fengruiqi
	 * 2017年5月23日  上午10:11:18
	 * @param itemId
	 * @return
	 */
	String getItemParam(long itemId);
}
