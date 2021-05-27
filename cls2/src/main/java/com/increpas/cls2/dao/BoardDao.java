package com.increpas.cls2.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.increpas.cls2.vo.*;
import com.increpas.cls2.util.*;

/**
 * 이 클래스는 게시판 관련 데이터베이스 작업을 전담해서 처리할 클래스
 * @author	전은석
 * @since	2021.05.27
 * @version	v.1.0
 * @see		
 * 			작업이력 ]
 * 				2021.05.27	- 	담당자		: 전은석
 *								작업내용	: 클래스제작, 총게시글 조회 처리
 */
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 총게시글 수 조회 전담 처리함수
	public int getTotal() {
		return sqlSession.selectOne("bSQL.totalCnt");
	}
	
	// 게시글 조회 전담 처리함수
	public List boardList(PageUtil page) {
		return sqlSession.selectList("bSQL.boardList", page);
	}
	
	// 게시글 상세 정보 조회 전담 처리함수
	public BoardVO boardDetail(int bno) {
		return sqlSession.selectOne("bSQL.boardDetail", bno);
	}
	
	// 첨부파일 저장이름 조회 전담 처리함수
	public List subFileList(int bno) {
		return sqlSession.selectList("bSQL.subFile", bno);
	}
}
