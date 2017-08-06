package com.taotao.portal.bean;

/**
 * 广告bean
 * @author fenguriqi
 * 2017年5月13日 下午4:34:38
 * AdvertiseBean
 */
public class AdvertiseBean {
	
	/**第一个图片的宽度*/
	private Integer width;
	
	/**第一个图片的高度*/
	private Integer height;
	
	/**第二个图片的宽度*/
	private Integer widthB;
	
	/**第二个图片的高度*/
	private Integer heightB;
	
	/**第一个图片的路径*/
	private String src ;
	
	/**第二个图片的路径*/
	private String srcB;
	
	/**跳转链接*/
	private String href;
	
	/**标题*/
	private String alt;

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidthB() {
		return widthB;
	}

	public void setWidthB(Integer widthB) {
		this.widthB = widthB;
	}

	public Integer getHeightB() {
		return heightB;
	}

	public void setHeightB(Integer heightB) {
		this.heightB = heightB;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSrcB() {
		return srcB;
	}

	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	
}
