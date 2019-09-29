<html>
<head>
<%@ page isELIgnored="false"%>
<title>APJ School Library Management System</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h2>Following member was added:</h2>
	<table>
		<tr>
			<td>First Name:</td>
			<td>${member.firstName}</td>
		</tr>
		<tr>
			<td>Last Name Name:</td>
			<td>${member.lastName}</td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td>${member.gender}</td>
		</tr>
		<tr>
			<td>Semester:</td>
			<td>${member.semester}</td>
		</tr>
		<tr>
			<td>Phone No:</td>
			<td>${member.phoneNo}</td>
		</tr>
		<tr>
			<td>Date of Birth:</td>
			<td>${member.dateofBirth}</td>
		</tr>
		<tr>
			<td>Id Type:</td>
			<td>${member.identificationType}</td>
		</tr>
		<tr>
			<td>Id Number:</td>
			<td>${member.identificationNo}</td>
		</tr>
		<%-- <tr>
			<td>Interests:</td>
			<td>${member.interests}</td>
		</tr> --%>
	</table>

	<table>
		<tr>
			<td><b>Address:</b></td>
			<td></td>
		</tr>
		<tr>
			<td>Address Line 1:</td>
			<td>${member.address.addressLine1}</td>
		</tr>
		<tr>
			<td>Address Line 2:</td>
			<td>${member.address.addressLine2}</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>${member.address.city}</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>${member.address.state}</td>
		</tr>
		<tr>
			<td>Pin Code:</td>
			<td>${member.address.pinCode}</td>
		</tr>
		<tr>
			<td>Country:</td>
			<td>${member.address.country}</td>
		</tr>
	</table>

	<table>
		<tr>
			<td><form method="get"
					action="${pageContext.request.contextPath}/welcome">
					<input type="submit" value="Back to Home Page" />
				</form>
		<tr>
	</table>
</body>
</html>