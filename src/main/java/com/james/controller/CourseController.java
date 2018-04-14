/**
 * 
 */
package com.james.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.james.model.Course;
import com.james.service.CourseService;

/**
 * @author James-HU
 *
 */
@Controller
@RequestMapping("/courses")
public class CourseController {

	private static Logger log = LoggerFactory.getLogger(CourseController.class);

	private CourseService courseService;

	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	// 本方法将处理 /courses/view?courseId=123形式的url
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
		log.debug("In viewCourse,courseId={}", courseId);

		Course course = courseService.getCoursebyId(courseId);
		model.addAttribute(course);
		return "course_overview";
	}

	// 本方法将处理 /courses/view2/123形式的url
	@RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
		log.debug("In viewCourse2,courseId={}", courseId);

		Course course = courseService.getCoursebyId(courseId);
		model.put("course", course);
		return "course_overview";
	}

	// 本方法将处理 /courses/view3?courseId=123形式的url
	@RequestMapping(value = "/view3")
	public String viewCourse2(HttpServletRequest request) {
		
		Integer courseId=Integer.valueOf(request.getParameter("courseId"));
		
		log.debug("In viewCourse3,courseId={}", courseId);

		Course course = courseService.getCoursebyId(courseId);
		request.setAttribute("course", course);
		return "course_overview";
	}

}
