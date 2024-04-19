<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<style type="text/css">
	a:hover{
		cursor: pointer;
	}
	h3{
		text-align: center;
	}
	.admin{
		padding:50px;
	}
</style>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>관리자페이지</b></h2>
		<div class="admin">
			<h3><a href="./allUser.do">1. 사용자 전체조회</a></h3>
			<h3><a href="./adminReply.do">2. 문의게시판 답변관리</a></h3>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>