(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.controller("administradoresDetailCtrl", ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit=false;
            
            $http.get("api/administradores/" + $state.params.administradorUsuario)
                    .then(function (response) {
                        $scope.elementoAdministrador = response.data;
            });
        }]);

})(window.angular);
