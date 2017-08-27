
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



</head>
<body>

	<form:form id="myUser" name="myUser" method="post" commandName="myUser"
		action="${pageContext.request.contextPath}/add" class="form-horizontal" enctype="multipart/form-data">
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

	
						<!-- Text input-->
			<div class="form-group">
				<form:label path="fleUpload" class="col-md-4 control-label"
					for="textinput">File</form:label>
					
					
				<div class="col-md-4">
					<form:input path="fleUpload" id="fleUpload" name="fleUpload" type="file" 
						class="form-control input-md" />
						
					<form:input path="fleUpload" id="fleUpload" name="fleUpload" type="file" 
						class="form-control input-md" />
						
					<form:input path="fleUpload" id="fleUpload" name="fleUpload" type="file" 
						class="form-control input-md" />
						<form:errors class="error-message" path="fleUpload"/>
				</div>		
			
			</div>

					<div class="form-group">
						<div class="col-md-4">
							<button id="save" name="save" type="submit"
								class="btn btn-primary" >Save</button>
						</div>
					</div>


		</fieldset>
	</form:form>

</body>

</html>
 