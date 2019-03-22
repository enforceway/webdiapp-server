package com.webdiapp.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 实现JSON字符串与Java对象的相互转换的工具类
 * @author kero
 * @date 2018-03-24 23:14:12
 * @version 1.0
 */
public class JsonUtil {
	
	// 获取原始的 ObjectMapper 对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	/**
	 * 获取自定义 ObjectMapper 的方法
	 * @return
	 */
	private static final ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		// 设置自定义的 SimpleDateFormat，该对象支持"yyyy-MM-dd HH:mm:ss"格式 
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		return mapper;
	}
	
	
	
	/**
	 * 将Json字符串转换成Java对象
	 * @param jsonData 要进行转换的Json字符串
	 * @param targetClass 要转换成的Java对象的class
	 * @return
	 */
	public static <T> T jsonToObject(String jsonData, Class<T> targetClass) {
		try {
			// 先使用自定义的ObjectMapper进行解析
			return getMapper().readValue(jsonData, targetClass);
		} catch (Exception e) {
			try {
				// 如果解析失败则，使用默认的 ObjectMapper 进行解析
				return MAPPER.readValue(jsonData, targetClass);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
}