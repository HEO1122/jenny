package com.increpas.cls2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import com.increpas.cls2.dao.*;
import com.increpas.cls2.vo.*;
import com.increpas.cls2.util.*;

/**
 * 	이 클래스는 게시판 관련 요청 처리 컨트롤러 클래스
 * @author	전은석
 * @since	2021.05.18
 * @version	v.1.0
 * @see
 * 			작업이력 ]
 * 				2021.05.18 
 * 					- 담당자 	: 전은석
 * 					- 작업내용 	: 클래스 제작
 * 
 * 				2021.05.27
 * 					- 담당자	: 전은석
 * 					- 작업내용 	: 게시판 리스트보기 기능 구현
 *
 */

@Controller
@RequestMapping("/board")
public class Board {
	@Autowired
	BoardDao bDao;
	
	/*
	 * 게시글 리스트 보기 요청 처리함수
	 */
	@RequestMapping("/board.cls")
	public ModelAndView boardList(PageUtil page, ModelAndView mv) {
		/*
			페이징 처리에 필요한 데이터
				현재페이지, 총게시글 수, 보여질 게시글 수, 이동가능한 페이지 수
				
			지금의 경우는 한페이지에 5개의 글이 보이도록 해주고,
			이동가능한 페이지수도 5개로 해주자.
		 */
		int total = bDao.getTotal();
		// 데이터 만들고
		page.setPage(page.getNowPage(), total, 5, 5);
		
		List list = bDao.boardList(page);
		
		// 데이터 전달하고
		mv.addObject("PAGE", page);
		mv.addObject("LIST", list);
		// 뷰 셋팅하고
		mv.setViewName("board/boardList");
		// 반환값 반환해주고
		return mv;
	}
	
	/*
	 * 게시글 상세보기 요청 처리함수
	 */
	@RequestMapping("/boardDetail.cls")
	public ModelAndView boardDetail(int bno, int nowPage, ModelAndView mv) {
		// 게시글정보 꺼내오고
		BoardVO data = bDao.boardDetail(bno);
		data.setSdate();
		// 첨부파일 리스트 꺼내오고
		List list = bDao.subFileList(bno);
		// 데이터 전달하고
		mv.addObject("DATA", data);
		mv.addObject("LIST", list);
		mv.addObject("nowPage", nowPage);
		// 뷰 부르고
		mv.setViewName("board/boardDetail");
		return mv;
	}
}
