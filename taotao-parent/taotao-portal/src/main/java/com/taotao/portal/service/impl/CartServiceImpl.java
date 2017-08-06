package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.portal.base.BaseConfig;
import com.taotao.portal.bean.CatItemBean;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.ItemService;

/**
 * 购物车servcice
 * @author fenguriqi
 * 2017年5月24日 下午10:31:25
 * CartServiceImpl
 */
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private ItemService itemService;
	
	
	/**
	 * 添加商品到购物车中
	 */
	@Override
	public AnswerResult addCart(Long itemId, Integer num, 
			HttpServletRequest request, HttpServletResponse response) {
		// 1、接收商品id
		// 2、从cookie中购物车商品列表
		List<CatItemBean> itemList = getCartItemList(request);
		// 3、从商品列表中查询列表是否存在此商品
		boolean haveFlg = false;
		for (CatItemBean cartItem : itemList) {
			//如果商品存在数量相加
			
			if(cartItem.getNum()==null){
				cartItem.setNum(0);
			}
			
			// 4、如果存在商品的数量加上参数中的商品数量
			if (cartItem.getId().longValue() == itemId) {
				cartItem.setNum(cartItem.getNum() + num);
				haveFlg = true;
				break;
			}
		}
		// 5、如果不存在，调用rest服务，根据商品id获得商品数据。
		if (!haveFlg) {
			TbItem item = itemService.getItemById(itemId);
			//转换成CartItem
			CatItemBean cartItem = new CatItemBean();
			cartItem.setId(itemId);
			cartItem.setNum(num);
			cartItem.setPrice(item.getPrice());
			cartItem.setTitle(item.getTitle());
			if (StringUtils.isNotBlank(item.getImage())) {
				String image = item.getImage();
				String[] strings = image.split(",");
				cartItem.setImage(strings[0]);
			}
			//添加到购物车商品列表
			// 6、把商品数据添加到列表中
			itemList.add(cartItem);
		}
		// 7、把购物车商品列表写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), BaseConfig.COOKIE_EXPIRE, true);
		// 8、返回TaotaoResult
		return AnswerResult.ok();
	}
	
	/**
	 *  取购物车商品列表
	 * @auther fengruiqi
	 * 2017年5月24日  下午10:33:49
	 * @param request
	 * @return
	 */
	private List<CatItemBean> getCartItemList(HttpServletRequest request) {
		try {
			//从cookie中取商品列表
			String json = CookieUtils.getCookieValue(request, "TT_CART", true);
			//把json转换成java对象
			List<CatItemBean> list = JsonUtils.jsonToList(json, CatItemBean.class);
			
			return list==null?new ArrayList<CatItemBean>():list;
			
		} catch (Exception e) {
			return new ArrayList<CatItemBean>();
		}
		
	}
	
	/**
	 * 展示购物车商品信息
	 */
	@Override
	public List<CatItemBean> getCartItems(HttpServletRequest request) {
		List<CatItemBean> list = getCartItemList(request);
		return list;

	}
	
	/**
	 * 修改购物车信息
	 */
	@Override
	public AnswerResult updateCartItem(long itemId, Integer num, HttpServletRequest request,
			HttpServletResponse response) {
		// 从cookie中取购物车商品列表
		List<CatItemBean> itemList = getCartItemList(request);
		//根据商品id查询商品
		for (CatItemBean cartItem : itemList) {
			if (cartItem.getId() == itemId) {
				//更新数量
				cartItem.setNum(num);
				break;
			}
		}
		//写入cookie
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), BaseConfig.COOKIE_EXPIRE, true);
		return AnswerResult.ok();
	}
	
	/**
	 * 删除购物车信息
	 */
	@Override
	public AnswerResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
		// 1、接收商品id
		// 2、从cookie中取购物车商品列表
		List<CatItemBean> itemList = getCartItemList(request);
		// 3、找到对应id的商品
		for (CatItemBean cartItem : itemList) {
			if (cartItem.getId() == itemId) {
				// 4、删除商品。
				itemList.remove(cartItem);
				break;
			}
		}
		// 5、再重新把商品列表写入cookie。
		CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(itemList), BaseConfig.COOKIE_EXPIRE, true);
		// 6、返回成功
		return AnswerResult.ok();

	}


}

