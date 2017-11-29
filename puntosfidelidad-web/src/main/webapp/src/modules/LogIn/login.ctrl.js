(function (ng) {

    var mod = ng.module("loginModule");
    mod.controller("loginCtrl", ['$scope', '$http', '$state', '$rootScope', function ($scope, $http, $state, $rootScope) {

            $scope.user = {};
            $scope.data = {};
            var usuarioLogin = [];

            $scope.autenticar = function () {
                if ($scope.data.rol === "cliente") {

                    $http.get("api/clientes/" + $scope.data.usuario)
                            .then(function (response) {
                                usuarioLogin = response.data;

                                if (usuarioLogin.contrasena === $scope.data.password) {
                                    sessionStorage.token = usuarioLogin.token;
                                    sessionStorage.setItem("usuario", usuarioLogin.usuario);
                                    sessionStorage.setItem("nombre", usuarioLogin.nombre);
                                    sessionStorage.setItem("rol", "cliente");
                                    $rootScope.currentUser = usuarioLogin.usuario;
                                    $scope.hayError = false;
                                    console.log(usuarioLogin.usuario)
                                    $state.go('clienteDetail', {'clienteUsuario':usuarioLogin.usuario}, {reload: true});
                                } else {
                                    $scope.hayError = true;
                                    $scope.errortxt= "  Contraseña incorrecta";
                                }
                            }, function() {
                                 $scope.hayError = true;
                                 $scope.errortxt= " Parece que el cliente no existe";
                            });
                }
                
                if ($scope.data.rol === "administrador") {

                    $http.get("api/administradores/" + $scope.data.usuario)
                            .then(function (response) {
                                usuarioLogin = response.data;

                                if (usuarioLogin.contrasena === $scope.data.password) {
                                    sessionStorage.token = usuarioLogin.token;
                                    sessionStorage.setItem("usuario", usuarioLogin.usuario);
                                    sessionStorage.setItem("nombre", usuarioLogin.nombre);
                                    sessionStorage.setItem("rol", "administrador");
                                    $rootScope.currentUser = usuarioLogin.usuario;
                                    $scope.hayError = false;
                                    $state.go('administradorDetail', {'administradorUsuario': usuarioLogin.usuario}, {reload: true});
                                } else {
                                    $scope.hayError = true;
                                    $scope.errortxt= "  Contraseña incorrecta";
                                }
                            }, function() {
                                 $scope.hayError = true;
                                 $scope.errortxt= " Parece que el administrador no existe";
                            });
                }
                
                $scope.doTheBack = function() {window.history.back();};

            };
        }]);
})(window.angular);
    