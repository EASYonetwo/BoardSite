/*회원관리*/

function logout() {
	var logoutResult = confirm('정말 로그아웃하시겠습니까?');

	if (logoutResult) {
		alert('로그아웃되었습니다');
		location.href = "./logout.do";
	}
}

/*체크박스*/
function allCheck(bool) {
	var chs = document.getElementsByClassName("ch");
	console.log(bool)
	for (let i = 0; i < chs.length; i++) {
		chs[i].checked = bool;
	}
}
function chk() {
	var allChk = document.getElementById("allChk")
	var chs = document.getElementsByClassName("ch");
	var cnt = 0;
	for (let i = 0; i < chs.length; i++) {
		if (chs[i].checked) {
			cnt++;
		}
	}
	if (chs.length == cnt) {
		allChk.checked = true;
	} else {
		allChk.checked = false;
	}
}
/*회원삭제*/
function delUser() {
	var chs = document.getElementsByName("ch");
	var cnt=0;
	
	for(let i=0; i<chs.length; i++){
		if(chs[i].checked){
			cnt++;
		}
	}
	
	if(cnt == 0){
		alert('한개 이상 선택해주세요');
		return false;
	}
	var delResult = confirm('정말 삭제하시겠습니까?');
	if (delResult) {
		var frm = document.forms[0];
		frm.action = "./multiDeleteUser.do";
		frm.method = "post";
		frm.submit();
		alert('삭제되었습니다');
	}
}

function modifyInfo(){
	var name = document.getElementById("name");
	var address = document.getElementById("address");
	var phone = document.getElementById("phone");
	
	name.removeAttribute("readonly");
	name.removeAttribute("disabled");
	address.removeAttribute("readonly");
	address.removeAttribute("disabled");
	phone.removeAttribute("readonly");
	phone.removeAttribute("disabled");
	document.getElementsByTagName("input")[4].type = "hidden";
	document.getElementsByTagName("input")[5].type = "button";
}

function modifyInfoResult(){
	document.getElementById("id").removeAttribute("disabled");
	var frm = document.forms[0];
	frm.action = './updateUserInfo.do';
	frm.method="post";
	frm.submit();
	alert('수정되었습니다');
}

function delInfo(){
	var cf1 = confirm("정말 탈퇴하시겠습니까?");
	
	if(cf1){
		var cf2 =confirm("정말로 탈퇴하시겠습니까? 다시는 돌아올 수 없습니다");
		if(cf2){
			document.getElementById("id").removeAttribute("disabled");
			var frm = document.forms[0];
			frm.action = './deleteUser.do';
			frm.method="post";
			frm.submit();
		}
	}
	alert('그동안 이용해주셔서 감사합니다');
}

function modifyAuth(){
	var idd = document.getElementById("id");
	idd.removeAttribute("disabled");
	var id = idd.value;
	location.href="updateUserAuth.do?id="+id;
}

function delInfoAdmin(){
	var cf3 = confirm("정말 삭제하시겠습니까?");
	if(cf3){
		document.getElementById("id").removeAttribute("disabled");
		var frm = document.forms[0];
		frm.action = './deleteAdmin.do';
		frm.method="post";
		frm.submit();
	}
	alert('삭제되었습니다');
}

function idChk(){
	var id = document.getElementById("id");
	var idResult = document.getElementById("idResult");
	if(id == null || id.length == 0){
		alert('아이디를 입력해주세요');
		return false;
	}
	fetch("./joinIdCheck.do?id="+id.value,{})
	.then(response => response.json())
	.then(data => {
		if(data.cnt == '0'){
			idResult.textContent = "사용가능한 아이디입니다.";
			idResult.style = "color:green; margin-left:120px;";
		}else{
			id.value="";
			idResult.textContent = "이미 사용중인 아이디입니다.";
			idResult.style = "color:red; margin-left:120px;";
		}
	}).catch(error => alert('잘못된 요청입니다',error))
}