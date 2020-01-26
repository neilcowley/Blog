package com.projects.blog.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.blog.models.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	
	private HashMap<Integer, Blog> blogList; 
	
	public BlogServiceImpl() {
		buildList();
	}

	@Override
	public Blog getBlog(int id) {
		return blogList.get(id);
	}

	@Override
	public Blog setBlog(int id) {
		return null;
	}

	@Override
	public void deleteBlog(int id) {
		blogList.remove(id);
	}


	@Override
	public List<Blog> getBlogList(){
		ArrayList<Blog> listOfValues = new ArrayList<Blog>(blogList.values());
		return listOfValues;
	}

	@Override
	public void buildList() {
		Blog blog1 = new Blog(1, "titleBlog1", "January 2020", new Date(), "blog description1" );
		Blog blog2 = new Blog(2, "titleBlog2", "February 2020", new Date(), "blog description2" );
		Blog blog3 = new Blog(3, "titleBlog3", "March 2020", new Date(), "blog description3" );
		
		blogList = new HashMap<Integer, Blog>();
		blogList.put(blog1.getId(), blog1);
		blogList.put(blog2.getId(), blog2);
		blogList.put(blog3.getId(), blog3);
	}
	
}
