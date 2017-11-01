(function (ng) {
    var mod = ng.module("recargasModule");
    mod.controller("recargasCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/clientes/C1/recargas")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);

})(window.angular);




