package com.taotao.portal.service.impl;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.pojo.TbUser;
import com.taotao.portal.base.BaseService;
import com.taotao.portal.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	
	
	@Override
	public TbUser getUserByToken(String token) {
		try {
			String json = HttpClientUtil.doGet( BaseService.SSO_USER_TOKEN_SERVICE+ token);
			// 把json转换成java对象
			AnswerResult result = AnswerResult.formatToPojo(json, TbUser.class);
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}
