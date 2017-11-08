(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.constant("restaurantesContext", "api/restaurantes");
    mod.controller('restaurantesPostCtrl', ['$scope', '$http', 'restaurantesContext', '$state', 
        function ($scope, $http, restaurantesContext, $state ) {
            $scope.res={
                nit:null,
                nombre:null,
                tipoComida:null
            };
            $scope.createRestaurate = function () {                          
                $http.post(restaurantesContext, {
                    nit: $scope.res.usuario,
                    nombre: $scope.res.nombre,
                    tipoComida: $scope.res.tipoComida,
                }).then(function successCallback(response) {                    
                    $state.go('restaurantesList', {restauranteNit: response.data.nit}, {reload: true});
                }, function errorCallback(response) {
                    alert("Ups! Parece que el usuario ya existe, por favor ingresa otro usuario");
                });
            };
        }
    ]);
}
)(window.angular);