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
            
            $scope.usuarioActual= sessionStorage.getItem("usuario");

            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/recargas")
                    .then(function (response) {
                        $scope.elementosRecarga = response.data;
                    });
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosRtarjetaC = response.data;
                    });
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elementosRtarjetaP = response.data;
                    });

            $scope.createRecarga = function () {
                $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/tarjetasDeCredito/" + $scope.recargaNueva.tarjetaDeCredito)
                        .then(function (response) {
                            $scope.tcred = response.data;
                            $http.get("http://localhost:8080/puntosfidelidad-web/api/tarjetasPuntos/" + $scope.recargaNueva.tarjetaPuntos)
                                    .then(function (response) {
                                        $scope.tpun = response.data;
                                        
                                        $http.post("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/recargas", {
                                            valor: $scope.recargaNueva.valor,
                                            fecha: (new Date()),
                                            tarjetaDeCredito: $scope.tcred,
                                            tarjetaPuntos: $scope.tpun
                                        }).then(function () {
                                            $state.go('recargasList',{reload: true});
                                        });
                                        
                                        $rootScope.nuevaRecarga = false;
                                    });
                        });
            };

        }]);

})(window.angular);




