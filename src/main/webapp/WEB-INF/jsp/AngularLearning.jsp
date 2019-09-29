<!DOCTYPE html>
<html lang="en" ng-app="myClassApp">
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
		<script src="controller.js"></script>
</head>
<body>
	<!-- <div ng-include="'file.html'"></div> -->
	
	<input type="text" ng-model="name"></input>
	<div>Hello! {{name | uppercase}}</div> 
	<!-- | applies filters in this case it converts the input to uppercase -->
	<div ng-bind="name"></div>
	
	<div>10 * 10 = {{10 * 10}}</div><br>
	
	<div ng-init="fees='100'">
	School Fees: <input type="text" ng-model="fees"></input>
	<div>School Fees in $: {{fees | currency}}</div>
	<div>School Fees in Rs.: {{fees * 65 | currency:"Rs. "}}</div>
	<div>School Fees in Rs (Rounded): {{fees * 65 | currency:"Rs. ":3}}</div>
	</div>
	
	<br><b>ng-repeat example:</b>
	<div ng-init="teachers=[{name:'Mr Rahul', subject:'English'},{name:'Mr Rajan', subject:'Maths'}]">			
		<p ng-repeat="teacher in teachers">
			Name: {{teacher.name}}<br>
			Subject: {{teacher.subject}}<br>
		</p>
	</div>
	<br>
	<b>Controllers:</b><br>
	<div ng-controller="myClassController">
		Period:
		<button ng-click="pOne()">1st Period</button>
		<button ng-click="pTwo()">2nd Period</button><br>
		Subject: {{periodSubject}}
	</div>
	
	
	
		
</body>
</html>