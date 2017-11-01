(function (ng) {
    var mod = ng.module("clientesModule");
    mod.controller("clientesCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes")
                    .then(function (response) {
                        $scope.elements = response.data;
            });           
            
        }]);

})(window.angular);