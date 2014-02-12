package com.xaxis.bbs.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xaxis.bbs.model.Category;

public interface CategoryDao {
	
	public List<Category> getCategoryAllList();
	
	public Category getCategoryItem(@Param("categoryCode") String categoryCode);
	
	public Category getBoardCategory(@Param("boardCode") String boardCode);
	
	public void updateCategoryItem(Category category);
	
	public void deleteCategoryItem(@Param("categoryCode") String categoryCode);
	
	public void addCategoryItem(Category category);
}
