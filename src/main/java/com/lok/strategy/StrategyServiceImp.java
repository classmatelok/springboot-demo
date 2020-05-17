package com.lok.strategy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lok.strategy.Course;

/**
 * @Description 策略模式的运用：传入不同课程类型，触发不同上课内容（避免过多臃肿的ifelse）
 * @date 2017年10月9日
 */
@Service
public class StrategyServiceImp {
	
	@Autowired
	private List<Course> courses;
	
	public String teachByCourseType(String courseType) {
		Optional<Course> courseOpt = courses.stream().filter(c -> c.getCourseType().equalsIgnoreCase(courseType)).findFirst();
		return courseOpt.isPresent()? courseOpt.get().teach() : "抱歉，未找到相关课程！";
	}
}
