(function (ng) {
    var mod = ng.module("recargasModule");
    mod.controller("recargasCtrl", ['$scope', '$http','$state','$rootScope', '$state' ,function ($scope, $http, $rootScope, $state) {
            $rootScope.nuevaRecarga = false;
            $scope.elementosRecarga = [];
            console.log("aaaaaa");
            console.log(sessionStorage.getItem("usuario"));
            $scope.usuarioActual= sessionStorage.getItem("usuario");
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/"+$scope.usuarioActual+"/recargas")
                    .then(function (response) {
                        $scope.elementosRecarga = response.data;
            });
        }]);

})(window.angular);




