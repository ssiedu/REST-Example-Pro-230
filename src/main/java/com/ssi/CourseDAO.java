package com.ssi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Course getCourse(String code){
		Session session=sessionFactory.openSession();
		Course course=session.get(Course.class,code);
		session.close();
		return course;
	}
	public List<Course> getAllCourses(){
		Session session=sessionFactory.openSession();
		List<Course> courses=session.createQuery("from Course").list();
		session.close();
		return courses;
	}
	public Course deleteCourse(String code) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Course course=session.get(Course.class, code);
		session.delete(course);
		tr.commit();
		session.close();
		return course;
	}
	public Course saveOrUpdateTheCourse(Course course) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(course);
		tr.commit();
		session.close();
		return course;
	}
	
	
}
