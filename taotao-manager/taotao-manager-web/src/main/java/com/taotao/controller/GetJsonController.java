package com.taotao.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.taotao.common.utils.HttpClientUtil;

@Controller
public class GetJsonController {

	
	@Test
	public void getJson(){
		String string=HttpClientUtil.doGet("http://f.apiplus.net/cqssc.json");
		System.out.println(string.toString());
	}
}
