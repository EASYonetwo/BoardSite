package com.test.edu;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;
import com.min.edu.support.SqlDaoSupport;

public class User_JUnitTest {
	
	private IUserDao dao;

	@Before
	public void test() {
		SqlSessionFactory manager = SqlDaoSupport.getFactory();
		SqlSession session = manager.openSession();
		dao = new UserDaoImpl();
		assertNotNull(session);
	}
	
	//@Test
	public void UserTest() {
//		회원가입
		UserDto dto1 = new UserDto("jiwon", "0000", "이지원", "신림동", "01042907410");
		int row1 = dao.insertUser(dto1);
		assertEquals(1, row1);
//		로그인
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id","jiwon");
		map1.put("password","0000");
		UserDto dto2 = dao.getLogin(map1);
		assertNotNull(dto2);
//		아이디 찾기
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "이지원");
		map2.put("phone", "01042907410");
		String findID = dao.getFindId(map2);
		assertEquals("jiwon", findID);
//		비밀번호 찾기
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "이지원");
		map3.put("id", "jiwon");
		map3.put("phone", "01042907410");
		String findPW = dao.getFindPassword(map3);
		assertEquals("0000", findPW);
//		사용자 전체 조회
		List<UserDto> lists1 = dao.getAllUser();
		assertNotEquals(0, lists1.size());
//		사용자 상세 조회
		UserDto dto3 = dao.getOneUser("jiwon");
		assertNotNull(dto3);
//		사용자 권한 수정
		int row2 = dao.updateUserAuth("jiwon");
		assertEquals(1, row2);
//		사용자 정보 수정
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("name", "개명함");
		map4.put("address", "이사함");
		map4.put("phone", "01077777777");
		map4.put("id", "jiwon");
		int row3 = dao.updateUserInfo(map4);
		assertEquals(1, row3);
//		사용자 탈퇴
		int row4 = dao.deleteUser("jiwon");
		assertEquals(1, row4);
	}
//	@Test
	public void multiDelBynamic() {
		String[] ids = {"ljw","jy","지원"};
		List<String> idList = Arrays.asList(ids);
		System.out.println(idList);
		int row = dao.multiDeleteUser(idList);
		assertNotEquals(0, row);
	}
	
	@Test
	public void idchkTest() {
		int n = dao.joinIdCheck("easy");
		assertEquals(1, n);
	}
}
