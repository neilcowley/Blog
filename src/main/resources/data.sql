-- drop database blog;
-- create database blog; 
TRUNCATE TABLE blog_entry;
INSERT INTO blog_entry (id, version, title, category, pub_date, description) VALUES (1, 0, 'Blog Entry #1', 'January 20',  NOW(), 'This is the decription of the database'),(2, 0, 'Blog Entry #2', 'February 20',  CURDATE(), 'This is the decription of the database'),(3, 0, 'Blog Entry #3', 'March 20',  NOW(), 'This is the decription of the database');
