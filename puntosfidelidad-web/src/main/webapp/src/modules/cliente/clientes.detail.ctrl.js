(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesDetailCtrl", ['$scope', '$http', '$state', 
        function ($scope, $http, $state) {    
            $http.get("/api/clientes/" + $state.params.clienteUsuario)
                    .then(function (response) {
                        $scope.elementoCliente = response.data;
            });
        }]);

})(window.angular);
