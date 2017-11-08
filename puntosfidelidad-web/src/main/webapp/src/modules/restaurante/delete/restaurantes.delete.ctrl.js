(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restaurantesDeleteCtrl', ['$scope', '$http', 'restaurantesContext', '$state',
        function ($scope, $http, restaurantesContext, $state) {
            var nitRestaurante = $state.params.restauranteNit;
            $scope.deleteRestaurantes = function () {
                $http.delete(restaurantesContext + '/' + nitRestaurante, {}).then(function (response) {
                    $state.go('restaurantesList', {restauranteNit: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);