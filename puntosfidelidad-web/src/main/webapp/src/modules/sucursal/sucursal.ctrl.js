(function (ng) {
    var mod = ng.module("sucursalModule");
    mod.constant("sucursalContext", "api/sucursales");
    mod.controller('sucursalCtrl', ['$scope', '$http', 'sucursalContext', '$state',
        function ($scope, $http, sucursalContext, $state) {
            $http.get("http://localhost:8080/puntosfidelidad-web/api/sucursales").then(function (response) {
                $scope.sucursalRecords = response.data;
            });

            if (($state.params.sucursalId !== undefined) && ($state.params.sucursalId !== null)) {
                $http.get("http://localhost:8080/puntosfidelidad-web/api/sucursales/"+ $state.params.sucursalId).then(function (response) {
                    $scope.actual = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


