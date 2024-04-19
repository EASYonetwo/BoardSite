<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 상세조회</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<button onclick="window.history.back()">뒤로가기</button>
		<h2 style="text-align: center;"><b>자유게시판 상세조회</b></h2>
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
						<c:if test="${sessionId eq dto.id}">
							<textarea id="content" name="content" rows="10" cols="100" style="resize: none;">${dto.content}</textarea>
						</c:if>
						<c:if test="${sessionId ne dto.id}">
							<textarea id="content" name="content" rows="10" cols="100" style="resize: none;" readonly="readonly">${dto.content}</textarea>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>파일</td>
					<c:if test="${dto.filedto eq null}">
						<td style="color: #ccc;">파일없음</td>
					</c:if>
					<c:if test="${dto.filedto ne null}">
						<c:forEach var="filedto" items="${dto.filedto}" varStatus="vs">
							<c:if test="${filedto.enabled eq 'N'}">
								<td style="color: #ccc;">파일없음</td>
							</c:if>
							<c:if test="${filedto.enabled ne 'N'}">
								<td>${filedto.filename}[${filedto.filesize}&nbsp;byte]
									<input type="hidden" name="fileSeq" value="${filedto.seq}">
									<input type="button" value="다운로드">
									<c:if test="${sessionId eq dto.id}">
										<input type="button" value="파일삭제">
									</c:if>
								</td>
							</c:if>
						</c:forEach>
					</c:if>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<c:if test="${sessionAuth eq 'A' && sessionId eq dto.id}">
							<input type="button" value="수정" class="btn btn-info">
							<input type="button" value="삭제" class="btn btn-danger">
						</c:if>
						<c:if test="${sessionAuth eq 'A' && sessionId ne dto.id}">
							<input type="button" value="삭제" class="btn btn-danger">
						</c:if>
						<c:if test="${sessionAuth ne 'A' && sessionId eq dto.id}">
							<input type="button" value="수정" class="btn btn-info">
							<input type="button" value="삭제" class="btn btn-danger">
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
<script type="text/javascript">
	window.onload = function() {
		var btns = document.querySelectorAll("input[type=button]");
		for(let i=0;i<btns.length;i++){
			btns[i].onclick=function(){
				formProcess(this.value)
			}
		}
	}
	function formProcess(doAction){
		var frm =document.forms[0]
		
		if(doAction == '삭제'){
			var deleteResult = confirm("정말 삭제하시겠습니까? 글이 삭제됩니다");
			if(deleteResult){
				frm.action ='./freeBoardDelete.do';
				frm.submit();
				return false;
			}
			return false;
		}else if(doAction == '수정'){
			frm.action ='./freeBoardUpdate.do';
			frm.submit();
			return false;
		}else if(doAction == '파일삭제'){
			frm.action ='./freeBoardFileDelete.do';
			frm.submit();
		}else{
			frm.action ='./freeBoardFileDownload.do';
			frm.submit();
		}
	}
</script>
</html>