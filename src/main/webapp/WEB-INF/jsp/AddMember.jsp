<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<title>Library Management System</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/library/add/addmember?siteTheme=orange">orange</a>
		<a href="${pageContext.request.contextPath}/library/add/addmember?siteTheme=green">green</a>
	</p>
	<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>
	<a href="${pageContext.request.contextPath}/library/add/addmember?siteLanguage=en">English</a>
	<a href="${pageContext.request.contextPath}/library/add/addmember?siteLanguage=hi">Hindi</a>

	<h1>${headerMessage}</h1>

	<table>
		<tr>
			<form:errors path="member.*" cssClass="errorblock" element="div" />
		</tr>
	</table>
	<!-- This displays any binding errors sent by the controller class -->

	<h2>
		<b>Enter Member details</b>
	</h2>
	<form action="${pageContext.request.contextPath}/library/addMember"
		method="post">
		<table>
			<tr>
				<td><spring:message code="lbl.member.firstname" /></td>
				<td><input type="text" name="firstName" /></td>
				<td><form:errors path="member.firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><select name="gender">
						<option value="M">Male</option>
						<option value="F">Female</option>
				</select></td>
			</tr>
			<tr>
				<td>Hobby:</td>
				<td><input type="text" name="hobby" /></td>
				<td><form:errors path="member.hobby" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input type="text" name="phoneNo" /></td>
				<td><form:errors path="phoneNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date of Birth:</td>
				<td><input type="text" id="datepicker" name="dateofBirth"></td>
				<td><form:errors path="member.dateofBirth" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Id Type:</td>
				<td><select name="identificationType">
						<option value="DL">Driving License</option>
						<option value="Passport">Passport</option>
				</select></td>
			</tr>
			<tr>
				<td>Id No:</td>
				<td><input type="text" name="identificationNo" /></td>
			</tr>
			<!-- <tr>
				<td>Interests:</td>
				<td><select name="interests" multiple="multiple" size="4">
						<option value="Fiction">Fiction</option>
						<option value="Science">Science</option>
						<option value="History">History</option>
						<option value="Computers">Computers</option>
				</select></td>
			</tr> -->
		</table>
		<table>
			<tr>
				<td><b>Enter Present Address:</b></td>
				<td></td>
			</tr>
			<tr>
				<td>Address Line 1:</td>
				<td><input type="text" name="address.addressLine1" /></td>
			</tr>
			<tr>
				<td>Address Line 2:</td>
				<td><input type="text" name="address.addressLine2" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="address.city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="address.state" /></td>
			</tr>
			<tr>
				<td>Pin Code:</td>
				<td><input type="text" name="address.pinCode" /></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="address.country" /></td>
			</tr>
		</table>
		<table>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>