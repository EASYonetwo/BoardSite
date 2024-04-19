<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 상세조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>사용자 상세조회</b></h2>
		<form>
			<table class="table" style="width: 500px; margin: 0 auto;">
				<tbody>
					<tr>
						<td><b>ID</b></td>
						<td>
							<input type="text" id="id" name="id" readonly="readonly" disabled="disabled" value="${dto.id}" class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>이름</b></td>
						<td>
							<input type="text" id="name" name="name" readonly="readonly" disabled="disabled" value="${dto.name}" class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>주소</b></td>
						<td>
							<input type="text" id="address" name="address" readonly="readonly" disabled="disabled" value="${dto.address}" class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>전화번호</b></td>
						<td>
							<input type="text" id="phone" name="phone" readonly="readonly" disabled="disabled" value="${dto.phone}" class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>가입일</b></td>
						<td>
							<input type="text" id="joindate" name="joindate" readonly="readonly" disabled="disabled" value="${dto.joindate}" class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>권한</b></td>
						<td>
							<c:if test="${dto.auth eq 'A'}">
								<input type="text" id="auth" name="auth" readonly="readonly" disabled="disabled" value="관리자" class="col-sm-10">
							</c:if>
							<c:if test="${dto.auth ne 'A'}">
								<input type="text" id="auth" name="auth" readonly="readonly" disabled="disabled" value="사용자" class="col-sm-10">
							</c:if>
						</td>
					</tr>
					<tr>
						<td><b>사용여부</b></td>
						<td>
							<c:if test="${dto.enabled eq 'Y'}">
								<input type="text" id="enabled" name="enabled" readonly="readonly" disabled="disabled" value="사용" class="col-sm-10">
							</c:if>
							<c:if test="${dto.enabled ne 'Y'}">
								<input type="text" id="enabled" name="enabled" readonly="readonly" disabled="disabled" value="탈퇴" class="col-sm-10">
							</c:if>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input type="button" class="btn btn-info" value="권한부여" onclick="modifyAuth()">
							<input type="button" class="btn btn-danger" value="삭제" onclick="delInfoAdmin()">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>