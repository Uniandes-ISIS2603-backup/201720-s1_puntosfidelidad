(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesUpdateCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit = true;
            $http.get("api/clientes/" + $state.params.clienteUsuario)
                    .then(function (response) {
                        $scope.elementoCliente = response.data;
            });
            
            $scope.updateCliente = function () {
                $http.put("api/clientes/"+ $state.params.clienteUsuario, {
                    usuario: $state.params.clienteUsuario,
                    nombre: $scope.elementoCliente.nombre,
                    contrasena: $scope.elementoCliente.contrasena,
                    imagen: $scope.elementoCliente.imagen
                }).then(function (response) {                    
                    $state.go('clientesList', {clienteUsuario: response.data.usuario}, {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);