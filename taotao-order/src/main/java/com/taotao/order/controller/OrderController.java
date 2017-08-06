package com.taotao.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.order.bean.OrderInfoBean;
import com.taotao.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/create", method=RequestMethod.POST)
	@ResponseBody
	public AnswerResult createOrder(@RequestBody OrderInfoBean orderInfo) {
		try {
			AnswerResult result = orderService.createOrder(orderInfo);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}

}
