(function (ng) {
    var mod = ng.module("eventosModule");
    mod.controller("eventosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.eventos = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/eventos")
                    .then(function (response) {
                        $scope.eventos = response.data;
            });
        }]);
})(window.angular);
