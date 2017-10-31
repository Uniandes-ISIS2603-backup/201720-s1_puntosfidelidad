(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.controller("restaurantesCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $scope.selection = null;
            $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
            $scope.select = function(sele) { 
                $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes/"+sele)
                .then(function (response) {
               ;$scope.selection = response.data;
            })};
            
            $scope.save = function() {
            alert("Note Saved");
            };
        }]);
})(window.angular);