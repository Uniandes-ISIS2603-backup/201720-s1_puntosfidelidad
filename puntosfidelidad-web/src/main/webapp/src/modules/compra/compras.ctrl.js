(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/compras");
    mod.controller('comprasCtrl', ['$scope', '$http', 'comprasContext', '$state',
        function ($scope, $http, comprasContext, $state) {
            $http.get(comprasContext).then(function (response) {
                $scope.comprasRecords = response.data;
            });
            
                        
            $scope.doTheBack = function() {window.history.back();};

            if (($state.params.compraId !== undefined) && ($state.params.compraId !== null)) {
                $http.get(comprasContext + '/' + $state.params.compraId).then(function (response) {
                    $scope.currentCompra = response.data;
                });
            }
        }
    ]);
}
)(window.angular);




