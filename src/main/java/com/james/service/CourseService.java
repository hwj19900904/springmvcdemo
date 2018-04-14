package com.james.service;

import org.springframework.stereotype.Service;

import com.james.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
