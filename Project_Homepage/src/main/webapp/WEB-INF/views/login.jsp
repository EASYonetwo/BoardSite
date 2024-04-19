<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<div style="width: 500px; margin: 0 auto;">
			<h2 style="text-align: center; margin:30px 0; "><b>로그인</b></h2>
			<form class="form-horizontal" action="./login.do" method="post">
				<div class="form-group">
			      <label class="control-label col-sm-2" for="id">I D</label>
			      <div class="col-sm-9">
			        <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
			      </div>
			    </div>
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="password">PW</label>
			      <div class="col-sm-9">          
			        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
			      </div>
			    </div>
			    <div class="form-group" style="text-align: center; margin-top:30px;">
				    <button type="submit" class="btn btn-primary" style="width: 400px; margin-bottom: 10px;">로그인</button>
			    </div>
			</form>
			<button class="btn btn-primary" onclick="location.href='./join.do'" style="width: 400px; margin: 0 0 20px 50px;">회원가입</button>
			<button class="btn btn-primary" onclick="location.href='./findID.do'" style="width: 400px; margin: 5px 0 40px 50px;">ID/ PW 찾기</button>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>