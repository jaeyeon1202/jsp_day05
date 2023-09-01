<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	list.jsp
	<% request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dao" class="test.testDAO"/>
	<table border="1">
		<tr>
			<td>번호(id)</td> <td>이름(name)</td> <td>제목(title)</td> <td>날짜(savedate)</td>
			<td>조회수(hit)</td> <td>그룹번호(idgroup)</td> <td>step</td> <td>들여쓰기(indent)</td>
		</tr>
		<c:forEach var="dto" items="${dao.list() }">
		<tr>
			<td>${dto.id }</td> <td>${dto.name }
			<td>
				<c:forEach begin="1" end="${dto.indent }">
					→
				</c:forEach>
				<a href="content_view.jsp?id=${dto.id}">${dto.title }</a>
			</td> 
			
			<td>${dto.savedate }
			<td>${dto.hit }</td> <td>${dto.idgroup }</td>
			<td>${dto.step }</td> <td>${dto.indent }</td>
		</tr>	
		</c:forEach>
		<tr>
			<td colspan="8">
				<a href="write_view.jsp">글 등록</a>
			</td>
		</tr>	
	</table>
	
</body>
</html>