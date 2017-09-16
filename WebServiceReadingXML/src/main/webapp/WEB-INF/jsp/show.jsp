<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="POST"  action="${pageContext.request.contextPath}/user" enctype="multipart/form-data">
                <div class="load-line">
                    <input type="file" name="file" class="file"/>
                    <input type="submit" value="Upload">
  				 </div>
   </form>                 
</body>
</html>