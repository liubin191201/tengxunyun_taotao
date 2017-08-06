package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;

/**
 * 查询商品信息Service
 * @author fenguriqi
 * 2017年5月22日 下午7:41:42
 * ItemService
 */
public interface ItemService {

	/**
	 * 根据商品id 查询商品信息
	 * @auther fengruiqi
	 * 2017年5月22日  下午7:42:10
	 * @param itemId
	 * @return
	 */
	TbItem getItem(Long itemId);
	
	/**
	 *查询商品描述详情 
	 * @auther fengruiqi
	 * 2017年5月22日  下午9:08:25
	 * @param itemId
	 * @return
	 */
	TbItemDesc getItemDesc(long itemId);
	/**
	 * 查询商品规格
	 * @auther fengruiqi
	 * 2017年5月22日  下午9:08:53
	 * @param itemId
	 * @return
	 */
	TbItemParamItem getItemParam(long itemId);
}
