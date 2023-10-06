package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CoursesService;
@CrossOrigin(origins="*")
@RestController
public class MyController {
	@Autowired
	private CoursesService courseServices;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to the bootspring jpa courses application.";
	}
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseServices.getCourses();
	}
	
	@GetMapping("courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return this.courseServices.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseServices.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseServices.updateCourse(course);
	}
	
	@PutMapping("/courses/{courseId}")
	public Courses updateCourse1(@PathVariable String courseId) {
		return this.courseServices.updateCourse1(Long.parseLong(courseId));
	}
	
	@DeleteMapping("courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseServices.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
