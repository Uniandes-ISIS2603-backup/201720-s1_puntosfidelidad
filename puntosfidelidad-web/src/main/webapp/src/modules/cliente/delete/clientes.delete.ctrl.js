(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller('clienteDeleteCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) { 
            
            $scope.deleteCliente = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$state.params.clienteUsuario, {}).then(function () {
                    $state.go('clientesList', {reload: true});
                });
            };
            
            $scope.deleteCuentaCliente = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$state.params.clienteUsuario, {}).then(function () {
                    $state.go('inicio', {reload: true});
                });
            };
            
            $scope.cancelar= function() {window.history.back();};
        }
    ]);
}
)(window.angular);



