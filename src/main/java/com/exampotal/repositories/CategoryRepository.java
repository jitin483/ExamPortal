package com.exampotal.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampotal.models.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
	
//	public Category addCategory(Category category);
//	
//	//public Category updateCategory(Category category);
//	
//	public void deleteCategory(Long catId);
//	
//	public Category getCategory(Long catId);
//	
//	public Set<Category> getAllCategory();

}
