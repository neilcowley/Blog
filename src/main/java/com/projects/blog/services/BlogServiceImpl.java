package com.projects.blog.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.projects.blog.models.BlogEntry;
import com.projects.blog.repositories.BlogRepository;

@Service
@Qualifier("BlogService")
public class BlogServiceImpl implements BlogService {
	
	private BlogRepository blogRepository;
	
	private HashMap<Integer, BlogEntry> blogList; 
	
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
		buildList();
	}

	@Override
	public BlogEntry findBlogById(int id) {
		return blogRepository.findById(id);
	}

	@Override
	public BlogEntry setBlog(int id) {
		return null;
	}

	@Override
	public void deleteBlog(int id) {
		blogRepository.deleteById(id);
	}
	
	@Override
	public void saveBlog(BlogEntry blogEntryUpdate){
		BlogEntry blogEntry=null;
		if(StringUtils.isEmpty(blogEntryUpdate.getId())){
			blogEntry = new BlogEntry(); 
			blogEntry.setPubDate(new Date());
		} else {
			blogEntry = findBlogById(blogEntryUpdate.getId());			
		}
		blogEntry.setCategory(blogEntryUpdate.getCategory());
		blogEntry.setDescription(blogEntryUpdate.getDescription());
		blogEntry.setTitle(blogEntryUpdate.getTitle());
		blogRepository.save(blogEntry);
	}
	
	@Override
	public List<BlogEntry> findAllBlogEntries(){
		List<BlogEntry> allBlogEntries = blogRepository.findAll();
		System.out.println("allBlogEntries.size=" + allBlogEntries.size());
		return allBlogEntries;
	}

	public void buildList() {
		BlogEntry blog1 = new BlogEntry(1, "titleBlog1", "January 2020", new Date(), "blog description1" );
		BlogEntry blog2 = new BlogEntry(2, "titleBlog2", "February 2020", new Date(), "blog description2" );
		BlogEntry blog3 = new BlogEntry(3, "titleBlog3", "March 2020", new Date(), "blog description3" );
		
		blogList = new HashMap<Integer, BlogEntry>();
		blogList.put(blog1.getId(), blog1);
		blogList.put(blog2.getId(), blog2);
		blogList.put(blog3.getId(), blog3);
	}

}
