(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventoContext", "api/eventos");
    mod.controller('eventosNewCtrl', ['$scope', '$http', 'sucursalContext', '$state', '$rootScope',
        function ($scope, $http, productosContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createEvento = function () {
                $http.post("api/eventos", {                    
                    nombre: $scope.eventoName,
                    descripcion: $scope.eventoDescripcion,
                    fechaInicio: $scope.eventoInicio,
                    fechaFin: $scope.eventoFIn
                }).then(function (response) {
                    //producto created successfully
                    $state.go('eventoList', {eventoNombre: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);