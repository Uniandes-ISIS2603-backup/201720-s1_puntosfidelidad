(function (ng) {
    var mod = ng.module("tarjetasPuntosModule");
    mod.controller("tarjetasPuntosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);
})(window.angular);