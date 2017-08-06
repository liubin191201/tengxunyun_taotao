package com.taotao.rest.util;

/**
 * redisKeyUtil
 * @author fenguriqi
 * 2017年5月14日 下午8:26:26
 * RedisKeyUtil
 */
public class RedisKeyUtil {

	
	/**广告的缓存*/
	public static final String REDIS_ADVERTIES_CONTENT_KEY="adverties_content_key";

	/**商品基本信息*/
	public static final String ITEM_BASE_INFO_KEY="item_base_info"; 
	
	/**商品描述*/
	public static final String ITEM_DESC_KEY="item_desc";
	
	/**商品规格参数*/
	public static final String ITEM_PARAM_KEY="item_param";
	
	/**redis中商品信息key*/
	public static final String REDIS_ITEM_KEY="redis_item";

	/**商品过期时间*/
	public static final Integer REDIS_EXPIRE_SECOND=86400;
}
