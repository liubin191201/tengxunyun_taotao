package com.taotao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.bean.CateNodeBean;
import com.taotao.rest.bean.ItemCatResultBean;
import com.taotao.rest.service.TbItemCatService;

/**
 * 才查询商品类目列表信息
 * @author fenguriqi
 * 2017年4月16日 上午8:57:43
 * TbItemCatServiceImpl
 */
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

	
	
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	/**
	 * 查询节点信息
	 */
	@Override
	public ItemCatResultBean getItemCat() {
		ItemCatResultBean result = new ItemCatResultBean();
		result.setData(getItemNodeList(0L));
		return result;
	}
	
	/**
	 * 根据父节点查询子节点下面的信息并且返回
	 * @auther fengruiqi
	 * 2017年4月16日  上午8:59:31
	 * @param parentId
	 * @return
	 */
	public List<?>  getItemNodeList(Long parentId){
		TbItemCatExample  example=new TbItemCatExample();
		Criteria  criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list=itemCatMapper.selectByExample(example);
		List  returnList=new ArrayList<>();
		//循环遍历
		int count=0;
		for(TbItemCat item:list){
		    //如果为父节点	
			if(item.getIsParent()){
				CateNodeBean  bean=new CateNodeBean();
				bean.setUrl("/products/" + item.getId() + ".html");
				
				//然后判断是否是第一层节点
				if(parentId==0){
					bean.setName("<a href='"+bean.getUrl()+"'>"+item.getName()+"</a>");
				}else{
					bean.setName(item.getName());
				}
				bean.setItems(getItemNodeList(item.getId()));
				returnList.add(bean);
			}else{
				String node="/products/"+item.getId()+".html|" + item.getName();
				returnList.add(node);
			}
			count++;
			if(parentId==0 && count>=14){
				break;
			}
		}
	
		
		return returnList;
		
	}

}
