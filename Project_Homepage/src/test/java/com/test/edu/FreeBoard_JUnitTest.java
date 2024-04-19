package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.dto.FileDto;
import com.min.edu.dto.FreeBoardDto;
import com.min.edu.model.FreeBoardDaoImpl;
import com.min.edu.model.IFreeBoardDao;
import com.min.edu.support.SqlDaoSupport;

public class FreeBoard_JUnitTest {
	
	private IFreeBoardDao dao;
	
	@Before
	public void test() {
		SqlSessionFactory manager = SqlDaoSupport.getFactory();
		SqlSession session = manager.openSession();
		dao = new FreeBoardDaoImpl();
		assertNotNull(session);
	}
	
	@Test
	public void test요() {
//		전체조회
//		Map<String, Object> map0 = new HashMap<String, Object>();
//		map0.put("first", 1);
//		map0.put("last", 5);
//		List<FreeBoardDto> list1 = dao.getAllFB(map0);
//		assertEquals(5, list1.size());
//		상세조회
//		FreeBoardDto dto = dao.getOneFB("20");
//		assertNotNull(dto);
//		상세조회
//		FreeBoardDto dto = dao.getOneFBPost("30");
//		assertNotNull(dto);
//		글작성
//		파일작성
		FreeBoardDto bDto = new FreeBoardDto();
		bDto.setId("jiwon");
		bDto.setTitle("title Test11");
		bDto.setContent("test Content11");
		FileDto fDto = new FileDto();
		fDto.setFilename("fileName.png");
		fDto.setFilesize(32);
		int cnt1 = dao.insertFB(bDto, fDto);
		assertEquals(2, cnt1);
//		글수정
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("content", "내용수정할게요");
//		map1.put("seq", "20");
//		int cnt2 = dao.updatePost(map1);
//		assertEquals(1, cnt2);
//		파일삭제
//		int cnt3 = dao.deleteFile("1");
//		assertEquals(1, cnt3);
//		글삭제
//		파일삭제
//		int cnt4 = dao.deleteBoth("20");
//		assertEquals(2, cnt4);
//		파일다운로드
//		FileDto fDto = dao.getFile("3");
//		assertNotNull(fDto);
//		페이징
//		int n = dao.countBoard();
//		assertNotEquals(0, n);
	}
}
