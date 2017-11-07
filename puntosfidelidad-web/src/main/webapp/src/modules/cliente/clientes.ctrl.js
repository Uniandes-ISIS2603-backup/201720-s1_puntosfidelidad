(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.clientesLista = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes")
                    .then(function (response) {
                        $scope.clientesLista = response.data;
            });           
            
        }]);

})(window.angular);