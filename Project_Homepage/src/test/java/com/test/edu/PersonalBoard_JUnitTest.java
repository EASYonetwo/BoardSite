package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.PersonalBoardDto;
import com.min.edu.model.IPersonalBoardDao;
import com.min.edu.model.PersonalBoardDaoImpl;
import com.min.edu.support.SqlDaoSupport;

public class PersonalBoard_JUnitTest {
	
	private IPersonalBoardDao dao;

	@Before
	public void test() {
		SqlSessionFactory manager = SqlDaoSupport.getFactory();
		SqlSession session = manager.openSession();
		dao = new PersonalBoardDaoImpl();
		assertNotNull(session);
	}
	
	@Test
	public void test1() {
//		전체조회_사용자
		List<PersonalBoardDto> list1 = dao.selectAllPBUser("easy");
		assertNotEquals(0, list1.size());
//		전체조회_관리자
		List<PersonalBoardDto> list2 = dao.selectAllPBAdmin();
		assertNotEquals(0, list2.size());
//		상세조회_사용자
		PersonalBoardDto dto1 = dao.selectOnePBUser("20");
		assertNotNull(dto1);
//		상세조회_관리자
		PersonalBoardDto dto2 = dao.selectOnePBAdmin("20");
		assertNotNull(dto2);
//		글작성
		PersonalBoardDto inDto1 = new PersonalBoardDto();
		inDto1.setSeq(0);
		inDto1.setId("easy");
		inDto1.setTitle("게시글 제목 test 그만할래요..");
		inDto1.setContent("게시글 내용 test");
		int row1 = dao.insertPB(inDto1);
		assertNotEquals(0, row1);
//		글수정
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("seq", 20);
		map1.put("content", "글 수정 test");
		int row2 = dao.updatePB(map1);
		assertNotEquals(0, row2);
//		글삭제(다중삭제)
//		int row3 = dao.deletePB("20");
//		assertNotEquals(0, row3);
//		댓글입력_관리자
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("seq", "28");
		map2.put("adminreply", "답글 남겨드립니다");
		int row4 = dao.insertReply(map2);
		assertNotEquals(0, row4);
//		댓글수정_관리자
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("seq", 28);
		map3.put("adminreply", "답글달자마자 수정해버리기");
		int row5 = dao.updateReply(map3);
		assertNotEquals(0, row5);
//		댓글삭제_관리자
//		int row6 = dao.deleteReply("28");
//		assertNotEquals(0, row6);
	}
}
