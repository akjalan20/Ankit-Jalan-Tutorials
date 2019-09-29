	 var app = angular.module("myApp", ["ngRoute"]);
	 app.config(function($routeProvider){
		 $routeProvider
		 .when("/", {
			 template : "<h1>Main</h1><p>Click on the links to change this content <a href='#/teacher'>Teacher</a></p>"
		 })
		 .when("teacher", {
			 template : "<h1>Teachers</h1><p>This Section will display list of teachers</p>"
		 })
		 .otherwise({
			 redirectTo : "/"
		 });
	 });