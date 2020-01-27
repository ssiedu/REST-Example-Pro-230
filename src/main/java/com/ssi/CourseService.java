package com.ssi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseDAO dao;
	
	public Course createNewCourse(Course course) {
		return dao.saveOrUpdateTheCourse(course);
	}
	public Course updateExistingCourse(Course course) {
		return dao.saveOrUpdateTheCourse(course);
	}
	public Course deleteCourse(String code) {
		return dao.deleteCourse(code);
	}
	public List<Course> getAllCourses(){
		return dao.getAllCourses();
	}
	public Course getSingleCourseByCode(String code) {
		return dao.getCourse(code);
	}
}
