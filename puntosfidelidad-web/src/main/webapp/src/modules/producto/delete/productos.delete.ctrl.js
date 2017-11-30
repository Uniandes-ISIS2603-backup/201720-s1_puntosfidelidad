(function (ng) {
    var mod = ng.module("productoModule");
    mod.constant("productosContext", "api/productos");
    mod.controller('productosDeleteCtrl', ['$scope', '$http', 'productosContext', '$state',
        function ($scope, $http, productosContext, $state) {
            var idProducto = $state.params.productoId;
            $scope.deleteProd= function () {
                $http.delete(productosContext + '/' + idProducto, {}).then(function (response) {
                    $state.go(perfil(), {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);