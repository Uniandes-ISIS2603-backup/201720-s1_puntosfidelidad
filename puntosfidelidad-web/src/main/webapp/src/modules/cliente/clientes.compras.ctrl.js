(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesComprasCtrl", ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit=false;
            
            
            if (($state.params.clienteUsuario !== undefined) && ($state.params.clienteUsuario !== null)) {
               $http.get("api/clientes/" + $state.params.clienteUsuario+'/compras')
                    .then(function (response) {
                        $scope.comprasRecords = response.data;
            }); 
            }
            
        }]);

})(window.angular);