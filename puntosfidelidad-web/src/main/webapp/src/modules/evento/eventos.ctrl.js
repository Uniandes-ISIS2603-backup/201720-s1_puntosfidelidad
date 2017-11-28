(function (ng) {
    var mod = ng.module("eventosModule");
    mod.controller("eventosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.eventos = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/eventos")
                    .then(function (response) {
                        $scope.eventos = response.data;
                        $scope.event1 = $scope.eventos[0];
                        $scope.event2 = $scope.eventos[1];
                        $scope.event3 = $scope.eventos[2];
            });
        }]);
})(window.angular);
