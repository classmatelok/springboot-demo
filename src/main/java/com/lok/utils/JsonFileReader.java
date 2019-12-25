package com.lok.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lok.domain.JsonDemo;

/**
 * @author Lok
 * @2019年12月25日
 * @description 加载json配置文件并注册为bean例子
 * 				用 @Configuration+@Bean的好处是，提前将相关配置文件在server启动的时候就加载注册为bean，若用@Service则调用时才注册。
 * 				另还可设计成配合@Profile读取不同数据源，如mongodb
 */
 @Configuration
public class JsonFileReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonFileReader.class);
	private static String content;
	
	static {
		try {
			ClassPathResource resource = new ClassPathResource("json_demo.json");
			File filePath = resource.getFile();
			content = FileUtils.readFileToString(filePath, "UTF-8");//需要common-io包
			LOGGER.info("Load json file success: {}", content.replaceAll("\\s", ""));
		} catch (IOException e) {
			LOGGER.error("Error loading json file: ", e);
		}
	}
	
	@Bean("students")
	public static List<JsonDemo> getClassmate() {
		JSONObject contentJsonObj = JSONObject.parseObject(content);//需要com.alibaba.fastjson包
		JSONArray students = contentJsonObj.getJSONArray("students");
		List<JsonDemo> list = JSONObject.parseArray(students.toJSONString(), JsonDemo.class);
		return list;
	}
	
}
