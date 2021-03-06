(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller('tarjetaDeCreditoDeleteCtrl', ['$scope', '$http', '$state', 
        function ($scope, $http, $state) {

            $scope.usuarioActual = sessionStorage.getItem("usuario");

            $scope.deleteTC = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/clientes/" +  $scope.usuarioActual + "/tarjetasDeCredito/"
                        + $state.params.tarjetaCreditoId, {}).then(function () {
                    $state.go('tarjetasDeCreditoList', {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);



