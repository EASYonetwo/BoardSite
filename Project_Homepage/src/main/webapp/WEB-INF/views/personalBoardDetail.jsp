<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<button onclick="window.history.back()">뒤로가기</button>
		<h2 style="text-align: center;"><b>문의게시판 상세조회</b></h2>
		<form action="./" method="get">
			<input type="hidden" value="${dto.seq}" name="seq" id="seq">
			<input type="hidden" value="${dto.id}" name="id" id="id">
			<table class="table">
				<tr>
					<td>등록일</td>
					<td>${dto.regdate}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${dto.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<c:if test="${fn:toUpperCase(loginInfo.auth) eq 'A'}">
							<textarea id="content" name="content" rows="10" cols="100" style="resize: none;" readonly="readonly">${dto.content}</textarea>
						</c:if>
						<c:if test="${fn:toUpperCase(loginInfo.auth) ne 'A'}">
							<textarea id="content" name="content" rows="10" cols="100" style="resize: none;">${dto.content}</textarea>
						</c:if>
					</td>
				</tr>
				<c:if test="${fn:toUpperCase(loginInfo.auth) eq 'A'}">
				<tr>
					<td>댓글</td>
					<td>
						<textarea id="reply" name="reply" rows="5" cols="100" style="resize: none;"><c:if test="${dto.adminreply ne null}">${dto.adminreply}</c:if></textarea>
					</td>
				</tr>
				</c:if>
				<c:if test="${fn:toUpperCase(loginInfo.auth) ne 'A'}">
				<tr>
					<td>댓글</td>
					<c:if test="${dto.adminreply ne null}">
						<td>
							<textarea id="reply" name="reply" rows="5" cols="100" style="resize: none;" readonly="readonly">${dto.adminreply}</textarea>
						</td>
					</c:if>
					<c:if test="${dto.adminreply eq null}">
						<td style="color: #999;">
							<textarea id="reply" name="reply" rows="5" cols="100" style="resize: none;" readonly="readonly">아직 답변이 작성되지 않았습니다</textarea>
						</td>
					</c:if>
				</tr>
				</c:if>
				<tr>
					<td colspan="2" style="text-align: center;">
						<c:if test="${dto.delflag eq 'Y'}"></c:if>
						<c:if test="${dto.delflag ne 'Y'}">
							<c:if test="${fn:toUpperCase(loginInfo.auth) ne 'A'}">
								<input type="button" value="글수정" class="btn btn-info">
							</c:if>
							<c:if test="${fn:toUpperCase(loginInfo.auth) eq 'A' && dto.reply eq 'N'}">
								<input type="button" value="댓글달기" class="btn btn-info">
								<input type="button" value="댓글삭제" class="btn btn-danger">
							</c:if>
							<c:if test="${fn:toUpperCase(loginInfo.auth) eq 'A' && dto.reply ne 'N'}">
								<input type="button" value="댓글수정" class="btn btn-info">
								<input type="button" value="댓글삭제" class="btn btn-danger">
							</c:if>
							<input type="button" value="글삭제" class="btn btn-danger">
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
<script type="text/javascript">
	window.onload= function(){
		var btns = document.querySelectorAll("input[type=button]");
		for(let i=0;i<btns.length;i++){
			btns[i].onclick=function(){
				formProcess(this.value)
			}
		}
	}
	function formProcess(doAction){
		var frm =document.forms[0]
		if(doAction == '댓글달기'){
			frm.action ='./insertReply.do';
			frm.submit();
			return false;
		}else if(doAction == '댓글수정'){
			frm.action ='./insertReply.do';
			frm.submit();
			return false;
		}else if(doAction == '댓글삭제'){
			var deleteResult = confirm("정말 삭제하시겠습니까? 댓글이 삭제됩니다");
			if(deleteResult){
				frm.action ='./deleteReply.do';
				frm.submit();
				return false;
			}
			return false;
		}else if(doAction == '글삭제'){
			var deleteResult = confirm("정말 삭제하시겠습니까? 글이 삭제됩니다");
			if(deleteResult){
				frm.action ='./personalBoardDelete.do';
				frm.submit();
				return false;
			}
			return false;
		}else{
			frm.action ='./personalBoardUpdate.do';
			frm.submit();
			return false;
		}
	}
</script>
</html>