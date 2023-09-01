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
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dao" class="test.testDAO"/>
<jsp:useBean id="dto" class="test.testDTO"/>
<jsp:setProperty property="*" name="dto"/>

	${dao.reply(dto) }
	<%response.sendRedirect("list.jsp"); %>	
	

</body>
</html>