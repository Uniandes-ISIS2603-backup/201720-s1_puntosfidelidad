(function (ng) {
    var mod = ng.module("sucursalesModule");
    mod.controller("sucursalesCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $scope.selection = null;
            $http.get("http://localhost:8080/puntosfidelidad-web/api/sucursales")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
            
        }]);
})(window.angular);