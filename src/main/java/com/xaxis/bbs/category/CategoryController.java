package com.xaxis.bbs.category;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xaxis.bbs.BaseController;
import com.xaxis.bbs.model.Category;

@Controller
@RequestMapping("/category/")
public class CategoryController implements BaseController{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 카테고리 모든 리스트
	 * URL => /category/list/
	 */
	@Override
	@RequestMapping(value="list/", method=RequestMethod.GET)
	public ModelAndView getListAll() {
		// TODO Auto-generated method stub
		Map<String, Object> responseData = new HashMap<String, Object>();
		
		List<Category> categoryList = categoryService.getAllCategory();
				
		for( Category category: categoryList){
			log.debug("\n CategoryCode => "+ category.getCategoryCode() + " \n categoryName => "+ category.getCategoryName() );
		}
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", categoryList);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 카테고리 아이템 조회
	 * URL => /category/item/{categoryCode}/
	 * @param categoryCode pathVariable
	 * @return
	 */
	@RequestMapping(value="item/{categoryCode}/", method=RequestMethod.GET)
	public ModelAndView getItem(@PathVariable("categoryCode") String categoryCode) {
		// TODO Auto-generated method stub
		Map<String, Object> responseData = new HashMap<String, Object>();
		Category categoryItem = categoryService.getCategoryItem(categoryCode);
		
		responseData.put("result", BaseController.SUCCESS_MESSAGE);
		responseData.put("resultData", categoryItem);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 카테고리 아이템 업데이트
	 * URL => /category/item/update/{categoryCode}/
	 * Post 방식의 Request 만을 지원
	 * @param categoryCode PathVariable
	 * @param categoryName 카테고리 명
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="item/update/{categoryCode}/", method=RequestMethod.POST)
	public ModelAndView updateItem(@PathVariable("categoryCode") String categoryCode,
			@RequestParam(value="categoryName", required=true) String categoryName) throws UnsupportedEncodingException{
		Map<String, Object> responseData = new HashMap<String, Object>();
		String resultMessage = "";
		
		Category categoryItem = categoryService.getCategoryItem(categoryCode);
		
		if( !categoryItem.equals(null) && !categoryItem.getCategoryCode().isEmpty() ){
			Category category = new Category(categoryCode, URLDecoder.decode(categoryName, "UTF-8"));
			categoryService.updateCategoryItem(category);
			resultMessage = BaseController.SUCCESS_MESSAGE;
		}else{
			resultMessage = BaseController.FAILED_MESSAGE;
		}
		
		responseData.put("result", resultMessage);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}
	
	/**
	 * 카테고리 아이템 삭제
	 * URL => /category/item/delete/{categoryCode}/
	 * @param categoryCode PathVariable
	 * @return
	 */
	@RequestMapping(value="item/delete/{categoryCode}/", method=RequestMethod.GET)
	public ModelAndView deleteItem(@PathVariable("categoryCode") String categoryCode){
		Map<String, Object> responseData = new HashMap<String, Object>();
		String resultMessage = "";
		
		Category categoryItem = categoryService.getCategoryItem(categoryCode);
		
		if( !categoryItem.equals(null) && !categoryItem.getCategoryCode().isEmpty() ){
			categoryService.deleteCategoryItem(categoryCode);
			resultMessage = BaseController.SUCCESS_MESSAGE;
		}else{
			resultMessage = BaseController.FAILED_MESSAGE;
		}
		
		responseData.put("result", resultMessage);
		
		return new ModelAndView("jsonView", "responseData", responseData);
	}

	@Override
	public ModelAndView getList(int currentPage, int paseSize,
			String searchField, String searchKeyword, String descField,
			String descCode) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
