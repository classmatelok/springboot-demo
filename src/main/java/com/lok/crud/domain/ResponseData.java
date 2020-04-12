package com.lok.crud.domain;

import lombok.Data;

/**
 * @Description 响应数据封装类
 * @date 2017年9月18日
 */

@Data
public class ResponseData {
	private int status; // 响应状态
	private String message; // 响应消息
	private Object data; //响应数据
	
}
