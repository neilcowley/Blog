package com.projects.blog.services;

import java.util.List;

import com.projects.blog.models.Blog;

public interface BlogService {
	
	public Blog getBlog(int id);
	
	public Blog setBlog(int id);
	
	public List<Blog> getBlogList(); 
	
	public void deleteBlog(int id);
	
	public void buildList();
}
