package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.support.SqlDaoSupport;

public class UserDaoImpl implements IUserDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	private final String NS = "com.min.edu.model.UserDaoImpl.";

	@Override
	public int insertUser(UserDto dto) {
		logger.info("UserDaoImpl insertUser 회원가입");
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertUser",dto);
	}

	@Override
	public UserDto getLogin(Map<String, Object> map) {
		logger.info("UserDaoImpl getLogin 로그인");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin",map);
	}

	@Override
	public String getFindId(Map<String, Object> map) {
		logger.info("UserDaoImpl getFindId 아이디찾기");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getFindId", map);
	}

	@Override
	public String getFindPassword(Map<String, Object> map) {
		logger.info("UserDaoImpl getFindPassword 비밀번호찾기");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getFindPassword",map);
	}

	@Override
	public List<UserDto> getAllUser() {
		logger.info("UserDaoImpl getAllUser 전체회원조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public UserDto getOneUser(String id) {
		logger.info("UserDaoImpl getOneUser 상세회원조회");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getOneUser",id);
	}

	@Override
	public int updateUserAuth(String id) {
		logger.info("UserDaoImpl updateUserAuth 권한수정");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateUserAuth", id);
	}

	@Override
	public int updateUserInfo(Map<String, Object> map) {
		logger.info("UserDaoImpl updateUserInfo 정보수정");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateUserInfo", map);
	}

	@Override
	public int deleteUser(String id) {
		logger.info("UserDaoImpl deleteUser 회원탈퇴");
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"deleteUser",id);
	}

	@Override
	public int multiDeleteUser(List<String> ids) {
		logger.info("UserDaoImpl multiDeleteUser 회원탈퇴");
		SqlSession session = manager.openSession(true);
		return session.delete(NS+"multiDeleteUser",ids);
	}

	@Override
	public int joinIdCheck(String id) {
		logger.info("UserDaoImpl joinIdCheck 아이디 중복검사");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"joinIdCheck",id);
	}

}
