package com.taotao.portal.service;

import com.taotao.portal.bean.OrderInfoBean;

public interface OrderService {

	/**
	 * 创建订单
	 * @auther fengruiqi
	 * 2017年5月27日  下午2:29:48
	 * @param orderInfo
	 * @return
	 */
	public String createOrder(OrderInfoBean orderInfo);
}
