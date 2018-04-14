/**
 * 
 */
package com.james.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author James-HU
 *
 */

@Controller
@RequestMapping("/hello")
public class HelloSpringController {
	
	@RequestMapping("/mvc")
	public  String hellomvc()
	{
		return "home";
	}

}
