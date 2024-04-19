<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
<style type="text/css">
	footer {
		width: 100%;
		height: 100px;
		background-color: #111;
		text-align: center;
		vertical-align: middle;
		color: white;
		padding-top: 20px;
	}
	
	#container {
		width: 800px;
		margin: 0 auto;
	}
</style>
<title>header</title>
</head>
<body>
	<header style="color: white">
		<nav class="navbar navbar-inverse" style="border-radius: 0;">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="./main.do">LeeJiWon</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="./main.do">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">게시판 <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<c:if test="${loginInfo.auth ne 'A'}">
								<li><a href="./personalBoard.do?id=${loginInfo.id}">문의게시판</a></li>
							</c:if>
							<c:if test="${loginInfo.auth eq 'A'}">
								<li><a href="./adminReply.do">문의게시판</a></li>
							</c:if>
							<li><a href="./freeBoard.do">자유게시판</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${loginInfo eq null}">
						<li><a href="./login.do"><span class="glyphicon glyphicon-user"></span> SignIn</a></li>
						<li><a href="./join.do"><span class="glyphicon glyphicon-log-in"></span> SignUp</a></li>
					</c:if>
					<c:if test="${loginInfo ne null}">
						<li style="line-height: 50px; margin-right: 20px;"><b>(<c:choose>
							<c:when test="${fn:toUpperCase(loginInfo.auth) eq 'A'}">관리자</c:when>
							<c:otherwise>사용자</c:otherwise>
						</c:choose>)</b> ${loginInfo.name}님, 안녕하세요!</li>
						<c:choose>
							<c:when test="${fn:toUpperCase(loginInfo.auth) eq 'A'}">
								<li><a href="./adminpage.do"><span class="glyphicon glyphicon-user"></span> 관리자페이지</a></li>
								<li><a href="#" onclick="logout(); return false;"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="./mypage.do?id=${loginInfo.id}"><span class="glyphicon glyphicon-user"></span> 마이페이지</a></li>
								<li><a href="#" onclick="logout(); return false;"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>