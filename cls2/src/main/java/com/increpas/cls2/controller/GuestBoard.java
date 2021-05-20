package com.increpas.cls2.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 	이 클래스는 방명록 관련 요청을 처리할 컨트롤러 클래스
 * @author	전은석
 * @since	2021.05.18
 * @version	v.1.0
 * @see
 * 			작업이력 ]
 * 				2021.05.18	- 전은석
 * 					작업 내용 : 클래스 생성
 *
 */
@Controller
@RequestMapping("/gBoard")
public class GuestBoard {
	
	@RequestMapping("/gBoardList.cls")
	public String gBoardList() {
		return "gBoard/gBoardList";
	}
}
