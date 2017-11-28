(function (ng) {
    var mod = ng.module("recargasModule");
    mod.controller("recargasCtrl", ['$scope', '$http','$state','$rootScope', '$state' ,function ($scope, $http, $rootScope, $state) {
            $rootScope.nuevaRecarga = false;
            $scope.elementosRecarga = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$state.params.clienteUsuario+"/recargas")
                    .then(function (response) {
                        $scope.elementosRecarga = response.data;
            });
        }]);

})(window.angular);




