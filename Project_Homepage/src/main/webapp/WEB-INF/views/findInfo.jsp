<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보찾기 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<form class="form-horizontal" action="./findID.do" method="post">
			<h3 style="text-align: center;"><b>아이디찾기</b></h3>
			<div class="form-group">
		      <label class="control-label col-sm-2" for="nameId">이름</label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="nameId" placeholder="ex) 홍길동" name="nameId">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="phoneId">전화번호</label>
		      <div class="col-sm-9">          
		        <input type="text" class="form-control" id="phoneId" placeholder="ex) 01012345678" name="phoneId">
		      </div>
		    </div>
		    <div class="form-group" style="text-align: center; margin-top:30px;">
			    <button type="submit" class="btn btn-primary" style="width: 400px; margin-bottom: 10px;">아이디찾기</button>
		    </div>
		</form>
		<hr>
		<form class="form-horizontal" action="./findPW.do" method="post">
			<h3 style="text-align: center;"><b>비밀번호찾기</b></h3>
			<div class="form-group">
		      <label class="control-label col-sm-2" for="id">아이디</label>
		      <div class="col-sm-9">          
		        <input type="text" class="form-control" id="id" placeholder="ex) hong12" name="id">
		      </div>
		    </div>
			<div class="form-group">
		      <label class="control-label col-sm-2" for="namePw">이름</label>
		      <div class="col-sm-9">
		        <input type="text" class="form-control" id="namePw" placeholder="ex) 홍길동" name="namePw">
		      </div>
		    </div>
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="phonePw">전화번호</label>
		      <div class="col-sm-9">          
		        <input type="text" class="form-control" id="phonePw" placeholder="ex) 01012345678" name="phonePw">
		      </div>
		    </div>
		    <div class="form-group" style="text-align: center; margin-top:30px;">
			    <button type="submit" class="btn btn-primary" style="width: 400px; margin-bottom: 10px;">비밀번호찾기</button>
		    </div>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
</html>