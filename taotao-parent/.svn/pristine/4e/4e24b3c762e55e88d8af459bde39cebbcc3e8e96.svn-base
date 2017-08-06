package com.taotao.portal.service.impl;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.portal.base.BaseService;
import com.taotao.portal.bean.OrderInfoBean;
import com.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	/**
	 * 创建订单
	 */
	@Override
	public String createOrder(OrderInfoBean orderInfo) {
		//把OrderInfo转换成json
		String json = JsonUtils.objectToJson(orderInfo);
		//提交订单数据
		String jsonResult = HttpClientUtil.doPostJson(BaseService.ORDER_CREATE_URL, json);
		//转换成java对象
		AnswerResult taotaoResult = AnswerResult.format(jsonResult);
		//取订单号
		String orderId = taotaoResult.getData().toString();
		return orderId;
	}


}
