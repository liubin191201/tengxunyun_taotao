package com.taotao.order.service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.order.bean.OrderInfoBean;

public interface OrderService {

	/**
	 * 创建订单
	 * @auther fengruiqi
	 * 2017年5月27日  上午8:24:58
	 * @param orderInfo
	 * @return
	 */
	public AnswerResult createOrder(OrderInfoBean orderInfo) ;
}
