
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
			<table border="1">
					<thead>
							<th>ID</th>
							<th>NAME</th>
							<th>CITY</th>
							<th>AGE</th>
					</thead>
					
					<tbody>
						<c:forEach items="${studentList}" var="student">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.city}</td>
								<td>${student.age}</td>							
							</tr>
							
						</c:forEach>
					</tbody>
			
			</table>
			
			
			
			<spring:url value="/report?type=xls" var="xlsURL"/>
			<spring:url value="/report?type=pdf" var="pdfURL"/>
			<a href="${xlsURL}">Download Excel</a>
			<a href="${pdfURL}">Download PDF</a>
</body>
</html>


