package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.PersonalBoardDto;
import com.min.edu.support.SqlDaoSupport;

public class PersonalBoardDaoImpl implements IPersonalBoardDao {

	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	private final String NS = "com.min.edu.model.PersonalBoardDaoImpl.";
	
	@Override
	public List<PersonalBoardDto> selectAllPBUser(String id) {
		logger.info("PersonalBoardDaoImpl selectAllPBUser");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllPBUser", id);
	}
	@Override
	public List<PersonalBoardDto> selectAllPBAdmin() {
		logger.info("PersonalBoardDaoImpl selectAllPBAdmin");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"selectAllPBAdmin");
	}
	@Override
	public PersonalBoardDto selectOnePBUser(String seq) {
		logger.info("PersonalBoardDaoImpl selectOnePBUser");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectOnePBUser",seq);
	}
	@Override
	public PersonalBoardDto selectOnePBAdmin(String seq) {
		logger.info("PersonalBoardDaoImpl selectOnePBAdmin");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"selectOnePBAdmin",seq);
	}
	@Override
	public int insertPB(PersonalBoardDto dto) {
		logger.info("PersonalBoardDaoImpl insertPB");
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertPB", dto);
	}
	@Override
	public int updatePB(Map<String, Object> map) {
		logger.info("PersonalBoardDaoImpl updatePB");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updatePB", map);
	}
	@Override
	public int deletePB(String seq) {
		logger.info("PersonalBoardDaoImpl updatePB");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"deletePB", seq);
	}
	@Override
	public int insertReply(Map<String, Object> map) {
		logger.info("PersonalBoardDaoImpl insertReply");
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertReply", map);
	}
	@Override
	public int updateReply(Map<String, Object> map) {
		logger.info("PersonalBoardDaoImpl updateReply");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateReply", map);
	}
	@Override
	public int deleteReply(String seq) {
		logger.info("PersonalBoardDaoImpl deleteReply");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"deleteReply", seq);
	}
}
