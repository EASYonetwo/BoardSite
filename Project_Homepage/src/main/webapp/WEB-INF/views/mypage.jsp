<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>마이페이지</b></h2>
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
							<input type="text" id="name" name="name" readonly="readonly" disabled="disabled" value="${dto.name}"  class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>주소</b></td>
						<td>
							<input type="text" id="address" name="address" readonly="readonly" disabled="disabled" value="${dto.address}"  class="col-sm-10">
						</td>
					</tr>
					<tr>
						<td><b>전화번호</b></td>
						<td>
							<input type="text" id="phone" name="phone" readonly="readonly" disabled="disabled" value="${dto.phone}" class="col-sm-10" maxlength="11">
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input type="button" class="btn btn-info" value="수정" onclick="modifyInfo()">
							<input type="hidden" class="btn btn-info" value="수정완료" onclick="modifyInfoResult()">
							<input type="button" class="btn btn-danger" value="탈퇴" onclick="delInfo()">
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
							<input type="button" class="btn btn-success" value="문의게시판" onclick="location.href='./personalBoard.do?id=${dto.id}'">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>