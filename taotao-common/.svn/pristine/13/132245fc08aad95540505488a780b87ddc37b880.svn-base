package com.taotao.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 抛出异常
 * @author fenguriqi
 * 2017年4月9日 下午9:06:13
 * ExceptionUtil
 */
public class ExceptionUtils {

	/**
	 * 获取异常的堆栈信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getStack(Throwable t) {
		StringWriter sW = new StringWriter();
		PrintWriter pW = new PrintWriter(sW);

		try {
			t.printStackTrace(pW);
			return sW.toString();
		} finally {
			pW.close();
		}
	}
}
