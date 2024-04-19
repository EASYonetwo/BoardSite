package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.FileDto;
import com.min.edu.dto.FreeBoardDto;

public interface IFreeBoardDao {
//	전체조회           getAllFB
	public List<FreeBoardDto> getAllFB(Map<String, Object> map);
//	상세조회           getOneFB
	public FreeBoardDto getOneFB(String seq);
//	상세조회(글만)      getOneFBPost
	public FreeBoardDto getOneFBPost(String seq);
//	글작성             insertFBPost
//	파일작성           insertFBFile
	public int insertFB(FreeBoardDto bDto, FileDto fDto);
//	글수정             updatePost
	public int updatePost(Map<String, Object> map);
//	파일삭제           deleteFile
	public int deleteFile(String seq);
//	글삭제             deletePostBoth
//	글 삭제시 파일삭제 deleteFileBoth
	public int deleteBoth(String dSeq);
//	파일다운로드       getFile
	public FileDto getFile(String seq);
//	페이징을 위한 갯수  countBoard
	public int countBoard();
}
