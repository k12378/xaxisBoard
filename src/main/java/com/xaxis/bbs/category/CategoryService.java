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
	
	private CategoryDao categoryDao;
	
	public List<Category> getAllCategory(){
		categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		return this.categoryDao.getCategoryAllList();
	}
	
	public Category getCategoryItem(int categoryCode){
		categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		return this.categoryDao.getCategoryItem(categoryCode);
	}
	
	public List<Category> getCategoryDepthItems(int categoryCode, int depth){
		categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		return this.categoryDao.getCategoryDepthItems(categoryCode, depth);
	}
	
	public void updateCategoryItem(Category category){
		categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		this.categoryDao.updateCategoryItem(category);
	}
	
	public void deleteCategoryItem(int categoryCode){
		categoryDao = sqlSessionTemplate.getMapper(CategoryDao.class);
		this.categoryDao.deleteCategoryItem(categoryCode);
	}
}