(function (ng) {
    var mod = ng.module("productoModule");
    mod.controller("productosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/productos")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);

})(window.angular);




