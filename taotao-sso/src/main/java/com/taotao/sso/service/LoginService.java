package com.taotao.sso.service;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.AnswerResult;

public interface LoginService {
	AnswerResult login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
