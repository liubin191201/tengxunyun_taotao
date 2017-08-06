package com.taotao.service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUIDateResult;

/**
 * 查询规格参数列表
 * @author fenguriqi
 * 2017年4月9日 下午3:02:15
 * ItemParamService
 */
public interface ItemParamService {

	
	
	/**
	 * 
	 * @auther fengruiqi
	 * 2017年4月9日  下午3:07:05
	 * @param pages
	 * @param rows
	 * @return
	 */
	public EasyUIDateResult  getItemParamList(Integer pages,Integer rows);
	
	/**
	 * 增加记录
	 * @auther fengruiqi
	 * 2017年4月9日  下午9:00:50
	 * @param id
	 * @param param
	 * @return
	 */
	public AnswerResult add(Long id ,String param);
	
	/**
	 * 根据cid查询数据
	 * @auther fengruiqi
	 * 2017年4月9日  下午9:59:49
	 * @param cid
	 * @return
	 */
	public AnswerResult selectCid(Long cid);  
	
	/**
	 * 验证是否存在目录
	 * @auther fengruiqi
	 * 2017年4月9日  下午10:44:26
	 * @param cid
	 * @return
	 */
	public AnswerResult checkItem(Long cid); 
}
