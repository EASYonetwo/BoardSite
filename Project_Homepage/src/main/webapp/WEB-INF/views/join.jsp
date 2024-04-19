<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<style type="text/css">
	label{
		padding-top: 8px;
	}
</style>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<div style="width: 600px; margin: 0 auto;">
			<h2 style="text-align: center;"><b>회원가입</b></h2>
			<form action="./join.do" method="post">
				<div class="form-group">
			    	<label class="control-label col-sm-2" for="id">아이디*</label>
				    <div class="col-sm-8">
				        <input type="text" class="form-control" id="id" name="id">
				    </div>
				    <input type="button" id ="idChkBtn" class="btn btn-info" value="중복검사" onclick="idChk()">
				</div>
				<div class="form-group" style="margin-left:120px;" id="idResult"></div>
				<div class="form-group">
				    <label class="control-label col-sm-2" for="password">비밀번호*</label>
				    <div class="col-sm-10">
				        <input type="password" class="form-group form-control" id="password" name="password">
				    </div>
				</div>
				<div class="form-group">
				    <label class="control-label col-sm-2" for="name">이름*</label>
				    <div class="col-sm-10">
				        <input type="text" class="form-group form-control" id="name" name="name">
				    </div>
				</div>
				<hr>
				<div class="form-group">
				    <label class="control-label col-sm-2" for="address">주소</label>
				    <div class="col-sm-10">
				        <input type="text" class="form-group form-control" id="address" name="address">
				    </div>
				</div>
				<hr>
				<div class="form-group">
				    <label class="control-label col-sm-2" for="phone">전화번호*</label>
				    <div class="col-sm-10">
				        <input type="text" class="form-group form-control" id="phone" name="phone" placeholder="ex) 01012345678" maxlength="11">
				    </div>
				</div>
				<p style="text-align: right; font-size: 8px; color: #666; margin-right: 20px;">* 필수입력사항입니다</p>
				<button type="submit" class="btn btn-success" style="width:98%; margin: 30px 0;">회원가입</button>
			</form>
		</div>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>