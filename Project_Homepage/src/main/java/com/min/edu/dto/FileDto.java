package com.min.edu.dto;

public class FileDto {
	private int fseq ;
	private int boardseq;
	private String filename;
	private int filesize;
	private String regdate ;
	private String enabled ;
	public FileDto() {}
	public int getSeq() {
		return fseq;
	}
	public void setSeq(int seq) {
		this.fseq = seq;
	}
	public int getBoardseq() {
		return boardseq;
	}
	public void setBoardseq(int boardseq) {
		this.boardseq = boardseq;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "FileDto [fseq=" + fseq + ", boardseq=" + boardseq + ", filename=" + filename + ", filesize=" + filesize
				+ ", regdate=" + regdate + ", enabled=" + enabled + "]";
	}
}
