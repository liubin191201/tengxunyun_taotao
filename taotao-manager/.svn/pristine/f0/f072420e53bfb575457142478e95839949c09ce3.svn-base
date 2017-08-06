package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.pojo.EasyUIDateResult;
import com.taotao.common.utils.ConstantUtils;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

/**
 * 查询商品参数列表
 * @author fenguriqi
 * 2017年4月9日 下午3:21:16
 * ItemParamServiceImpl
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired
	private TbItemParamMapper   itemParamMapper;
	
	/**
	 * 单表查询结果封装
	 */
	@Override
	public EasyUIDateResult getItemParamList(Integer pages, Integer rows) {
		/**
		 * 首先设置分页
		 */
		PageHelper.startPage(pages, rows);
		
		/**
		 * 查询结果封装
		 */
		TbItemParamExample example=new TbItemParamExample();
		List<TbItemParam>  list=itemParamMapper.selectByExampleWithBLOBs(example);
		
		
		/**
		 * 设置分页
		 */
		PageInfo<TbItemParam> pageInfo=new PageInfo<TbItemParam>(list);
		long total=pageInfo.getTotal();
		return new EasyUIDateResult(total, list);
	}
	
	/**
	 * 增加商品模板
	 */
	@Override
	public AnswerResult add(Long id, String param) {
		TbItemParam  itemParamBean=new TbItemParam();
		itemParamBean.setItemCatId(id);
		itemParamBean.setCreated(new Date());
		itemParamBean.setParamData(param);
		itemParamBean.setUpdated(new Date());	
		//增加记录
		try {
			itemParamMapper.insert(itemParamBean);
		} catch (Exception e) {
			e.printStackTrace();	
			return AnswerResult.build(500, ExceptionUtils.getStack(e));	
		}
		return AnswerResult.ok();
	}
	
	/**
	 * 根据cid查询具体参数
	 * 1设置查询条件
	 * 2根据条件查询返回结果
	 */
	@Override
	public AnswerResult selectCid(Long cid) {
		//设置查询条件
		TbItemParamExample  example=new TbItemParamExample();
		Criteria criteria=example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		
		
		List list=itemParamMapper.selectByExampleWithBLOBs(example);
		if(list.size()>0){
			return AnswerResult.ok(list.get(0));
		}
		return AnswerResult.build(ConstantUtils.NOT_BUILD_MESSAGE,"此分类没有定义模板");
	}

	/**
	 *1根据cid检查是否存在目录
	 */
	@Override
	public AnswerResult checkItem(Long cid) {
		try {
			//设置查询条件
			TbItemParamExample  example=new TbItemParamExample();
			Criteria criteria=example.createCriteria();
			criteria.andItemCatIdEqualTo(cid);
			List<TbItemParam> list=itemParamMapper.selectByExample(example);
			if(list==null || list.isEmpty()){
				return AnswerResult.ok();
			}
			return AnswerResult.ok(list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			return AnswerResult.build(ConstantUtils.EXCEPTION_STATUS,ExceptionUtils.getStack(e));
		}
		
	}

}
