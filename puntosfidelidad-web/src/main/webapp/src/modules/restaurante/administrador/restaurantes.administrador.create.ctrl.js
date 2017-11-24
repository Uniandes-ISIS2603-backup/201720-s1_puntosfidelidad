(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.constant("restaurantesContext", "api/restaurantes");
      mod.controller('restaurantesCreateCtrl', ['$scope', '$http', 'restaurantesContext', '$state', '$rootScope',
        function ($scope, $http, restaurantesContext, $state, $rootScope) {
            $rootScope.edit = false;
            
            $scope.res={
                nit:null,
                nombre:null,
                tipoComida:null
            };
            
            $scope.createRestaurante = function () {
                $http.post("http://localhost:8080/puntosfidelidad-web/api/administradores/" + $state.params.administradorUsuario + "/restaurantes", {
                    nit: $scope.res.nit,
                    nombre: $scope.res.nombre,
                    tipoComida: $scope.res.tipoComida
                    
                }).then(function (response) {
                    //crea el restaurante
                    $state.go('restauranteAdministradorList', {resNit: response.data.nit}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);