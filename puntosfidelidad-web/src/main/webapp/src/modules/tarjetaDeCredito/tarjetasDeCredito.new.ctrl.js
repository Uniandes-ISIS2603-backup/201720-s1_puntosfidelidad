(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller("tarjetasDeCreditoNewCtrl", ['$scope', '$http', '$state', '$rootScope', function ($scope, $http, $state, $rootScope) {
            $rootScope.agregarTC = true;   
            $scope.tc={
                numero:null,
                banco:null
            };
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosTC = response.data;
                    });

            $scope.createTC = function () {
                $http.post("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/tarjetasDeCredito", {
                    numero: $scope.tc.numero,
                    banco: $scope.tc.banco
                }).then(function (response) {
                    $state.go('tarjetasDeCreditoList', {clienteUsuario: $state.params.clienteUsuario}, {reload: true});
                });
            };
        }]);

})(window.angular);




