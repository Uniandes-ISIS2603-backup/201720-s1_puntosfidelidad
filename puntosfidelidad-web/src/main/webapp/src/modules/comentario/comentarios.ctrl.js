(function (ng) {
    var mod = ng.module("comentariosModule");
    mod.controller("comentariosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios")
                    .then(function (response) {
                        $scope.elements = response.data;
            });
        }]);
})(window.angular);