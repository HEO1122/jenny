package com.increpas.cls2.service;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.RedirectView;

import com.increpas.cls2.dao.*;
import com.increpas.cls2.vo.*;

public class SurveyService {
	@Autowired
	SurveyDao sDao;
	
	/*
	 * 설문응답 추가 서비스 함수
	 */
	@Transactional
	public void addSrvyService(SurveyVO sVO, RedirectView rv, HttpSession session) {
		// 할일 
		// 데이터 준비하고
		rv.setUrl("/cls2/survey/survey.cls");
		String sid = (String) session.getAttribute("SID");
		sVO.setId(sid);
		int[] arr = sVO.getQnolist();
		for(int i = 0 ; i < arr.length; i++) {
			// 아이디 채우고
			// 문항번호채우고
			sVO.setQno(arr[i]);
			// 데이터베이스에 추가하고
			sDao.insertAnswer(sVO);
		}
		
		rv.setUrl("/cls2/survey/surveyList.cls");
	}
}
