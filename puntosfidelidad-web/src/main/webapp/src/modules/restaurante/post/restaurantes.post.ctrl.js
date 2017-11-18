(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.constant("restaurantesContext", "api/restaurantes");
      mod.controller('restaurantesPostCtrl', ['$scope', '$http', 'restaurantesContext', '$state', '$rootScope',
        function ($scope, $http, restaurantesContext, $state, $rootScope) {
            $rootScope.edit = false;
            $scope.createRestaurante = function () {
                $http.post(restaurantesContext, {
                    nit: $scope.resNit,
                    nombre: $scope.resName,
                    tipoComida: $scope.restipo
                    
                }).then(function (response) {
                    //crea el restaurante
                    $state.go('restaurantesList', {resNit: response.data.nit}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);