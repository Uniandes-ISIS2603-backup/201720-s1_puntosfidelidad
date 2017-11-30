(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasNewCtrl', ['$scope', '$http', 'comprasContext', '$state', '$rootScope',
        function ($scope, $http, comprasContext, $state, $rootScope) {
            $rootScope.edit = false;
            var productos = null;
            $scope.createCompra = function () {
                productos = $scope.compraUsuario.compraProductos;
                $http.post(comprasContext, {
                    id: $scope.compraId,
                    pagoConpuntos: $scope.pagoConpuntos,
                    sucursal: {id: $scope.compraSucursal},
                    tarjetaPuntos: {id: $scope.compraTarjetaPuntos},
                    cliente: {usuario: $scope.compraUsuario}                   
                }).then(function (response) {
                    //compras created successfully
                    var prods = productos.split("-");

                    for (i = 0; i < prods.length; i++)
                    {
                        $http.post(comprasContext + '/' +response.data.id+'/'+ prods[i]).then(function (response) {
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