package com.increpas.cls2.dao;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

public class MemberDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int getIdCnt(String sid) {
		return sqlSession.selectOne("mSQL.idCheck", sid);
	}
}
