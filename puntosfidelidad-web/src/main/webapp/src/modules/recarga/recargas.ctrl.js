(function (ng) {
    var mod = ng.module("recargasModule");
    mod.controller("recargasCtrl", ['$scope', '$http','$state' ,function ($scope, $http, $state) {
            $scope.elementosRegarga = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+ $state.params.clienteUsuario+"/recargas")
                    .then(function (response) {
                        $scope.elementosRegarga = response.data;
            });
        }]);

})(window.angular);




