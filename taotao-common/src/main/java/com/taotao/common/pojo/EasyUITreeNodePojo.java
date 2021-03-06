package com.taotao.common.pojo;

/**
 * easyui树bean
 * @author fenguriqi
 * 2017年2月3日 下午9:32:28
 * EasyUITreeNodePojo
 */
public class EasyUITreeNodePojo {
	
	/**
	 * 主键id
	 */
	private long id;
	/**
	 * 内容
	 */
	private String text;
	/**
	 * close  open 节点状态
	 */
    private String state;
    
    public EasyUITreeNodePojo(long id, String text,String state){
    	this.id=id;
    	this.text=text;
    	this.state=state;
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
   
    


}
