<html>
<head>
<%@ page isELIgnored="false" %>
<title>Library Management System</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h2>Following book was added:</h2>
	<table>
		<tr><td><b>Name: </b></td><td>${book.bookName}</td></tr>
		<tr><td><b>ISDN: </b></td><td>${book.bookIsdn}</td></tr>
		<tr>
			<td><form method="get" action="${pageContext.request.contextPath}/welcome">
					<input type="submit" value="Back to Home Page" />
				</form>
		<tr>
	</table>
</body>
</html>