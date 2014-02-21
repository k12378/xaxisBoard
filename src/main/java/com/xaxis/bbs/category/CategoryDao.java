package com.xaxis.bbs.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xaxis.bbs.model.Category;

public interface CategoryDao {
	
	public List<Category> getCategoryAllList();
	
	public Category getCategoryItem(@Param("categoryCode") int categoryCode);
	
	public Category getBoardCategory(@Param("boardCode") String boardCode);
	
	public List<Category> getCategoryDepthItems(@Param("categoryCode") int categoryCode, @Param("depth") int depth ); 
		
	public void updateCategoryItem(Category category);
	
	public void deleteCategoryItem(@Param("categoryCode") int categoryCode);
	
	public int addCategoryItem(Category category);
}
