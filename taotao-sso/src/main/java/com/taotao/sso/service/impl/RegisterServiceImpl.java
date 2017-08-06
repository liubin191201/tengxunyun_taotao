package com.taotao.sso.service.impl;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 数据有效性的检验
	 */
	@Override
	public AnswerResult checkInfo(String data, int type) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		//用户名
		if (type == 1) {
			criteria.andUsernameEqualTo(data);
		//电话
		} else if (type == 2) {
			criteria.andPhoneEqualTo(data);
		//email
		} else if (type == 3) {
			criteria.andEmailEqualTo(data);
		}
		List<TbUser> list = userMapper.selectByExample(example);
		//没查到可以使用
		if (list == null || list.isEmpty()) {
			return AnswerResult.ok(true); 
		}
		return AnswerResult.ok(false);
	}
	
	/**
	 * 注册
	 */
	@Override
	public AnswerResult register(TbUser user) {
		// 校验数据
				//校验用户名、密码不能为空
				if (StringUtils.isBlank(user.getUsername())
						|| StringUtils.isBlank(user.getPassword())) {
					return AnswerResult.build(400, "用户名或密码不能为空");
				}
				//校验数据是否重复
				//校验用户名
				AnswerResult result = checkInfo(user.getUsername(), 1);
				if (!(boolean) result.getData()) {
					return AnswerResult.build(400, "用户名重复");
				}
				//校验手机号
				if (user.getPhone() != null) {
					result = checkInfo(user.getPhone(), 2);
					if (!(boolean) result.getData()) {
						return AnswerResult.build(400, "手机号重复");
					}
				}
				//校验手机号
				if (user.getEmail() != null) {
					result = checkInfo(user.getEmail(), 3);
					if (!(boolean) result.getData()) {
						return AnswerResult.build(400, "邮箱重复");
					}
				}

				//密码进行md5加密
				String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
				user.setPassword(password);
				
				//补全user对象中的信息
				user.setCreated(new Date());
				user.setUpdated(new Date());
				//把用户信息插入到数据库
				userMapper.insert(user);
				
				return AnswerResult.ok();
	}

}
