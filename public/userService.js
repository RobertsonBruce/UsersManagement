angular.module('userService', [])
 .controller('userCtrl',['$scope','$http', function ($scope,$http) {

     $scope.addUser = function () {
         $http.post("http://localhost:8080/users", $scope.user).then(addSuccess,addError);
     };

     $scope.loadUsers = function () {
         $http.get("http://localhost:8080/users").then(function (reponse) {
             var users = reponse.data;
             users.forEach(function (user) {
                 user.birthday = new Date(user.birthday);
             });
             $scope.users = users;
         });
     };

     $scope.updateUser = function ($index) {
         $http.patch("http://localhost:8080/users", $scope.users[$index]).then(updateSuccess, updateError);

     };

     $scope.removeUser = function ($index) {
         $http.delete("http://localhost:8080/users/" + $scope.users[$index].id).then(removeSuccess, removeError);
     };

     $scope.isFormValid = function () {
         return !_.isEmpty($scope.user.name)
             && !_.isEmpty($scope.user.surname)
             && !_.isEmpty($scope.user.login)
             && !_.isEmpty($scope.user.password)
             && !_.isEmpty($scope.user.description)
             && !_.isEmpty($scope.user.address)
             && !_.isEmpty($scope.user.birthday.toDateString());
     };

     function addSuccess() {
         $scope.user = {};
         $scope.showAddDialog = false;
         $scope.loadUsers();
     };
     function addError(response) {
         if (response.data.exception == "org.springframework.web.bind.MethodArgumentNotValidException"){
             alert("Все поля должны быть не null!")
         }else {
             alert(response.data.message)
         }
     };

     function removeSuccess() {
         $scope.loadUsers();
     };
     function removeError() {
         alert("Не удалось удалить пользователя!")
     };

     function updateSuccess() {
         $scope.loadUsers();
     };

     function updateError(response) {
         if (response.data.exception == "org.springframework.web.bind.MethodArgumentNotValidException"){
             alert("Все поля должны быть не null!")
         }else {
             alert(response.data.message)
         }
     };

     function init() {
         $scope.user = {};
         $scope.loadUsers();
     };
     init();

 }]);