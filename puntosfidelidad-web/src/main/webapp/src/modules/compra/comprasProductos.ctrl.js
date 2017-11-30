(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasProductosCtrl', ['$scope', '$http', 'comprasContext', '$state',
        function ($scope, $http, comprasContext, $state) {


            if (($state.params.clienteUsuario !== undefined) && ($state.params.clienteUsuario !== null)) {
                $http.get("api/clientes/" + $state.params.clienteUsuario)
                        .then(function (response) {
                            $scope.elementoCliente = response.data;
                        });
            }
            
            if (($state.params.compraId !== undefined) && ($state.params.compraId !== null)) {
                $http.get(comprasContext + '/' + $state.params.compraId ).then(function (response) {
                    $scope.compra = response.data;
                });
            }

            if (($state.params.compraId !== undefined) && ($state.params.compraId !== null)) {
                $http.get(comprasContext + '/' + $state.params.compraId + '/productos').then(function (response) {
                    $scope.productosRecords = response.data;
                });
            }
        }
    ]);
}
)(window.angular);




