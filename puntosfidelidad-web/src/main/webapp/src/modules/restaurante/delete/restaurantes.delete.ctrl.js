(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.controller('restauranteDeleteCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) { 
            
            $scope.deleteRestaurante = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/restaurantes/"+ $state.params.restauranteNit , {}).then(function () {
                    $state.go('restaurantesList', {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
