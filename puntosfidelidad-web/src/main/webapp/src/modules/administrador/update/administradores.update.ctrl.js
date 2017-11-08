(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.constant("administradoresContext", "api/administradores");
    mod.controller('administradoresUpdateCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit = true;
            $http.get("api/administradores/" + $state.params.administradorUsuario)
                    .then(function (response) {
                        $scope.elementoAdministrador = response.data;
            });
            
            $scope.updateAdministrador = function () {
                $http.put("api/administradores/"+ $state.params.administradorUsuario, {
                    usuario: $state.params.administradorUsuario,
                    contrasena: $scope.elementoAdministrador.contrasena,
                }).then(function (response) {                    
                    $state.go('administradoresList', {administradorUsuario: response.data.usuario}, {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);