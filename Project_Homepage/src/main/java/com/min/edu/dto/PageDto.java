package com.min.edu.dto;

public class PageDto {
	//게시물에 대한 변수 설정
	//게시물의 총 개수
	private int totalCount; //DB에 저장된 게시물 개수
	//한 페이지당 보여지는 게시물의 개수
	private int countList; //5개
	//페이징에 대한 변수 설정
	//한 그룹의 페이지 개수
	private int countPage; //5개
	//한 그룹의 시작번호
	private int stagePage; //((선택된 페이지번호 -1)/한그룹의페이지개수)*한그룹의페이지개수 +1
	//한 그룹의 끝 번호
	private int endPage; //해당그룹의 시작번호+ 한그룹의페이지개수 -1
	//선택된 페이지 번호
	private int page; //해당 페이지가 0보다 작으면 1페이지로, 전체 페이지보다 크면 전체 페이지로
	//전체 페이지 개수(끝 페이지 번호)
	private int totalPage; //(게시글 총개수/한페이지당보여지는 게시글의 개수) + (게시글총개수%페이지당보여지는게시글>0?1:0)
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		//0보다 작으면 1페이지로, 마지막 페이지보다 크면 마지막 페이지로 넘어감
		if(page <= 0) {
			page=1;
		}else if(page > totalPage) {
			page=totalPage;
		}
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		int totalPageResult = (totalCount/countPage) + (totalCount%countPage>0?1:0); 
		this.totalPage = totalPageResult;
	}
	public int getStagePage() {
		return stagePage;
	}
	public void setStagePage(int stagePage) {
		int stagePageResult = ((page-1)/countPage)*countPage +1;
		this.stagePage = stagePageResult;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		int endPageResult = stagePage+countPage -1;
		if(endPageResult > totalPage) {
			endPageResult = totalPage;
		}
		this.endPage = endPageResult;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCountList() {
		return countList;
	}
	public void setCountList(int countList) {
		this.countList = countList;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	@Override
	public String toString() {
		return "PageDto [totalCount=" + totalCount + ", countList=" + countList + ", countPage=" + countPage
				+ ", stagePage=" + stagePage + ", endPage=" + endPage + ", page=" + page + ", totalPage=" + totalPage
				+ "]";
	}
}
