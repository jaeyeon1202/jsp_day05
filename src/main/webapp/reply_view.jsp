<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="test.testDTO"/>
<jsp:useBean id="dao" class="test.testDAO"/>
reply_view.jsp <br>
	
	<form action="reply.jsp" method="post">
		아이디<input type="text" readonly name="id" value="${param.id }"> <br>
		이름<input type="text"  name="name" value="${param.name }" readonly> <br>
		제목<input type="text" name="title" value="${param.title }"> <br>
		내용<textarea name="content"></textarea> <br>
		<input type="submit" value="답글전송">
	</form>
</body>
</html>