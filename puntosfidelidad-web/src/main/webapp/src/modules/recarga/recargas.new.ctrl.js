(function (ng) {
    var mod = ng.module("recargasModule");
    mod.controller("recargasNewCtrl", ['$scope', '$http', '$state', '$rootScope', function ($scope, $http, $state, $rootScope) {
            $rootScope.nuevaRecarga = true;
            $scope.elementosRtarjetaC = [];
            $scope.elementosRtarjetaP = [];
            $scope.tpr = {};
            $scope.tcr = {};
            $scope.recargaNueva = {
                valor: null,
                fecha: null,
                tarjetaDeCredito: null,
                tarjetaPuntos: null
            };
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/recargas")
                    .then(function (response) {
                        $scope.elementosRecarga = response.data;
                    });
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosRtarjetaC = response.data;
                    });
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elementosRtarjetaP = response.data;
                    });

            $scope.createRecarga = function () {
                $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/tarjetasDeCredito/" + $scope.recargaNueva.tarjetaDeCredito)
                        .then(function (response) {
                            $scope.tcred = response.data;
                            $http.get("http://localhost:8080/puntosfidelidad-web/api/tarjetasPuntos/" + $scope.recargaNueva.tarjetaPuntos)
                                    .then(function (response) {
                                        $scope.tpun = response.data;
                                        console.log($scope.tpun);
                                        console.log($scope.tcred);
                                        $http.post("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $state.params.clienteUsuario + "/recargas", {
                                            valor: $scope.recargaNueva.valor,
                                            fecha: (new Date()),
                                            tarjetaDeCredito: $scope.tcred,
                                            tarjetaPuntos: $scope.tpun
                                        }).then(function () {
                                            $state.go('recargasList',{reload: true});
                                        });
                                    });
                        });
            };

        }]);

})(window.angular);




