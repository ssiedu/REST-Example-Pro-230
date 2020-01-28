package com.ssi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired
	private CourseService service;

	
	//this service will delete a course by id
	@DeleteMapping(value="{id}", produces="application/json")
	public  Course removeCourse(@PathVariable("id") String code) {
		return service.deleteCourse(code);
	}
	
	
	//this service will create a resource (new course)
	@PostMapping(produces = "application/json", consumes = "application/json")
	public Course createNewCourse(@RequestBody Course course) {
		return service.createNewCourse(course);
	}
	
	//this service will update an existing course
	@PutMapping(produces = "application/json", consumes = "application/json")
	public Course changeCourse(@RequestBody Course course) {
		return service.updateExistingCourse(course);
	}
	
	//this service is returning all courses in xml format
	@GetMapping(value="/xml", produces="application/xml")
	public List<Course> showAllCoursesInXml(){
		List<Course> courses=service.getAllCourses();
		return courses;
	}
	//this service is returning all courses in json format
	@GetMapping(value="/json", produces="application/json")
	public List<Course> showAllCoursesInJson(){
		List<Course> courses=service.getAllCourses();
		return courses;
	}
	
	//this service is providing the response in xml format
	@GetMapping(value="/xml/{id}", produces = "application/xml")
	public Course getSingleCourseInXml(@PathVariable("id") String code) {
		Course course=service.getSingleCourseByCode(code);
		return course;
	}

	
	//this service is providing the response in json format
	@GetMapping(value="/json/{id}", produces = "application/json")
	public Course getSingleCourseInJson(@PathVariable("id") String code) {
		Course course=service.getSingleCourseByCode(code);
		return course;
	}
	
	//this service is providing the response in text format
	@GetMapping(value="/{id}")
	public String getSingleCourseAsString(@PathVariable("id") String code) {
		Course course=service.getSingleCourseByCode(code);
		String info=course.toString();
		return info;
	}
	
}
