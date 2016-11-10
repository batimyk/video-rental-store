var app = angular.module('app', []);

app
  .config(
    function($httpProvider) {
      $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    }).controller("home", function($http, $location, $scope) {
    var self = this;
    $http.get("/user").success(function(data) {
      self.user = data.userAuthentication.details.name;
      self.authenticated = true;
    }).error(function() {
      self.user = "N/A";
      self.authenticated = false;
    });
    self.logout = function() {
      $http.post('logout', {}).success(function() {
        self.authenticated = false;
        $location.path("/");
      }).error(function(data) {
        console.log("Logout failed");
        self.authenticated = false;
      });
    };
    self.submit = function() {
      var response = $http.post("/search", $scope.searchCriteria);
      response.success(function(data) {
      self.responseData = data;
      self.responseCollected = true;
      console.log("Response ok");
      console.log(data);
      });
      response.error(function(data) {
        console.log("Exception details: " + JSON.stringify({data: data}));
      });

      console.log(self.responseData);
    };
    self.reset = function() {
      $scope.searchCriteria = {};
      self.responseCollected = false;
    };
  });




