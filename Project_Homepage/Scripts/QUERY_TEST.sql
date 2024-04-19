-- 회원관리

--1. 회원가입
INSERT INTO PROJECTUSER(ID, PASSWORD, NAME, 
			ADDRESS, PHONE, JOINDATE, 
			AUTH, ENABLED)
	VALUES ('easing','0000', '이지원1',
			'관악구','01000000000', SYSDATE,
			'U','Y');
--2. 로그인
SELECT ID, NAME, ADDRESS, PHONE, AUTH, ENABLED
	FROM PROJECTUSER p
	WHERE ID='easy' AND PASSWORD='0000'
	AND ENABLED = 'Y';
--3. 아이디 및 비밀번호 찾기
--3-1. 아이디찾기
SELECT ID
	FROM PROJECTUSER p
	WHERE NAME='이지원' AND PHONE='01011111111';
--3-2. 비밀번호찾기
SELECT PASSWORD
	FROM PROJECTUSER p
	WHERE ID='easy'AND NAME='이지원' AND PHONE='01011111111';
--4. 사용자 전체 조회
SELECT ID, NAME, ADDRESS, PHONE, AUTH, ENABLED
	FROM PROJECTUSER p;
--5. 사용자 상세 조회
SELECT ID, NAME, ADDRESS, PHONE, AUTH, ENABLED
	FROM PROJECTUSER p
	WHERE ID='easy';
--6. 사용자 권한 수정
UPDATE PROJECTUSER SET AUTH='A'
	WHERE ID='easy';
--7. 사용자 정보 수정
UPDATE PROJECTUSER SET NAME='이지원' , ADDRESS='원주시', PHONE ='01011111111'
	WHERE ID='easy';
--8. 사용자 탈퇴
UPDATE PROJECTUSER SET ENABLED='N'
	WHERE ID='easy';
--9. 사용자 다중 삭제
UPDATE PROJECTUSER SET ENABLED='N'
	WHERE ID IN ('easy','지원');
--10.아이디 중복검사
SELECT COUNT(*)
	FROM PROJECTUSER p
	WHERE ID = 'easy';

--문의게시판

--1. 전체조회_사용자
SELECT ID, TITLE, CONTENT, REGDATE, ADMINREPLY
	FROM PROJECTBOARD p
	WHERE ID='easy';
--2. 전체조회_관리자
SELECT SEQ, ID, TITLE, CONTENT,ADMINREPLY , REPLY, DELFLAG ,REGDATE 
	FROM PROJECTBOARD p;
--3. 상세조회_사용자
SELECT ID, TITLE, CONTENT, REGDATE, ADMINREPLY
	FROM PROJECTBOARD p
	WHERE SEQ='20';
--4. 상세조회_관리자
SELECT SEQ, ID, TITLE, CONTENT, REPLY, DELFLAG ,REGDATE 
	FROM PROJECTBOARD p
	WHERE SEQ='20';
--5. 글작성
INSERT INTO PROJECTBOARD(SEQ,ID,TITLE,CONTENT,
						REPLY,DELFLAG,REGDATE)
	VALUES (PROJECTBOARD_SEQ.NEXTVAL, 'easy', '문의글02', '문의내용입니다',
			'N', 'N', SYSDATE);
--6. 글수정
UPDATE PROJECTBOARD SET CONTENT='문의글 수정입니다'
	WHERE SEQ='20';
--7. 글삭제 (다중삭제 가능)
UPDATE PROJECTBOARD SET DELFLAG ='Y'
	WHERE SEQ='21';
--9. 댓글입력_관리자
UPDATE PROJECTBOARD SET ADMINREPLY = '답글달아드립니다^__^', REPLY = 'Y'
	WHERE SEQ='20';
--10. 댓글수정_관리자
UPDATE PROJECTBOARD SET ADMINREPLY = '답글달아드려요^__^'
	WHERE SEQ='20';
--10. 댓글삭제_관리자
UPDATE PROJECTBOARD SET ADMINREPLY = '', REPLY = 'N'
	WHERE SEQ='20';


--자유게시판

--1. 전체조회
SELECT SEQ, ID, TITLE|| '(' || CNT || ')' AS TITLE, REGDATE
	FROM (SELECT SEQ, ID, TITLE,
		(SELECT COUNT(*) FROM PROJECTFILE p2 
			WHERE P.SEQ = P2.BOARDSEQ AND P2.ENABLED = 'Y') AS CNT, REGDATE,
			ROW_NUMBER() OVER(ORDER BY SEQ) AS RN
		FROM PROJECTFILEBOARD p)
	WHERE RN<6;
--2. 상세조회
SELECT ID, TITLE, CONTENT, P.REGDATE, FILENAME
	FROM PROJECTFILEBOARD p JOIN PROJECTFILE p2 
	ON P.SEQ = P2.BOARDSEQ
	AND P.SEQ='30'
	AND DELFLAG ='N';
--2.1 파일이 없을때 글의 내용만 가져옴
SELECT ID, TITLE, CONTENT, P.REGDATE
	FROM PROJECTFILEBOARD p
	WHERE SEQ = '30' AND DELFLAG = 'N';
--3. 글작성(글+파일) --> COMMIT을 통해 사용할 예정
--3-1. 글작성
SELECT PROJECTFILEBOARD_SEQ.NEXTVAL FROM DUAL;
INSERT INTO PROJECTFILEBOARD(SEQ, ID, TITLE, 
							CONTENT, REGDATE, DELFLAG)
	VALUES (PROJECTFILEBOARD_SEQ.NEXTVAL, 'easy','파일게시판입니당',
			'파일게시판 내용인데용!', SYSDATE, 'N');
--3-2. 파일작성
INSERT INTO PROJECTFILE(SEQ,BOARDSEQ,FILENAME,
						FILESIZE,REGDATE,ENABLED)
	VALUES (PROJECTFILE_SEQ.NEXTVAL,PROJECTFILEBOARD_SEQ.CURRVAL,'filess.png',
			'32',SYSDATE, 'Y');
--4. 글수정
UPDATE PROJECTFILEBOARD SET CONTENT = '글 수정할게요~'
	WHERE SEQ = '20';
--5. 파일삭제
UPDATE PROJECTFILE SET ENABLED = 'N'
	WHERE SEQ = '1';
--6-1. 글삭제
UPDATE PROJECTFILEBOARD SET DELFLAG = 'N'
	WHERE SEQ = '26';
--6-2. 파일삭제
UPDATE PROJECTFILE SET ENABLED = 'N'
	WHERE BOARDSEQ = '26';
--7. 파일다운로드
SELECT SEQ, BOARDSEQ, FILENAME , FILESIZE ,REGDATE
	FROM PROJECTFILE p
	WHERE SEQ = '3' AND ENABLED = 'Y';
--8. 페이징
SELECT COUNT(*)
	FROM PROJECTFILEBOARD
	WHERE DELFLAG = 'N';