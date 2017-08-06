package com.taotao.portal.base;



/**
 * 常量配置文件
 * @author fenguriqi
 * 2017年5月13日 下午4:47:54
 * BaseConfig
 */
public class BaseService {


	
	/**
	 * 基本链接 本地开发
	 */
	public static final String  BASE_URL="http://localhost:8081/rest/";
	
	/**
	 * sso系统的基础http
	 */
	public static final String  SSO_BASE_URL="http://localhost:8084/";
	
	/**
	 * 订单服务系统
	 */
	public static final String  ORDER_BASE_URL="http://localhost:8085/";
	
	/**
	 * 查询用户信息token
	 */
	public static final String SSO_USER_TOKEN_SERVICE=SSO_BASE_URL+"user/token/";
	
	/**
	 * solr服务
	 */
	public static final String  SOlR_BASE_URL="http://localhost:8083/search/";
	/**
	 * 查询大广告页链接
	 */
	public static final String  SELECT_CONTENT_INDEX=BASE_URL+"content/";
	
	
	/**
	 * 查询商品信息链接
	 */
	public static final String SELECT_SEARCH_LIST=SOlR_BASE_URL+"selectSearch/q";

	/**
	 * 查询商品信息
	 */
	public static final String REST_ITEM_ID_URL=BASE_URL+"item/id/";
	
	/**
	 * 查询商品描述
	 */
	public static final String REST_ITEM_DESC_URL=BASE_URL+"item/desc/";
	
	/**
	 * 查询产品规格参数
	 */
	public static final String REST_ITEM_PARAM_URL=BASE_URL+"item/param/";
	
	/**
	 * 登录页面
	 */
	public static final String SSO_LOGIN_URL="http://localhost:8084/user/page/login";
	
	/**
	 * 创建订单链接
	 */
	public static final String ORDER_CREATE_URL=ORDER_BASE_URL+"order/create";

}
