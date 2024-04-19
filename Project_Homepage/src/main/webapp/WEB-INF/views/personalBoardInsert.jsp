<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 입력 페이지</title>
</head>
<%@ include file="./header.jsp" %>
<body>
	<div id="container">
		<h2 style="text-align: center;"><b>문의글 입력</b></h2>
		<form action="./personalBoardInsert.do" method="post">
			<input type="hidden" value="${id}" id="id" name="id">
			<table class="table">
				<tr>
					<td>작성자</td>
					<td>${id}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="title" name="title" class="col-sm-10">
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea id="content" name="content" rows="10" cols="90" style="resize: none;"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="올리기" class="btn btn-info">
						<input type="button" value="취소" class="btn btn-danger" onclick="cancel()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
<%@ include file="./footer.jsp" %>
<script type="text/javascript">
	function cancel() {
		var cf = confirm('지금 취소하시면 정보는 저장되지 않습니다. 나가시겠습니까?');
		if(cf){
			var id = document.getElementById("id").value;
			location.href="./personalBoard.do?id="+id;
		}
	}
</script>
</html>