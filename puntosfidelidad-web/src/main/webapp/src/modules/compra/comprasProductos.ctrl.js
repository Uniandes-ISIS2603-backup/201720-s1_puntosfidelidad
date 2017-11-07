(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasProductosCtrl', ['$scope', '$http', 'comprasContext', '$state',
        function ($scope, $http, comprasContext, $state) {
            $http.get(comprasContext).then(function (response) {
                $scope.comprasRecords = response.data;
            });

            if (($state.params.compraId !== undefined) && ($state.params.compraId !== null)) {
                $http.get(comprasContext + '/' + $state.params.compraId+'/productos').then(function (response) {
                    $scope.productosRecords = response.data;
                });
            }
        }
    ]);
}
)(window.angular);




