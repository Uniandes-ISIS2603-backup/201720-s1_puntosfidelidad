(function (ng) {
    var mod = ng.module("productoModule");
    mod.constant("productosContext", "api/productos");
    mod.controller('productosCtrl', ['$scope', '$http', 'productosContext', '$state',
        function ($scope, $http, productosContext, $state) {
            $http.get(productosContext).then(function (response) {
                $scope.productosRecords = response.data;
            });

            $scope.doTheBack = function () {
                window.history.back();
            };

            if (($state.params.clienteUsuario !== undefined) && ($state.params.clienteUsuario !== null)) {
                $http.get("api/clientes/" + $state.params.clienteUsuario)
                        .then(function (response) {
                            $scope.elementoCliente = response.data;
                        });
            }



            if (($state.params.productoId !== undefined) && ($state.params.productoId !== null)) {
                $http.get(productosContext + '/' + $state.params.productoId).then(function (response) {
                    $scope.currentProducto = response.data;
                });
            }


        }


    ]);

}
)(window.angular);




