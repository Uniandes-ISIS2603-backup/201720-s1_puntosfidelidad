(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventosContext", "api/eventos");
    mod.controller('eventosUpdateCtrl', ['$scope', '$http', '$state', '$rootScope', 'eventosContext',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit = true;
            $http.get("api/eventos/" + $state.params.eventoNombre)
                    .then(function (response) {
                        $scope.actual = response.data;
            });
            
            $scope.updateEvento = function () {
                $http.put("api/eventos/" + $state.params.eventoNombre, {
                    nombre: $state.params.eventNombre,
                    descripcion: $scope.actual.eventDescripcion,
                    fechaInicio: $scope.actual.eventInicio,
                    fechaFin: $scope.actual.eventFIn                            
                }).then(function (response) {                    
                    $state.go('eventosList', {eventoNombre: response.data.usuario}, {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);