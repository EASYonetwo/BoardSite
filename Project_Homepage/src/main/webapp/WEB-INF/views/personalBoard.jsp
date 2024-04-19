<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의게시판</title>
</head>
<%@ include file="./header.jsp"%>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>문의 게시판</b></h2>
		<c:if test="${loginInfo.auth eq 'A'}"></c:if>
		<c:if test="${loginInfo.auth ne 'A'}">
			<input type="button" value="글쓰기" class="btn btn-info" style="margin-left: 700px;" onclick="location.href='./personalBoardInsert.do'">
		</c:if>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>연번</th>
					<th colspan="2" style="text-align: center;">제목</th>
					<th>작성자</th>
					<th>등록일</th>
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
						<tr onclick="location.href='./personalBoardDetail.do?seq=${list.seq}'">
							<td>${vs.count}</td>
								<c:if test="${fn:toUpperCase(list.reply) eq 'Y'}">
									<td style="color: green">[답변완료]</td>
								</c:if>
								<c:if test="${fn:toUpperCase(list.reply) ne 'Y'}">
									<td style="color: red">[답변전] </td>
								</c:if>
							<td>${list.title}</td>
							<td>${list.id}</td>
							<td>${list.regdate}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
<%@ include file="./footer.jsp"%>
</html>