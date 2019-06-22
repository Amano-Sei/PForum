<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("desu") %>
	<form action="test.jsp" method="post">
		<input type="checkbox" name="desu">
		<input type="submit">
	</form>
	<p>${requestScope.a== requestScope.b }</p>
	<%
		request.setAttribute("a", "abc");
	%>
	<p>${requestScope.a== requestScope.b }</p>	
	<%
		request.setAttribute("c", "abc");		
	%>
	<p>${requestScope.a== requestScope.b }</p>
</body>
</html>