package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.FileDto;
import com.min.edu.dto.FreeBoardDto;
import com.min.edu.support.SqlDaoSupport;

public class FreeBoardDaoImpl implements IFreeBoardDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	private final String NS = "com.min.edu.model.FreeBoardDaoImpl.";
	
	@Override
	public List<FreeBoardDto> getAllFB(Map<String, Object> map) {
		logger.info("FreeBoardDaoImpl getAllFB");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllFB",map);
	}

	@Override
	public FreeBoardDto getOneFB(String seq) {
		logger.info("FreeBoardDaoImpl getOneFB");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getOneFB",seq);
	}
	
	@Override
	public FreeBoardDto getOneFBPost(String seq) {
		logger.info("FreeBoardDaoImpl getOneFBPost");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getOneFBPost",seq);
	}

	@Override
	public int insertFB(FreeBoardDto bDto, FileDto fDto) {
		logger.info("FreeBoardDaoImpl 글작성+파일작성");
		int cnt=0;
		SqlSession session = manager.openSession(false);
		
		try {
			cnt += session.insert(NS+"insertFBPost", bDto);
			cnt += session.insert(NS+"insertFBFile", fDto);
			session.commit();
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updatePost(Map<String, Object> map) {
		logger.info("FreeBoardDaoImpl updatePost");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updatePost",map);
	}

	@Override
	public int deleteFile(String seq) {
		logger.info("FreeBoardDaoImpl deleteFile");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"deleteFile",seq);
	}

	@Override
	public int deleteBoth(String bSeq) {
		logger.info("FreeBoardDaoImpl 글 삭제시 파일삭제");
		int cnt=0;
		SqlSession session = manager.openSession(false);
		
		try {
			cnt += session.update(NS+"deletePostBoth",bSeq);
			cnt += session.update(NS+"deleteFileBoth",bSeq);
			session.commit();
		}catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public FileDto getFile(String seq) {
		logger.info("FreeBoardDaoImpl fetFile");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getFile",seq);
	}

	@Override
	public int countBoard() {
		logger.info("FreeBoardDaoImpl countBoard");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"countBoard");
	}

}
