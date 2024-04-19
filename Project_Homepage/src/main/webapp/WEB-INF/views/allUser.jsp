<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자전체조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<button onclick="window.history.back()">뒤로가기</button>
		<h2 style="text-align: center;"><b>사용자 전체조회</b></h2>
		<form>
			<table class="table table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" id="allChk" onclick="allCheck(this.checked)"></th>
						<th>연번</th>
						<th>아이디</th>
						<th>이름</th>
						<th>주소</th>
						<th>전화번호</th>
						<th>가입일</th>
						<th>권한</th>
						<th>사용여부</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="vs">
						<tr>
							<c:if test="${fn: toUpperCase(list.enabled) ne 'Y' || fn: toUpperCase(list.auth) eq 'A'}">
								<td><input type="checkbox" disabled="disabled"></td>
							</c:if>
							<c:if test="${fn: toUpperCase(list.enabled) eq 'Y' && fn: toUpperCase(list.auth) eq 'U'}">
								<td><input type="checkbox" class="ch" name="ch" onclick="chk()" value="${list.id}"></td>
							</c:if>
							<td>${vs.count}</td>
							<td><a href="./userDetail.do?id=${list.id}">${list.id}</a></td>
							<td>${list.name}</td>
							<td>${list.address}</td>
							<td>${list.phone}</td>
							<td>${list.joindate}</td>
							<td>
								<c:if test="${fn: toUpperCase(list.auth) eq 'U'}">사용자</c:if>
								<c:if test="${fn: toUpperCase(list.auth) eq 'A'}">관리자</c:if>
							</td>
							<td>${list.enabled}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="9" style="text-align: center;">
							<input type="button" value="삭제" class="btn btn-danger" onclick="delUser()">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>