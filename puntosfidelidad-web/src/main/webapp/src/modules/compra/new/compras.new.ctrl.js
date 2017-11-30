(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasNewCtrl', ['$scope', '$http', 'comprasContext', '$state', '$rootScope',
        function ($scope, $http, comprasContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createCompra = function () {
                $http.post(comprasContext, {
                    id: $scope.compraId,
                    pagoConpuntos: $scope.pagoConpuntos,
                    sucursal: {id: $scope.compraSucursal},
                    tarjetaPuntos: {id: $scope.compraTarjetaPuntos},
                    cliente: {usuario: $scope.compraUsuario}
                }).then(function (response) {
                    //compras created successfully
                    var productos = $scope.compraProductos.split("-");

                    for (i = 0; i < productos.length; i++)
                    {
                        $http.post(comprasContext + '/' +response.data.id+'/'+ productos[i]).then(function (response) {
                            $scope.currentCompra = response.data;
                        });
                    }
                    $state.go('comprasList', {compraId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);