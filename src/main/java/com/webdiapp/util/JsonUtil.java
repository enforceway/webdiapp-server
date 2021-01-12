package com.webdiapp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webdiapp.entities.Questionaire;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonUtil {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(12);
		list.add("list is like a box");
		list.add("no matter what");
		Questionaire naire = new Questionaire();
		naire.setActiveDateEnd(new Date());
		naire.setActiveDateStart(new Date());
		naire.setTitle("问卷标题");
		System.out.println(JsonUtil.beanToJson(naire));
		System.out.println(JsonUtil.listToJson(list));
		int ids[] = new int[2];
		ids[0] = 5;
		ids[1] = 6;
	}

    // 获取原始的 ObjectMapper 对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 获取自定义 ObjectMapper 的方法
     *
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
     *
     * @param jsonData
     *            要进行转换的Json字符串
     * @param targetClass
     *            要转换成的Java对象的class
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

    public static String objectToJson(Object object) {
        StringBuilder json = new StringBuilder();

        if (object == null) {
            json.append("\"\"");
        } else if (object instanceof String || object instanceof Integer ||
                object instanceof Double) {
            json.append("\"").append(object.toString()).append("\"");
        } else {
            json.append(beanToJson(object));
        }

        return json.toString();
    }

    public static String listToJson(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");

        if ((list != null) && (list.size() > 0)) {
            for (Object obj : list) {
                json.append(objectToJson(obj));
                json.append(",");
            }

            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }

        return json.toString();
    }
    
    public static String intArrayToJson(int[] ints) {
    	StringBuffer sb = new StringBuffer();
    	for (int index = 0; index < ints.length; index++) {
    		sb.append(ints[index]);
    	}
    	return sb.toString();
    }

    public static String beanToJson(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        PropertyDescriptor[] props = null;

        try {
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)
                                .getPropertyDescriptors();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = objectToJson(props[i].getName());
                    String value = objectToJson(props[i].getReadMethod()
                                                        .invoke(bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Exception e) {
                }
            }

            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }

        return json.toString();
    }
}
