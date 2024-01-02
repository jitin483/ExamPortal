package com.exampotal.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exampotal.models.Category;
import com.exampotal.services.CategoryServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/categories")
public class CategoryController {

	 @Autowired
	    private CategoryServiceImpl categoryService;

	    @GetMapping
	    public ResponseEntity<Set<Category>> getAllCategories() {
	        Set<Category> categories = categoryService.getAllCategories();
	        return new ResponseEntity<>(categories, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        Category category = categoryService.getCategoryById(id);
	        if (category != null) {
	            return new ResponseEntity<>(category, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping("/")
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        Category createdCategory = categoryService.createCategory(category);
	        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	    }

	    @PutMapping
	    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
	        Category updatedCategory = categoryService.updateCategory(category);
	        if (updatedCategory != null) {
	            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
