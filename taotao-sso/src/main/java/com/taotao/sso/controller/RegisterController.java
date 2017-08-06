package com.taotao.sso.controller;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.ExceptionUtils;
import com.taotao.pojo.TbUser;
import com.taotao.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	/**
	 * 数据有效性的校验
	 * @auther fengruiqi
	 * 2017年5月23日  下午10:09:43
	 * @param param
	 * @param type
	 * @param callback
	 * @return
	 */
	@RequestMapping(value="/check/{param}/{type}", method=RequestMethod.GET)
	@ResponseBody
	public Object checkInfo(@PathVariable String param, @PathVariable Integer type,
			String callback) {
		AnswerResult taotaoResult = registerService.checkInfo(param, type);
		if (null == callback) {
			return taotaoResult;
		}
		//需要支持jsonp
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(taotaoResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}
	
	/**
	 * 数据注册
	 * @auther fengruiqi
	 * 2017年5月23日  下午10:09:56
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public AnswerResult register(TbUser user) {
		try {
			return registerService.register(user);
		} catch (Exception e) {
			return AnswerResult.build(500, ExceptionUtils.getStack(e));
		}
	}
	
	/**
	 * 跳转到注册页面
	 * @auther fengruiqi
	 * 2017年5月23日  下午10:10:09
	 * @return
	 */
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
}
