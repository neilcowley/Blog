package com.projects.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@RequestMapping({"/" , ""})
	public String showBlog(Model model) {
		model.addAttribute("joke" , "value");
		return "index";
	}
	
	
}
