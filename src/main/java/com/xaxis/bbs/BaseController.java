package com.xaxis.bbs;

import org.springframework.web.servlet.ModelAndView;

public interface BaseController {
	
	/**
	 * 성공 코드
	 */
	public final String SUCCESS_MESSAGE = "success";
	
	/**
	 * 실패 코드 
	 */
	public final String FAILED_MESSAGE = "failed";
	
	/**
	 * 모든 리스트 조회 공통 함수
	 * @return
	 */
	public ModelAndView getListAll();
	
	/**
	 * 페이지 네이션을 위한 리스트 조회
	 * @param currentPage 현재 페이지 번호
	 * @param paseSize 페이지당 표시할 레코드 수
	 * @param searchField 검색 필드
	 * @param searchKeyword 검색어
	 * @param descField 정렬 필드
	 * @param descCode 정렬 코드
	 * @return
	 */
	public ModelAndView getList(int currentPage, int paseSize, String searchField, String searchKeyword, String descField, String descCode);
}
