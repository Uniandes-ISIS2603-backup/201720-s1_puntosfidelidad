(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller("tarjetasDeCreditoCtrl", ['$scope', '$http','$state', '$rootScope',function ($scope, $http, $state, $rootScope) {
            $scope.elementosTC = [];
            $rootScope.agregarTC=false;
            $rootScope.updateTC=false;
            $scope.usuarioActual= sessionStorage.getItem("usuario");
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$scope.usuarioActual+"/tarjetasDeCredito")
                    .then(function (response) {
                        $scope.elementosTC = response.data;
            });
        }]);

})(window.angular);




