package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.portal.bean.CatItemBean;

/**
 * 购物车接口
 * @author fenguriqi
 * 2017年5月24日 下午10:30:02
 * CartService
 */
public interface CartService {
	
	/**
	 * 增加商品到购物车
	 * @auther fengruiqi
	 * 2017年5月26日  下午2:25:02
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return
	 */
	public AnswerResult addCart(Long itemId, Integer num, 
			HttpServletRequest request, HttpServletResponse response);

	
	/**
	 * 展示购物车商品
	 * @auther fengruiqi
	 * 2017年5月26日  下午2:25:14
	 * @param request
	 * @return
	 */
	public List<CatItemBean> getCartItems(HttpServletRequest request);
	
	/**
	 * 修改购物车信息
	 * @auther fengruiqi
	 * 2017年5月26日  下午2:32:04
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return
	 */
	public AnswerResult updateCartItem(long itemId, Integer num, HttpServletRequest request,
			HttpServletResponse response);
	
	/**
	 * 删除购物车信息
	 * @auther fengruiqi
	 * 2017年5月26日  下午2:35:18
	 * @param itemId
	 * @param request
	 * @param response
	 * @return
	 */
	public AnswerResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);

}
