package com.taotao.sso.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.JedisClient;
import com.taotao.sso.service.LoginService;
import com.taotao.sso.util.RedisKeyUtil;

@Service
public class LoginServiceImpl implements LoginService {

	/**
	 * 注入用户userMap
	 */
	@Autowired
	private TbUserMapper userMapper;

	/**
	 * redis链接
	 */
	@Autowired
	private JedisClient jedisClient;
	
	
	private static String TT_TOKEN="TT_TOKEN";
	
	@Override
	public AnswerResult login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
		
		//有效性验证
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return AnswerResult.build(400, "有户名和密码不能为空");
		}
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return AnswerResult.build(400, "用户名或密码错误");
		}
		//判断密码是否正确
		TbUser user = list.get(0);
		if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
			return AnswerResult.build(400, "用户名或密码错误");
		}
		//生成token
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString();
		//把用户信息写入redis
		//把用户的密码清空，为了安全。
		user.setPassword(null);
		jedisClient.set(RedisKeyUtil.REDIS_SESSION + ":" + token, JsonUtils.objectToJson(user));
		jedisClient.expire(RedisKeyUtil.REDIS_SESSION+ ":" + token, RedisKeyUtil.REDIS_SESSION_EXPIRE);
		//把token写入cookie
		CookieUtils.setCookie(request, response, TT_TOKEN, token);
		//返回token
		return AnswerResult.ok(token);
	}

}
