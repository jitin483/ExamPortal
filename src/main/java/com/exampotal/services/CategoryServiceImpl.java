package com.exampotal.services;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exampotal.models.Category;
import com.exampotal.repositories.CategoryRepository;

/*
 * Mark the 
 */
@Service
public class CategoryServiceImpl {
	/*
	 * Auto wired category repository
	 */
	@Autowired
    private CategoryRepository categoryRepository;
	
	
	/*
	 * create set for return to all categories
	 */

    public Set<Category> getAllCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }
    
/*
 * get category by id
 */
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
/*
 * create category
 */
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
/*
 * update category
 */
    public Category updateCategory(Category category) {
        if (categoryRepository.existsById(category.getCid())) {
            return categoryRepository.save(category);
        }
        return null;//exception
    }

    /*
     * to  delete  category
     */
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
