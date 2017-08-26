
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

<script type="text/javascript">
	function addUser() {
		myUser.action = "${pageContext.request.contextPath}/add";
		myUser.submit();
	}
	
</script>	

</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-success">${message}</div>
	</c:if>

	<form:form id="myUser" name="myUser" method="post" commandName="myUser"
		action="/add" class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Form Name</legend>

			<form:input path="id" type="hidden" name="id" />

			<!-- Text input-->
			<div class="form-group">
				<form:label path="name" class="col-md-4 control-label"
					for="textinput">Name</form:label>
				<div class="col-md-4">
					<form:input path="name" id="name" name="name" type="text"
						placeholder="enter the name" class="form-control input-md" />
					<form:errors class="error-message" path="name"/>
				</div>
				
			</div>

			

			<!-- Text input-->
			<div class="form-group">
				<form:label path="city" class="col-md-4 control-label"
					for="textinput">City</form:label>
				<div class="col-md-4">
					<form:input path="city" id="city" name="city" type="text"
						placeholder="enter the city" class="form-control input-md" />
					<form:errors class="error-message" path="city"/>

				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<form:label path="mobileNo" class="col-md-4 control-label"
					for="textinput">Mobile NO</form:label>
				<div class="col-md-4">
					<form:input path="mobileNo" id="mobileNo" name="mobileNo"
						type="text" placeholder="enter the mobile no"
						class="form-control input-md" />
						<form:errors class="error-message" path="mobileNo"/>

				</div>
			</div>

			<c:set var="id" scope="request" value="${myUser.id}" />
			<c:choose>
				<c:when test='${id == 0}'>
					<div class="form-group">
						<div class="col-md-4">
							<button id="save" name="save" type="button"
								class="btn btn-primary" onclick="addUser()">Save</button>
						</div>
					</div>
				</c:when>

				<c:otherwise>
					<div class="form-group">
						<div class="col-md-4">
							<button id="" name="" type="button" class="btn btn-primary"
								onclick="addUser()">Update</button>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

		</fieldset>
	</form:form>









	<main class="container pt-5">
	<div class="card mb-5">
		<div class="card-header">Data</div>
		<div class="card-block p-0">

			<table class="table table-bordered table-sm m-0">
				<thead class="">
					<tr>
						<th>Name</th>
						<th>Mobile NO</th>
						<th>City</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody id="tBody">

					<c:forEach items="${myUserList}" var="user">
						<tr>
							<td>${user.name}</td>
							<td>${user.mobileNo}</td>
							<td>${user.city}</td>
							<td>
							<a href="${pageContext.request.contextPath}/index?id=${user.id}">EDIT</a>
							<a href="${pageContext.request.contextPath}/delete?id=${user.id}">DELETE</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


		</div>
	</main>





</body>




</html>