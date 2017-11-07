(function (ng) {
    var mod = ng.module("productoModule");
    mod.constant("productosContext", "api/productos");
    mod.controller('productosNewCtrl', ['$scope', '$http', 'productosContext', '$state', '$rootScope',
        function ($scope, $http, productosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createProducto = function () {
                $http.post(productosContext, {
                    id: $scope.productoId,
                    nombre: $scope.productoName,
                    valorPuntos: $scope.productoValorPuntos,
                    valorDinero: $scope.productoValorDinero,
                    restaurante: {nit: $scope.restauranteNit}
                }).then(function (response) {
                    //producto created successfully
                    $state.go('productosList', {productoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);