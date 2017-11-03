(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/productos");
    mod.controller('comprasDeleteCtrl', ['$scope', '$http', 'comprasContext', '$state',
        function ($scope, $http, comprasContext, $state) {
            var idCompra = $state.params.idCompra;
            $scope.deleteCompra= function () {
                $http.delete(ProdContext + '/' + idCompra, {}).then(function (response) {
                    $state.go('comprasList', {idCompra: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);