package com.springrest.springrest.services;

import java.util.List;
import com.springrest.springrest.entities.Courses;

public interface CoursesService {
	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public Courses updateCourse1(long courseId);
	
	public void  deleteCourse(long courseId);
}
