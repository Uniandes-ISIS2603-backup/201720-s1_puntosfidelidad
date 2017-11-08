(function (ng) {
    var mod = ng.module("sucursalModule");
    mod.constant("sucursalContext", "api/sucursales");
    mod.controller('sucursalDeleteCtrl', ['$scope', '$http', 'sucursalContext', '$state',
        function ($scope, $http, sucursalContext, $state) {
            var idSucursal = $state.params.sucursalId;
            $scope.deleteSucursal= function () {
                $http.delete("api/sucursales" + '/' + idSucursal, {}).then(function (response) {
                    $state.go('sucursalList', {sucursalId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);