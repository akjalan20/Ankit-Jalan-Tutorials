<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angular Route</title>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.js"></script>
<script src="test.js"></script>
</head>
<body>
	<b>Route:</b>
	<br>
	<div ng-view></div>
</body>
</html>