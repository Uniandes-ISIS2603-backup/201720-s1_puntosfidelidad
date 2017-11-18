(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventosContext", "api/eventos");
    mod.controller('eventosUpdateCtrl', ['$scope', '$http', '$state', '$rootScope', 'eventosContext',
        function ($scope, $http, $state, $rootScope) {  
            
            $http.get("api/eventos/" + $state.params.eventoNombre)
                    .then(function (response) {
                    
                    var evento = response.data;                      
                    $scope.eventoName = evento.nombre;
                    $scope.eventoDescripcion = evento.descripcion;
                    $scope.eventoInicio = evento.fechaInicio;
                    $scope.eventoFin = evento.fechaFin;
            });
            
                    
            $scope.updateEvento = function () {
                $http.put("api/eventos/" + $state.params.eventoNombre, {
                    nombre: $state.params.eventoNombre,
                    descripcion: $scope.eventoDescripcion,
                    fechaInicio: $scope.eventoInicio,
                    fechaFin: $scope.eventoFin                            
                }).then(function (response) {                    
                    $state.go('eventosList', {eventoNombre: response.data.usuario}, {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);