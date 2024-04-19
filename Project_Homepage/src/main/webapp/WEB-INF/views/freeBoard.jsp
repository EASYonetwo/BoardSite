<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style type="text/css">
	td{
		height:50px;
	}
</style>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>자유 게시판</b></h2>
		<c:if test="${sessionId ne ''}">
			<input type="button" value="글쓰기" class="btn btn-info" style="margin-left: 700px;" onclick="location.href='./freeBoardInsert.do'">
		</c:if>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>연번</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="5" style="color: red; text-align: center;">-- 작성된 글이 없습니다 --</td>
					</tr>
				</c:if>
				<c:if test="${list ne null}">
					<c:forEach var="list" items="${list}" varStatus="vs">
						<c:if test="${list.delflag eq 'Y'}">
							<tr>
								<td>${page.page*page.countList-page.countList + vs.count}</td>
								<td colspan="4"
									style="color: red; text-align: center; font-size: 0.8em;">
									--------------------- 삭제된 글입니다 ---------------------</td>
							</tr>
						</c:if>
						<c:if test="${list.delflag ne 'Y'}">
							<tr>
								<td>${page.page*page.countList-page.countList + vs.count}</td>
								<td><a href="./freeBoardDetail.do?seq=${list.seq}">${list.title}</a></td>
								<td>${list.id}</td>
								<td>${list.regdate}</td>
								<c:if test="${list.id eq sessionId || sessionAuth eq 'A'}">
									<td>
										<form action="./freeBoardDelete.do" method="get">
											<input type="hidden" id="seq" name="seq" value="${list.seq}">
											<button type="submit">삭제</button>
										</form>
									</td>
								</c:if>
								<c:if test="${list.id ne sessionId && sessionAuth ne 'A'}">
									<td></td>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div style="text-align: center;">${page.page} / ${page.totalPage}</div>
		<div style="text-align: center; margin-bottom: 20px;">
			<!-- 페이지 전으로 -->
			<c:if test="${page.page > page.countPage}">
				<a href="./freeBoard.do?page=1">◀◀</a>
				<a href="./freeBoard.do?page=${page.stagePage - page.countPage}">◁</a>
			</c:if>
			<!-- 페이지 번호 -->
			<c:forEach var="i" begin="${page.stagePage}" end="${page.endPage}"
				step="1">
				<a href="./freeBoard.do?page=${i}" style="margin:0 10px;">${i}</a>
			</c:forEach>
			<!-- 페이지 후로 -->
			<c:if test="${page.totalPage eq page.endPage}"></c:if>
			<c:if test="${page.totalPage ne page.endPage && page.page <(page.page-1/page.countPage)*page.countPage+1}">
				<a href="./freeBoard.do?page=${page.endPage+1}">▷</a>
				<a href="./freeBoard.do?page=${page.totalPage}">▶▶</a>
			</c:if>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>