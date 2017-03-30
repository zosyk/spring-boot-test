var myapp = angular.module("springDemo", []);

myapp.controller("stackOverflowController", function ($scope, $http) {

   $http({
       url: "http://localhost:8080/api/stackoverflow",
       method: "get"
   }).then(function (data) {
       $scope.websites = data.data;
   });

   // $http.get("localhost:8080/api/stackoverflow").success(function (data) {
   //     $scope.websites = data;
   // });

});