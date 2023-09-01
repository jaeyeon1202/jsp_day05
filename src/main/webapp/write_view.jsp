<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="write_save.jsp" method="post">
		이름 : <input type="text" name="name"> <br>
		제목 : <input type="text" name="title"><br>
		내용 : <textarea rows="" cols="" name="content"></textarea><br>
		<hr>
		<input type="submit" value="등록">
		<input type="button" value="목록이동" onclick="history.back()">
		<!-- histry.back() : 웹 브라우저에서 저장되어있는 이전으로 이동, 서버로 재요청아님 -->
	</form>
	
</body>
</html>