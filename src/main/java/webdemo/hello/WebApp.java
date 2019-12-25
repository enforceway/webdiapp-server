package webdemo.hello;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebApp {
	public static void main(String[] args) {
		try {
			String url = URLEncoder.encode("https://blog.csdn.net/xingbaozhen1210/article/details/78521753", "UTF-8");
			System.out.println(url);
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
