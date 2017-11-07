(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasDeleteCtrl', ['$scope', '$http', 'comprasContext', '$state',
        function ($scope, $http, comprasContext, $state) {
            var idCompra = $state.params.compraId;
            $scope.deleteCompra= function () {
                $http.delete(comprasContext + '/' + idCompra, {}).then(function (response) {
                    $state.go('comprasList', {idCompra: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);