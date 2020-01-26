package com.projects.blog.models;

import java.util.Date;

// @Entity
public class Blog {
	
    //@Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	private String title;
	private String category;
	private Date pubDate; 
	private String description; 
    //@Version
    // Integer version;
	
	public Blog() {}

	public Blog(Integer id, String title, String category, Date pubDate, String description) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.pubDate = pubDate;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
