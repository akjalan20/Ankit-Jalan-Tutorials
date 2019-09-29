 var app = angular.module("myClassApp", []);
	 app.controller("myClassController", ["$scope", function($scope){
		 
		 $scope.periodSubject="Please select Period";
		 $scope.pOne = function(){
			 $scope.periodSubject="English"
		 };
		 $scope.pTwo = function(){
			 $scope.periodSubject="Maths"
		 };
	 }]);
	 