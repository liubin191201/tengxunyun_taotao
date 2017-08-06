package com.taotao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.ImageResultPojo;
import com.taotao.common.utils.FastUploadUtils;
import com.taotao.service.ImageService;

/**
 * 上传图片service
 * @author fenguriqi
 * 2017年3月5日 上午11:08:35
 * ImageServiceImpl
 */
@Service
public class ImageServiceImpl implements ImageService {

	
	@Value("${IMAGE_PATH_BATH_URL}")
	private String BASE_URL;
	
	
	
	@Override
	public Map uploadImage(MultipartFile multipartFile) {
		
		if(multipartFile.isEmpty()){
			Map map=new HashMap();
			map.put("message", "");
			map.put("error", 0);
			return map;
		}
		try {
			//取图片扩展名
			String ImageName=multipartFile.getOriginalFilename();
			//去掉点
			String nextName=ImageName.substring(ImageName.lastIndexOf(".")+1);
			
			/**图片上传*/
			FastUploadUtils  uploadClient=new FastUploadUtils("classpath:properties/fdfs_client.conf");
			String url=uploadClient.uploadFile(multipartFile.getBytes(),nextName );
			Map map=new HashMap();
			map.put("url",BASE_URL+url);
			map.put("error", 0);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
