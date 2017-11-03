(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasNewCtrl', ['$scope', '$http', 'comprasContext', '$state', '$rootScope',
        function ($scope, $http, comprasContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createCompra = function () {
                $http.post(comprasContext, {
                    id: $scope.compraId,
                    pagoConpuntos: $scope.pagoConpuntos
                }).then(function (response) {
                    //compras created successfully
                    $state.go('comprasList', {compraId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);