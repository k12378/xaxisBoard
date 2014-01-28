package com.xaxis.bbs.category;

import java.util.List;

import com.xaxis.bbs.model.Category;


public interface CategoryDao {
	
	public List<Category> getCategoryAllList();
	
	public Category getCategoryItem(String categoryCode);
	
	public void updateCategoryItem(Category category);
	
	public void deleteCategoryItem(String categoryCode);
}
