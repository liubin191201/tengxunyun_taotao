package com.taotao.order.bean;

import java.util.List;

import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**
 * 订单bean
 * @author fenguriqi
 * 2017年5月27日 上午8:23:38
 * OrderInfoBean
 */
public class OrderInfoBean  extends TbOrder{
	/**
	 * 订单信息
	 */
	private List<TbOrderItem> orderItems;
	
	/**
	 * 订单商品信息
	 */
	private TbOrderShipping orderShipping;
	
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}

}
