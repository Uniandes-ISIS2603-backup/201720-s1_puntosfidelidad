(function (ng) {
    var mod = ng.module("sucursalModule");
    mod.constant("sucursalContext", "api/sucursales");
    mod.controller('sucursalNewCtrl', ['$scope', '$http', 'sucursalContext', '$state', '$rootScope',
        function ($scope, $http, productosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createSucursal = function () {
                $http.post("api/sucursales", {
                    id: $scope.sucursalId,
                    nombre: $scope.sucursalName,
                    descripcion: $scope.sucursalDescripcion,
                    horaApertura: $scope.sucursalApertura,
                    horaCierre: $scope.sucursalCierre
                }).then(function (response) {
                    //producto created successfully
                    $state.go('sucursalList', {sucursalId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);