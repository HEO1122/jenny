package com.increpas.cls2.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.increpas.cls2.dao.*;
import com.increpas.cls2.vo.*;

/**
 * 	이 클래스는 설문조사 관련 요청을 전담처리할 클래스
 * @author	전은석
 * @since	2021.06.01
 * @version v.1.0
 * @see
 * 			작업이력 ]
 * 					2021/06/01	-	담당자		: 전은석
 * 									작업내용	: 클래스 제작
 * 												  설문조사 리스트 요청 함수 제작
 *
 */

@Controller
@RequestMapping("/survey")
public class Survey {
	@Autowired
	SurveyDao sDao;
	
	/*
		진행중인 설문 리스트 요청 처리함수
	 */
	@RequestMapping("/surveyList.cls")
	public ModelAndView surveyList(ModelAndView mv) {
		
		// 뷰 설정
		mv.setViewName("survey/surveyList");
		return mv;
	}
}
