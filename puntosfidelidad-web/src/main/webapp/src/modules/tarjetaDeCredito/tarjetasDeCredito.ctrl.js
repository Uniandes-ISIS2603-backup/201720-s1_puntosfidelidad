(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller("tarjetasDeCreditoCtrl", ['$scope', '$http','$state', '$rootScope',function ($scope, $http, $state, $rootScope) {
            $scope.elementosTC = [];
            $rootScope.agregarTC=false;
            $rootScope.updateTC=false;
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$state.params.clienteUsuario+"/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosTC = response.data;
            });
        }]);

})(window.angular);




