(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller("tarjetasDeCreditoNewCtrl", ['$scope', '$http', '$state', '$rootScope', function ($scope, $http, $state, $rootScope) {
            $rootScope.agregarTC = true;   
            $scope.tc={
                numero:null,
                banco:null
            };
            
            $scope.usuarioActual= sessionStorage.getItem("usuario");

            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosTC = response.data;
                    });

            $scope.createTC = function () {
                $http.post("http://localhost:8080/puntosfidelidad-web/api/clientes/" + $scope.usuarioActual + "/tarjetasDeCredito", {
                    numero: $scope.tc.numero,
                    banco: $scope.tc.banco
                }).then(function () {
                    $state.go('tarjetasDeCreditoList',{reload: true});
                });
            };
        }]);

})(window.angular);




