(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesNewCtrl', ['$scope', '$http', 'clientesContext', '$state', '$rootScope',
        function ($scope, $http, clientesContext, $state, $rootScope) {
            var nuevoUsuario = [];

            $scope.createCliente = function () {
                if ($scope.contrasena === $scope.repetirContrasena) {
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
                        $rootScope.currentUser = nuevoUsuario.usuario;
                        $scope.hayErrorCreando = false;
                        $state.go('clienteDetail', {'clienteUsuario': nuevoUsuario.usuario}, {reload: true});
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