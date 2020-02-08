package com.projects.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.blog.models.BlogEntry;

@Service
public interface BlogService {
	
	public BlogEntry findBlogById(int id);
	
	public BlogEntry setBlog(int id);
	
	public List<BlogEntry> findAllBlogEntries(); 
	
	public void deleteBlog(int id);
	
	public void saveBlog(BlogEntry blogEntry);

}
