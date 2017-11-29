(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesComprasCtrl", ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {
            $rootScope.edit = false;


            if (($state.params.clienteUsuario !== undefined) && ($state.params.clienteUsuario !== null)) {
                $http.get("api/clientes/" + $state.params.clienteUsuario + '/compras')
                        .then(function (response) {
                            $scope.comprasRecords = response.data;
                        });               
                        
                        $http.get("api/clientes/" + $state.params.clienteUsuario)
                        .then(function (response) {
                            $scope.elementoCliente = response.data;
                        });
            }
            
            

            if (($state.params.compraId !== undefined) && ($state.params.compraId !== null)) {
                $http.get("api/compras" + '/' + $state.params.compraId).then(function (response) {
                    $scope.currentCompra = response.data;
                });
                
                
            }



        }]);

})(window.angular);