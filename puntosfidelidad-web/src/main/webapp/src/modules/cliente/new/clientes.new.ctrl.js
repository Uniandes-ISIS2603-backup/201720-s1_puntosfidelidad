(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesNewCtrl', ['$scope', '$http', 'clientesContext', '$state', 
        function ($scope, $http, clientesContext, $state ) {
            $scope.createCliente = function () {
                                
                $http.post(clientesContext, {
                    usuario: $scope.usuario,
                    nombre: $scope.vacio($scope.nombre),
                    contrasena: $scope.contrasena,
                    imagen: $scope.vacio($scope.imagen)
                }).then(function successCallback(response) {                    
                    $state.go('clientesList', {clienteUsuario: response.data.usuario}, {reload: true});
                }, function errorCallback(response) {
                    alert("Ups! Parece que el usuario ya existe, por favor ingresa otro usuario");
                });
            };

            $scope.vacio = function (valor) {
                if (angular.isDefined(valor)) {
                    return valor;
                } else {
                    return "";
                }
            };
        }
    ]);
}
)(window.angular);