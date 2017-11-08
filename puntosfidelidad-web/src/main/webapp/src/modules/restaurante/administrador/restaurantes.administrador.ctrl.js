(function (ng) {
    var mod = ng.module("restauranteAdministradorModule");
    mod.controller("restauranteAdministradorCtrl", ['$scope', '$http','$state' ,function ($scope, $http, $state) {
            $scope.elementosRes = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/administradores/"+$state.params.administradorUsuario+"/restaurantes")
                    .then(function (response) {
                        $scope.elementosRes = response.data;
            });
        }]);

})(window.angular);




