(function (ng) {
    var mod = ng.module("comprasModule");
    mod.controller("comprasCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/compras")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);

})(window.angular);




