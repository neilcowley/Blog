package com.projects.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projects.blog.models.Blog;
import com.projects.blog.services.BlogServiceImpl;

@Controller
public class BlogController {

	@Autowired
	private BlogServiceImpl blogService;

	@GetMapping("/blog/show/{id}")
	public ModelAndView getBlog(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();
		Blog blog = blogService.getBlog(id);
		if (null != blog) {
			mav.addObject("blog", blog);
			mav.setViewName("/blog/show");
		}
		return mav;
	}
	
	@GetMapping("/blog/new")
	public String newBlog(Model model) {
		model.addAttribute("blog", new Blog() );
		return "blog/blogform"; 
	}
		
	@GetMapping("/blog/list")
	public ModelAndView getBlogList() {
		ModelAndView mav = new ModelAndView();
		List<Blog> blogList = blogService.getBlogList();
		mav.addObject(blogList);
		mav.setViewName("/blog/list");
		return mav;
	}
	
	@RequestMapping("/blog/delete/{id}")
	public String deleteBlog(@PathVariable Integer id) {
		blogService.deleteBlog(id);
		 return "redirect:/blog/list";
	}
	
	@GetMapping("/blog/build")
	public String buildBlogList() {
		blogService.buildList();
		 return "redirect:/";
	}
	
//	@GetMapping("/blog/list")
//	public String getBlogList(Model model) {
//
//		ModelAndView mav = new ModelAndView();
//		List<Blog> blogList = blogService.getBlogList();
//		mav.addObject(blogList);
//		mav.setViewName("blog/list");
//		
//		model.addAttribute("blogList", blogList);
//		
//		return "/blog/list";
//	}

}
