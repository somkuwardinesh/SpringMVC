
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
	String contextPath = request.getContextPath();
	pageContext.setAttribute("contextPath", contextPath);
%>


<html>
<head>
<title>Registration Page</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	

</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>

	<form:form id="student" name="student" method="post" commandName="student"
		action="${pageContext.request.contextPath}/save" class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Student Info</legend>

			<!-- Text input-->
			<div class="form-group">
				<form:label path="name" class="col-md-4 control-label"
					for="textinput">Name</form:label>
				<div class="col-md-4">
					<form:input path="name" id="name" name="name" type="text"
						placeholder="enter the name" class="form-control input-md" />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label path="age" class="col-md-4 control-label"
					for="textinput">Age</form:label>
				<div class="col-md-4">
					<form:input path="age" id="age" name="age"
						type="text" placeholder="enter the age"
						class="form-control input-md" />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label path="city" class="col-md-4 control-label"
					for="textinput">City</form:label>
				<div class="col-md-4">
					<form:input path="city" id="city" name="city" type="text"
						placeholder="enter the city" class="form-control input-md" />

				</div>
			</div> 
			
			 <div class="form-group">
				<form:label path="course.id" class="col-md-4 control-label"
					for="textinput">CourseName</form:label>
				<div class="col-md-4">
						<form:select path="course.id" id="course.id" name="course.id" class="form-control" multiple="true">
								<form:options items="${cmap}" />
						</form:select>
				</div>
			</div>

					<div class="form-group">
						<div class="col-md-4">
							<button id="save" name="save" type="submit"
								class="btn btn-primary">Save</button>
						</div>
					</div>

		</fieldset>
	</form:form>
</body>




</html>