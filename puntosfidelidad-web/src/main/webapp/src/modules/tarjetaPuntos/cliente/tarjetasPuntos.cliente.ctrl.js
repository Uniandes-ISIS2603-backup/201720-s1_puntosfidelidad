(function (ng) {
    var mod = ng.module("tarjetasPuntosClienteModule");
    mod.controller("tarjetasPuntosClienteCtrl", ['$scope', '$http','$state' ,function ($scope, $http, $state) {
            $scope.elementosTP = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$state.params.clienteUsuario+"/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elementosTP = response.data;
            });
        }]);

})(window.angular);




