package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.UserDto;

public interface IUserDao {
//	회원가입        insertUser
	public int insertUser(UserDto dto);
//	로그인          getLogin
	public UserDto getLogin(Map<String, Object> map);
//	아이디 찾기      getFindId
	public String getFindId(Map<String, Object> map);
//	비밀번호 찾기    getFindPassword
	public String getFindPassword(Map<String, Object> map);
//	사용자 전체 조회  getAllUser
	public List<UserDto> getAllUser();
//	사용자 상세 조회  getOneUser
	public UserDto getOneUser(String id);
//	사용자 권한 수정  updateUserAuth
	public int updateUserAuth(String id);
//	사용자 정보 수정  updateUserInfo
	public int updateUserInfo(Map<String, Object> map);
//	사용자 탈퇴      deleteUser
	public int deleteUser(String id);
//	사용자 다중삭제   multiDeleteUser
	public int multiDeleteUser(List<String> ids);
//	아이디 중복 검사
	public int joinIdCheck(String id);
}
