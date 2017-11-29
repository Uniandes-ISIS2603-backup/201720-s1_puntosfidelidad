(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesDetailCtrl", ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http,$state, $rootScope) {  
            $rootScope.edit=false;
            $rootScope.nuevaRecarga = false;
            $http.get("api/clientes/" + $state.params.clienteUsuario)
                    .then(function (response) {
                        $scope.elementoCliente = response.data;
            });
            
      
            $rootScope.doTheBack = function() {window.history.back();};

        }]);

})(window.angular);
