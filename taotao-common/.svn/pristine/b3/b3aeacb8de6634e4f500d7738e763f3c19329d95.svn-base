package com.taotao.common.utils;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 图片上传工具类
 * @author fenguriqi
 * 2017年3月4日 下午11:23:55
 * FastUpload
 */
public class FastUploadUtils {
		
		
	/*	//客户端配置文件  可以在配置文件中配置好暂时先这样待会弄
		public static String confFileName = "F:\\工作空间\\学习\\workspaceTXHM\\taotao-manager\\taotao-manager-web\\src\\"
				+ "main\\resources\\properties\\fdfs_client.conf"; 
	    //本地文件，要上传的文件
		public String localFileName = "F:\\develop\\upload\\linshiyaopinxinxi_20140423193847.xlsx"; 
		*/
		
		private TrackerClient trackerClient = null;
		private TrackerServer trackerServer = null;
		private StorageServer storageServer = null;
		private StorageClient1 storageClient = null;
		
		public FastUploadUtils(String conf) throws Exception {
			if (conf.contains("classpath:")) {
				conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
			}
			ClientGlobal.init(conf);
			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
			storageServer = null;
			storageClient = new StorageClient1(trackerServer, storageServer);
		}
		
		/**
		 * 
		 * @auther fengruiqi
		 * 2017年3月5日  上午11:46:42
		 * @param fileName 文件全路径
		 * @param extName 文件扩展名，不包含（.）
		 * @param metas 文件扩展信息
		 * @return
		 * @throws Exception
		 */
		public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
			String result = storageClient.upload_file1(fileName, extName, metas);
			return result;
		}
		
		public String uploadFile(String fileName) throws Exception {
			return uploadFile(fileName, null, null);
		}
		
		public String uploadFile(String fileName, String extName) throws Exception {
			return uploadFile(fileName, extName, null);
		}
		
		/**
		 * 上传文件方法
		 * @auther fengruiqi
		 * 2017年3月5日  上午11:47:03
		 * @param fileContent 文件的内容，字节数组
		 * @param extName 文件扩展名
		 * @param metas 文件扩展信息
		 * @return
		 * @throws Exception
		 */
		public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
			
			String result = storageClient.upload_file1(fileContent, extName, metas);
			return result;
		}
		
		public String uploadFile(byte[] fileContent) throws Exception {
			return uploadFile(fileContent, null, null);
		}
		
		public String uploadFile(byte[] fileContent, String extName) throws Exception {
			return uploadFile(fileContent, extName, null);
		}
}
