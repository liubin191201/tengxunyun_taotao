package com.taotao.common.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 转换为json工具类
 * @author fenguriqi
 * 2017年3月5日 下午2:25:21
 * JsonUtils
 */
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     * @auther fengruiqi
     * 2017年3月19日  上午10:26:33
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = mapper.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * @auther fengruiqi
     * 2017年3月19日  上午10:26:46
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = mapper.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    
    
   /**
    * 将json数据转换成pojo对象list
    * @auther fengruiqi
    * 2017年3月19日  上午10:26:53
    * @param jsonData
    * @param beanType
    * @return
    */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = mapper.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
}
