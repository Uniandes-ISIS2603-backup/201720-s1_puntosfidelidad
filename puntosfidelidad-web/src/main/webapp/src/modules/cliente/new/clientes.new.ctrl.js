(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesNewCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, $state, $rootScope) {
            var nuevoUsuario = [];

            $scope.createCliente = function () {
                if ($scope.contrasena === $scope.repetirContrasena && angular.isDefined($scope.usuario) && angular.isDefined($scope.contrasena)) {
                    $http.post(clientesContext, {
                        usuario: $scope.usuario,
                        nombre: $scope.vacio($scope.nombre),
                        contrasena: $scope.contrasena,
                        imagen: $scope.vacio($scope.imagen)
                    }).then(function (response) {
                        nuevoUsuario = response.data;

                        sessionStorage.token = nuevoUsuario.token;
                        sessionStorage.setItem("usuario", nuevoUsuario.usuario);
                        sessionStorage.setItem("nombre", nuevoUsuario.nombre);
                        sessionStorage.setItem("rol", "cliente");
                        console.log(nuevoUsuario.usuario);
                        console.log($rootScope.currentUser);
                        $rootScope.currentUser = nuevoUsuario.usuario;
                        console.log($rootScope.currentUser);
                        console.log($rootScope);
                        
                        $scope.hayErrorCreando = false;
                        $state.go('clienteDetail', {'clienteUsuario':$rootScope.currentUser}, {reload: true});
                    }, function () {
                        $scope.hayErrorCreando = true;
                        $scope.errortxt = " Parece que el cliente con ese usuario ya existe";
                    });
                }                
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