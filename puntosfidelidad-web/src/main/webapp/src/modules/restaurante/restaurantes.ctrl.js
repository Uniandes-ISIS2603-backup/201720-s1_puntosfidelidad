(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.controller("restaurantesCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);
})(window.angular);