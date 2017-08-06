package com.taotao.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.portal.bean.CatItemBean;
import com.taotao.portal.service.CartService;

/**
 * 跳转到购物车
 * @author fenguriqi
 * 2017年5月24日 下午10:42:36
 * CartAction
 */
@Controller
public class CartAction {
	

		@Autowired
		private CartService cartService;
		
		/**
		 * 添加购物车商品信息
		 * @auther fengruiqi
		 * 2017年5月26日  下午2:28:51
		 * @param itemId
		 * @param num
		 * @param response
		 * @param request
		 * @return
		 */
		@SuppressWarnings("unused")
		@RequestMapping("/cart/add/{itemId}")
		public String addCart(@PathVariable Long itemId, Integer itemNum,
				HttpServletResponse response, HttpServletRequest request) {
			AnswerResult result = cartService.addCart(itemId, itemNum, request, response);
			return "cart-success";
		}
		
		/**
		 * 展示购物车信息
		 * @auther fengruiqi
		 * 2017年5月26日  下午2:29:21
		 * @param request
		 * @param model
		 * @return
		 */
		@RequestMapping("/cart/cart")
		public String showCartList(HttpServletRequest request, Model model) {
			List<CatItemBean> list = cartService.getCartItems(request);
			//把商品列表传递给jsp
			model.addAttribute("cartList", list);
			return "cart";
		}
		
		/**
		 * 修改购物车信息数量
		 * @auther fengruiqi
		 * 2017年5月26日  下午2:31:22
		 * @param itemId
		 * @param num
		 * @param response
		 * @param request
		 * @return
		 */
		@RequestMapping("/cart/update/num/{itemId}/{num}")
		@ResponseBody
		public AnswerResult updateCartItemNum(@PathVariable Long itemId, @PathVariable Integer num,
				HttpServletResponse response, HttpServletRequest request) {
			AnswerResult result = cartService.updateCartItem(itemId, num, request, response);
			return result;
		}


}
