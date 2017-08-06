package com.taotao.sso.service;

import com.taotao.common.pojo.AnswerResult;
import com.taotao.pojo.TbUser;

public interface RegisterService {

	AnswerResult checkInfo(String data, int type);
	AnswerResult register(TbUser user);
}
