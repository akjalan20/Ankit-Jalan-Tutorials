<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<title>APJ School Library Management System</title>
</head>
<body>
	<h1>${headerMessage}</h1>
		<table><tr><form:errors path="book.*"/></tr></table>
	
	<h2>Enter Book details</h2>
	<form action="${pageContext.request.contextPath}/library/addBooks" method="post">
		<table>
		<tr><td>Name</td><td><input type="text" name="bookName"/></td></tr>
		<tr><td>ISDN</td><td><input type="text" name="bookIsdn"/></td></tr>
		<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
		<tr><td></td><td><input type="submit" value="Submit"/></td></tr>
		</table>
	
	</form>	
</body>
</html>