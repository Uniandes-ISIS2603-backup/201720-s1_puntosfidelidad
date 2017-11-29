(function (ng) {
    var mod = ng.module("tarjetasPuntosClienteModule");
    mod.controller("tarjetasPuntosClienteCtrl", ['$scope', '$http','$rootScope' ,function ($scope, $http,$rootScope) {
            $scope.elementosTP = [];
            $scope.usuarioActual= sessionStorage.getItem("usuario");
            $rootScope.nuevaRecarga = false;

            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$scope.usuarioActual+"/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elementosTP = response.data;
            });
        }]);

})(window.angular);




