(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventoContext", "api/eventos");
    mod.controller('eventosNewCtrl', ['$scope', '$http', 'sucursalContext', '$state', '$rootScope',
        function ($scope, $http, productosContext, $state, $rootScope) {
            
            $scope.createEvento = function () {
                $http.post("api/eventos", {                    
                    nombre: $scope.eventoName,
                    descripcion: $scope.eventoDescripcion,
                    fechaInicio: $scope.eventoInicio,
                    fechaFin: $scope.eventoFin                    
                }).then(function (response) {
                    //producto created successfully
                    $state.go('eventosList', {eventoNombre: response.data.nombre}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);