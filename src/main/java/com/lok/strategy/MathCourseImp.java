package com.lok.strategy;

import org.springframework.stereotype.Component;

@Component
public class MathCourseImp implements Course {

	private static final String CROUSE_TYPE = "MATH";
	
	@Override
	public String getCourseType() {
		return CROUSE_TYPE;
	}

	@Override
	public String teach() {
		return "Teaching math now!";
	}

}
