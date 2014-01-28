package com.xaxis.bbs.category;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xaxis.bbs.model.Category;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	public List<Category> getAllCategory(){		
		CategoryDao categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);		
		return categoryDao.getCategoryAllList();
	}
	
	public Category getCategoryItem(String categoryCode){
		CategoryDao categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		return categoryDao.getCategoryItem(categoryCode);
	}
	
	public void updateCategoryItem(Category category){
		CategoryDao categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		categoryDao.updateCategoryItem(category);
	}
	
	public void deleteCategoryItem(String categoryCode){
		CategoryDao categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		categoryDao.deleteCategoryItem(categoryCode);
	}
}