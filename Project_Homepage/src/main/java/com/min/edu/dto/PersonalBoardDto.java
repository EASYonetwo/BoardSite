package com.min.edu.dto;

public class PersonalBoardDto {
	private int seq;
	private String id;
	private String title;
	private String content;
	private String reply;
	private String regdate;
	private String delflag;
	private String adminreply;
	
	public PersonalBoardDto() {}
	@Override
	public String toString() {
		return "PersonalBoardDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", reply="
				+ reply + ", regdate=" + regdate + ", delflag=" + delflag + ", adminreply=" + adminreply + "]";
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getAdminreply() {
		return adminreply;
	}
	public void setAdminreply(String adminreply) {
		this.adminreply = adminreply;
	}
}
