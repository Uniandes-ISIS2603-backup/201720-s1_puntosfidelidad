(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.controller('administradorDeleteCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) { 
            
            $scope.deleteAdministrador = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/administradores/"+$state.params.administradorUsuario, {}).then(function () {
                    $state.go('administradoresList', {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);



