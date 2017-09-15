package com.lok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 通用页面跳转controller
 */

@Controller
@RequestMapping("pages")
public class PageController {
	
	@RequestMapping("{floderName}/{pageName}")
	public String testMethod(
			@PathVariable("floderName")String floderName,
			@PathVariable("pageName")String pageName) {
		return floderName + "/"+ pageName;
	}
}
