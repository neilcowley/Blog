$(function(){
				
	$('.closeBlog').click(function(){LINK.closeBlogEntry()});
	$('.editBlog').click(function(){LINK.editBlogEntry()}); 
	
});

// var LINK = LINK || {} ; 


var LINK = {
	path : window.location.origin.toLowerCase(), 
	click : function(){
		this.click();
	},
	closeBlogEntry : function(){
		window.location = this.path + "/blog/list"; 
	},
	editBlogEntry : function(){
		var blogId = document.getElementById("blogId").innerText;
		window.location = this.path + "/blog/edit/" + blogId ; 
	}
}