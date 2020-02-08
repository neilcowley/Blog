package com.projects.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projects.blog.models.BlogEntry;

@Repository
public interface BlogRepository extends CrudRepository<BlogEntry, Integer> {
	
	public BlogEntry findById(int id); 
	
	public List<BlogEntry> findAll();
	
	public void deleteById(int id);
	
}
 