(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restaurantesUpdateCtrl', ['$scope', '$http', '$state', '$rootScope', 'restaurantesContext',
        function ($scope, $http, $state, $rootScope) {  
            $rootScope.edit = true;
            $http.get("api/restaurantes/" + $state.params.restauranteNit)
                    .then(function (response) {
                        $scope.actual = response.data;
            });
            
            $scope.updateRestaurante = function () {
                $http.put("api/restaurantes/" + $state.params.clienteUsuario, {
                    nit: $state.params.restauranteNit,
                    nombre: $scope.actual.nombre,
                    tipoComida: $scope.actual.contrasena,
                    imagen: $scope.actual.imagen
                }).then(function (response) {                    
                    $state.go('restaurantesList', {restauranteNit: response.data.usuario}, {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);