package com.ssi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired
	private CourseService service;
	
	@GetMapping
	//@ResponseBody
	public String getSingleCourseAsString() {
		System.out.println("Fetching A Single Course");
		Course course=service.getSingleCourseByCode("c111");
		String info=course.toString();
		return info;
	}
	
}
