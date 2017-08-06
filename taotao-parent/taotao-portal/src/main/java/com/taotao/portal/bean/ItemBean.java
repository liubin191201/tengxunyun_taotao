package com.taotao.portal.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taotao.pojo.TbItem;
import org.apache.commons.lang3.StringUtils;

public class ItemBean extends TbItem {
	
	private Integer cartItemNum;
	
	
	public Integer getCartItemNum() {
		return cartItemNum;
	}


	public void setCartItemNum(Integer cartItemNum) {
		this.cartItemNum = cartItemNum;
	}


	@JsonIgnore
	public String[] getImages() {
		String image2 = this.getImage();
		if (StringUtils.isBlank(image2)) {
			return null;
		}
		String[] images = image2.split(",");
		return images;
	}
}
