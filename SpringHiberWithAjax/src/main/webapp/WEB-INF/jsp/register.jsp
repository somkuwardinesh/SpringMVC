
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
	$(document)
			.ready(
					function() {

						$.ajax({
									type : "GET",
									contentType : "application/json",
									url : "${pageContext.request.contextPath}/user",
									dataType : 'json',
									success : function(data) {
										var table = '';
										$.each(data,function(i, user) {
															table += '<tr><td>'
																	+ user.name
																	+ '</td><td>'
																	+ user.mobileNo
																	+ '</td><td>'
																	+ user.city
																	+ '</td><td> <button onClick="edit('
																	+ user.id
																	+ ')">edit</button><button onClick="deleteUser('
																	+ user.id
																	+ ')">Delete</button>'
																	+ '</td></tr>';
														});
										$('#tBody').append(table);
										console.log("success: ", data);
									},
									error : function(e) {
										console.log("ERROR: ", e);
									}
								});

						$("#save")
								.click(
										function() {

											var te = $("#id").val();
											if (te > 0) {
												var user = {}
												user["id"] = $("#id").val();
												user["name"] = $("#name").val();
												user["mobileNo"] = $(
														"#mobileNo").val();
												user["city"] = $("#city").val();

												$.ajax({
															type : "PUT",
															contentType : "application/json",
															url : "${pageContext.request.contextPath}/user",
															data : JSON.stringify(user),
															dataType : 'json',
															success : function(
																	data) {

																$('td')
																		.remove();
																var table = '';
																$
																		.each(
																				data,
																				function(
																						i,
																						user) {
																					table += '<tr><td>'
																							+ user.name
																							+ '</td><td>'
																							+ user.mobileNo
																							+ '</td><td>'
																							+ user.city
																							+ '</td><td> <button onClick="edit('
																							+ user.id
																							+ ')">edit</button><button onClick="deleteUser('
																							+ user.id
																							+ ')">Delete</button>'
																							+ '</td></tr>';
																				});
																$('#tBody')
																		.append(
																				table);

																$("#id")
																		.val('');
																$("#name").val(
																		'');
																$("#mobileNo")
																		.val('');
																$("#city").val(
																		'');

																console
																		.log(
																				"success: ",
																				data);
															},
															error : function(e) {
																console
																		.log(
																				"ERROR: ",
																				e);
															}
														});
											} else {
												var user = {}
												user["name"] = $("#name").val();
												user["mobileNo"] = $(
														"#mobileNo").val();
												user["city"] = $("#city").val();
														$.ajax({
															type : "POST",
															contentType : "application/json",
															url : "${pageContext.request.contextPath}/user",
															data : JSON
																	.stringify(user),
															dataType : 'json',
															success : function(
																	data) {
																var table = '';
																table += '<tr><td>'
																		+ data.name
																		+ '</td><td>'
																		+ data.mobileNo
																		+ '</td><td>'
																		+ data.city
																		+ '</td><td> <button onClick="edit('
																		+ data.id
																		+ ')">edit</button><button onClick="deleteUser('
																		+ data.id
																		+ ')">Delete</button>'
																		+ '</td></tr>'

																;
																$('#tBody')
																		.append(
																				table);

																$("#id")
																		.val('');
																$("#name").val(
																		'');
																$("#mobileNo")
																		.val('');
																$("#city").val(
																		'');

																console
																		.log(
																				"success: ",
																				data);
															},
															error : function(e) {
																console
																		.log(
																				"ERROR: ",
																				e);
															}
														});
											}

										});
					});
</script>

<script type="text/javascript">
	function addUser() {
		myUser.action = "${pageContext.request.contextPath}/add";
		myUser.submit();
	}

	function deleteUser(id) {
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/user/" + id,
			success : function(data) {
				$('td').remove();
				var table = '';
				$.each(data, function(i, user) {
					var a = user.id;
					table += '<tr><td>' + user.name + '</td><td>'
							+ user.mobileNo + '</td><td>' + user.city
							+ '</td><td> <button onClick="edit(' + user.id
							+ ')">edit</button><button onClick="deleteUser('
							+ user.id + ')">Delete</button>' + '</td></tr>';
				});
				$('#tBody').append(table);

				console.log("success: ", data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});

	}
	function edit(id) {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "${pageContext.request.contextPath}/user/" + id,
			success : function(data) {
				$("#name").val(data.name);
				$("#mobileNo").val(data.mobileNo);
				$("#city").val(data.city);
				$("#id").val(data.id);
				console.log("success: ", data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			}
		});
	}
</script>
</head>
<body>
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
			<c:set var="id" scope="request" value="${myUser.id}" />
			<c:choose>
				<c:when test='${id == 0}'>
					<div class="form-group">
						<div class="col-md-4">
							<button id="save" name="save" type="button"
								class="btn btn-primary" onclick="">Save</button>
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
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>