<html>
<head>
<%@ page isELIgnored="false"%>
<title>APJ School Library Management System</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h2>Please select:</h2>
	<table>
		<tr>
			<td><form method="get" action="${pageContext.request.contextPath}/library/add/addbook">
					<input type="submit" value="Add a Book" />
				</form>
		<tr>
			<td><form method="get" action="${pageContext.request.contextPath}/library/add/addmember">
					<input type="submit" value="Add a Member" />
				</form></td>
		</tr>
	</table>



</body>
</html>