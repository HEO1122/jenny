package com.increpas.cls2.dao;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.increpas.cls2.util.*;
import com.increpas.cls2.vo.*;

public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 총 게시물 갯수 조회 전담 처리함수
	public int getTotal() {
		return sqlSession.selectOne("reSQL.getTotal");
	}
	
	// 페이지 게시글 리스트 조회 전담 처리함수
	public List getRnoList(PageUtil page) {
		return sqlSession.selectList("reSQL.rnoList", page);
	}
	
	// 원글 등록 전담 처리함수
	public int addBoard(BoardVO bVO) {
		return sqlSession.insert("reSQL.addReBoard", bVO);
	}
}
