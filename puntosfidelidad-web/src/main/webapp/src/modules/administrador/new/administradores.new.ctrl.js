(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.constant("administradoresContext", "api/administradores");
    mod.controller('administradoresNewCtrl', ['$scope', '$http', 'administradoresContext', '$state', 
        function ($scope, $http, administradoresContext, $state ) {
            $scope.createAdministrador = function () {
                                
                $http.post(administradoresContext, {
                    usuario: $scope.usuario,
                    contrasena: $scope.contrasena,
                }).then(function successCallback(response) {                    
                    $state.go('administradoresList', {administradorUsuario: response.data.usuario}, {reload: true});
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