package com.dcj.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class PropertyUtil {
	private final static String configPath="conf\\system.properties";
	
	/**
	 * 根据key返回配置的value
	 * @param key
	 * @return
	 */
	public static String readProperty(String key){
		Properties property = new Properties();
		try {
			property.load(new FileInputStream(configPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property.getProperty(key);
	}
	
	/**
	 * 修改配置文件，未测试
	 * @param key
	 * @param value
	 */
	public static void modifyPropertier(String key,String value){
		Properties props = new Properties();
		InputStream in = null;
		FileOutputStream fos = null;
		File file = new File(configPath);
		try {
			in = new BufferedInputStream(new FileInputStream(configPath));
			props.load(in);
			fos = new FileOutputStream(file);
			props.put(key, value);
			props.store(fos, "author: an biao ke ji");
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test(){
		String s = readProperty("server.uri");
		System.out.println(s);
	}
	
}
