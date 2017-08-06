package com.taotao.search.mapper;


import java.util.List;

import com.taotao.search.bean.SearchBean;

public interface ItemMapper {
	
	/**
	 * 查询数据
	 * @auther fengruiqi
	 * 2017年5月15日  下午2:28:47
	 * @return
	 */
	List<SearchBean> getItemList();
}
