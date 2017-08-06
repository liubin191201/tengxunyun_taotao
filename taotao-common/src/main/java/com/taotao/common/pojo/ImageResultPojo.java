package com.taotao.common.pojo;

/**
 * 图片上传Pojo
 * @author fenguriqi
 * 2017年3月5日 上午12:15:49
 * ImageResult
 */
public class ImageResultPojo {

	/**
	 * 错误类型 0代表成功 1代表错误	
	 */
	private Integer error;
		
	/**
	 * 图pain上传链接
	 */
	private String url;
	
	/**
	 * 上传图pain返回信息
	 */
	private String message;

	
	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
