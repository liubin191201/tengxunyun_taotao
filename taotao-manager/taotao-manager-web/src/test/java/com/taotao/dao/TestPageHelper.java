package com.taotao.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
 * 
 * 描述：分页测试
 * @author fengruiqi
 * @time  2017年1月26日 下午1:27:22
 */
public class TestPageHelper {

	@Test
	public void TestPage(){
		//首先从容器中获得内容
	   ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml"); 	
		//然后从spring容器中得到Mapper代理对象
	   TbItemMapper itemMapper=applicationContext.getBean(TbItemMapper.class);
	   //这个没错都需要设置 只针对第一个有效 如果有多个mapper  需要单独设置不然其他的不起作用
	   PageHelper.startPage(0, 10);
	   
	   List<TbItem> list=itemMapper.selectByExample(new TbItemExample());
	   //然后取查询结果
	   PageInfo<TbItem> pageInfo=new PageInfo<>(list);
	   pageInfo.getPages();
	   System.out.println(pageInfo.getPages());
	   System.out.println(pageInfo.getPageSize());
	   System.out.println(pageInfo.getTotal());
	}
}
