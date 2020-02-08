package com.projects.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projects.blog.models.BlogEntry;
import com.projects.blog.services.BlogService;
import com.projects.blog.services.BlogServiceImpl;

@Controller
public class BlogController {

	private BlogService blogService;
	
	@Autowired
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}
		
	@RequestMapping(value="/blog/cancel", method=RequestMethod.POST, params="action=cancel")
	public String cancel() {
		ModelAndView mav = new ModelAndView();
		return "/blog/list";
	}

	@GetMapping("/blog/show/{id}")
	public ModelAndView getBlog(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();
		BlogEntry blog = blogService.findBlogById(id);
		if (null != blog) {
			mav.addObject("blogEntry", blog);
			mav.setViewName("/blog/show");
		}
		return mav;
	}
	
	@RequestMapping(value="/blog/edit/{id}", method=RequestMethod.GET)
	public ModelAndView save(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();	
		BlogEntry blog = blogService.findBlogById(id);
		if (null != blog) {
			mav.addObject("blogEntry", blog);
			mav.setViewName("/blog/blogform");
		}
		return mav;	
	}
	
	@GetMapping("/blog/new")
	public String newBlog(Model model) {
		model.addAttribute("blogEntry", new BlogEntry() );
		return "blog/blogform"; 
	}
				
	@GetMapping("/blog/list")
	public String findAllBlogEntries(Model model) {
		List<BlogEntry> allBlogEntries = blogService.findAllBlogEntries();		
		model.addAttribute("allBlogEntries", allBlogEntries);
		return "/blog/list";
	}
	
	@RequestMapping("/blog/delete/{id}")
	public String deleteBlog(@PathVariable Integer id) {
		blogService.deleteBlog(id);
		 return "redirect:/blog/list";
	}
	
	@RequestMapping(value="/blog/save" , method=RequestMethod.POST )
	public ModelAndView saveBlog(BlogEntry blogEntry) {
		blogService.saveBlog(blogEntry);
		ModelAndView mav = new ModelAndView();	
		mav.addObject("successMessage", "Blog has been saved successfully");
		mav.addObject("blogEntry", blogEntry);
		mav.setViewName("redirect:/blog/list");
		return mav; 
	}
	
	
//	this didn't work???
//	@GetMapping("/blog/list")
//	public ModelAndView findAllBlogEntries() {
//		ModelAndView mav = new ModelAndView();
//		List<BlogEntry> allBlogEntries = blogService.findAllBlogEntries();
//		mav.addObject(allBlogEntries);
//		mav.setViewName("/blog/list");
//		return mav;
//	}
}
