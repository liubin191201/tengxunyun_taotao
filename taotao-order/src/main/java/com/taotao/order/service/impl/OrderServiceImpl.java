package com.taotao.order.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.mapper.TbOrderItemMapper;
import com.taotao.mapper.TbOrderMapper;
import com.taotao.mapper.TbOrderShippingMapper;
import com.taotao.order.bean.OrderInfoBean;
import com.taotao.order.dao.JedisClient;
import com.taotao.order.service.OrderService;
import com.taotao.order.util.RedisKeyUtil;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**
 * 订单service
 * @author fenguriqi
 * 2017年5月27日 上午8:25:48
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderItemMapper orderItemMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Autowired
	private JedisClient jedisClient;

	
	
	@Override
	public AnswerResult createOrder(OrderInfoBean orderInfo) {
		String id = jedisClient.get(RedisKeyUtil.REDIS_ORDER_GEN_KEY);
		if (StringUtils.isBlank(id)) {
			//如果订单号生成key不存在设置初始值
			jedisClient.set(RedisKeyUtil.REDIS_ORDER_GEN_KEY,RedisKeyUtil.ORDER_ID_BEGIN);
		}
		Long orderId = jedisClient.incr(RedisKeyUtil.REDIS_ORDER_GEN_KEY);
		// 3、补全字段
		orderInfo.setOrderId(orderId.toString());
		//状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
		orderInfo.setStatus(1);
		Date date = new Date();
		orderInfo.setCreateTime(date);
		orderInfo.setUpdateTime(date);
		// 4、插入订单表
		orderMapper.insert(orderInfo);
		// 二、插入订单明细
		// 2、补全字段
		List<TbOrderItem> orderItems = orderInfo.getOrderItems();
		for (TbOrderItem orderItem : orderItems) {
			// 1、生成订单明细id，使用redis的incr命令生成。
			Long detailId = jedisClient.incr(RedisKeyUtil.REDIS_ORDER_DETAIL_GEN_KEY);
			orderItem.setId(detailId.toString());
			//订单号
			orderItem.setOrderId(orderId.toString());
			// 3、插入数据
			orderItemMapper.insert(orderItem);
		}
		// 三、插入物流表
		TbOrderShipping orderShipping = orderInfo.getOrderShipping();
		// 1、补全字段
		orderShipping.setOrderId(orderId.toString());

		orderShipping.setCreated(date);
		orderShipping.setUpdated(date);
		// 2、插入数据
		orderShippingMapper.insert(orderShipping);
		// 返回TaotaoResult包装订单号。
		return AnswerResult.ok(orderId);

	}

}
