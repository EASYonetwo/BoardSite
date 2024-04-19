package com.min.edu.dto;

import java.util.List;

public class FreeBoardDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String delflag;
	private String regdate;
	
	private List<FileDto> filedto;
	public FreeBoardDto() {}
	@Override
	public String toString() {
		return "FreeBoardDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", delflag="
				+ delflag + ", regdate=" + regdate + ", filedto=" + filedto + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public List<FileDto> getFiledto() {
		return filedto;
	}
	public void setFiledto(List<FileDto> filedto) {
		this.filedto = filedto;
	}
}
