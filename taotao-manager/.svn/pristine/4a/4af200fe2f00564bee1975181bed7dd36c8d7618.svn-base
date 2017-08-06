package com.taotao.dao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * 测试fastfds文件上传类
 * @author fenguriqi
 * 2017年3月4日 下午10:07:19
 * FastClientImageTest
 */
public class FastClientImageTest {
	
	//客户端配置文件
	public static String confFileName = "F:\\工作空间\\学习\\workspaceTXHM\\taotao-manager\\taotao-manager-web\\src\\"
			+ "main\\resources\\properties\\fdfs_client.conf"; 
    //本地文件，要上传的文件
	public String local_filename = "F:\\develop\\upload\\linshiyaopinxinxi_20140423193847.xlsx"; 
	
	/**
	 * 图片文件上传测试类
	 * @auther fengruiqi
	 * 2017年3月4日  下午10:08:17
	 */
	@Test
	public void UploadImage(){
		try {
			ClientGlobal.init(confFileName);
			TrackerClient trackerClient=new TrackerClient();
			TrackerServer trackerServer=trackerClient.getConnection();
			StorageServer storageServer=null;
			StorageClient storageClient=new StorageClient(trackerServer, storageServer);
			String[] upload=storageClient.upload_appender_file("C:\\Users\\ASUS\\Pictures\\1.jpg","jpg", null);
			for(String string:upload){
				System.out.println(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	

}
