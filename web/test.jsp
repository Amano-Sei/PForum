
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head></head>
<body>
	<%
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		if(request.getParameter("do") != null){
			List<FileItem> list = upload.parseRequest(request);
			Iterator<FileItem> it = list.iterator();
			while(it.hasNext()){
				FileItem item = it.next();
				out.println("<p>"+item.getContentType()+"==="+item.getFieldName()+"===="+item.getName()+"===="+item.getContentType()+"===="+item.getSize()+"</p>");
			}
		}
	%>
	<p>done</p>
	<form action="test.jsp?do=yes" method="post" enctype="multipart/form-data">
		<input type="file" name="desu">
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
	<%
		/*Cookie c = new Cookie("testdesu", "123456");
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);*/
	%>
	<p>${cookie.testdesu.value }</p>
</body>
</html>