package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.PersonalBoardDto;

public interface IPersonalBoardDao {
	//전체조회_사용자
	public List<PersonalBoardDto> selectAllPBUser(String id);
	//전체조회_관리자
	public List<PersonalBoardDto> selectAllPBAdmin();
	//상세조회_사용자
	public PersonalBoardDto selectOnePBUser(String seq);
	//상세조회_관리자
	public PersonalBoardDto selectOnePBAdmin(String seq);
	//글작성
	public int insertPB(PersonalBoardDto dto);
	//글수정
	public int updatePB(Map<String, Object> map);
	//글삭제(다중삭제)
	public int deletePB(String seq);
	//댓글입력_관리자
	public int insertReply(Map<String, Object> map);
	//댓글수정_관리자
	public int updateReply(Map<String, Object> map);
	//댓글삭제_관리자
	public int deleteReply(String seq);
}
