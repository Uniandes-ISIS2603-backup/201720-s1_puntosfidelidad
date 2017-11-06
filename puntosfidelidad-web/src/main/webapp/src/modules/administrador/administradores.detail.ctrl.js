(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.controller("administradoresDetailCtrl", ['$scope', '$http', '$state', 
        function ($scope, $http, $state) {    
            $http.get("/api/administradores/" + $state.params.administradorUsuario)
                    .then(function (response) {
                        $scope.elementoAdmin = response.data;
            });
        }]);

})(window.angular);
