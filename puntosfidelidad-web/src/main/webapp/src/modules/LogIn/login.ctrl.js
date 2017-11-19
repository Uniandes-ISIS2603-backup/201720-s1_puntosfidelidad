(function (ng) {

    var mod = ng.module("loginModule");
    mod.controller("loginCtrl", ['$scope', '$http', '$state', '$rootScope', function ($scope, $http, $state, $rootScope) {

            $scope.user = {};
            $scope.data = {};
            var clienteLogin = [];

            $scope.autenticar = function () {
                if ($scope.data.rol === "cliente") {

                    $http.get("api/clientes/" + $scope.data.usuario)
                            .then(function (response) {
                                clienteLogin = response.data;

                                if (clienteLogin.contrasena === $scope.data.password) {
                                    sessionStorage.token = clienteLogin.token;
                                    sessionStorage.setItem("usuario", clienteLogin.usuario);
                                    sessionStorage.setItem("nombre", clienteLogin.nombre);
                                    sessionStorage.setItem("rol", "cliente");
                                    $rootScope.currentUser = clienteLogin.usuario;
                                    $scope.hayError = false;
                                    $state.go('clienteDetail', {'clienteUsuario': clienteLogin.usuario}, {reload: true});
                                } else {
                                    $scope.hayError = true;
                                    $scope.errortxt= "  Contraseña incorrecta";
                                }
                            }, function() {
                                 $scope.hayError = true;
                                 $scope.errortxt= " Parece que el usuario no existe";
                            });
                }

            };
        }]);
})(window.angular);
    