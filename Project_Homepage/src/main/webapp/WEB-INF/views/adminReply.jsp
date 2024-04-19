<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 답변관리 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<button onclick="window.history.back()">뒤로가기</button>
		<h2 style="text-align: center;"><b>답변관리 페이지</b></h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>연번</th>
					<th colspan="2" style="text-align: center;">제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>삭제여부</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="6" style="color: red; text-align: center;">-- 작성된 글이 없습니다 --</td>
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
							<td>${list.delflag}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>