package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.common.pojo.ImageResultPojo;
import com.taotao.service.ImageService;

/**
 * 图片上传Controller
 * @author fenguriqi
 * 2017年3月5日 上午11:54:11
 * ImageController
 */
@Controller
public class ImageController {

	@Autowired
	private ImageService  imageServiceImpl;
	/**bean转换成json*/
	private ObjectMapper  mapper=new ObjectMapper();
	
	/**
	 * 图片上传
	 * @auther fengruiqi
	 * 2017年3月5日  下午6:31:29
	 * @param uploadFile
	 * @return
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFiles(MultipartFile uploadFile){
		Map pojo=imageServiceImpl.uploadImage(uploadFile);
		return JSONUtils.toJSONString(pojo);
	}
	
	
}
