(function (ng) {
    var mod = ng.module("comprasModule");
    mod.constant("comprasContext", "api/restaurantes");
      mod.controller('compraCreateCtrl', ['$scope', '$http', 'restaurantesContext', '$state', '$rootScope',
        function ($scope, $http, comprasContext, $state, $rootScope) {
            $rootScope.edit = false;
            
            $scope.res={
                nit:null,
                nombre:null,
                tipoComida:null
            };
            
            $scope.createCompra = function () {
                $http.post("http://localhost:8080/puntosfidelidad-web/api/compras" , {
                    id: $scope.res.id,
                    pagoConpuntos: $scope.res.pagoPuntos,
                    sucursal:{id:$scope.res.sucursalId} ,
                    tarjetaPuntos: {id:$scope.res.tarjetaId},
                    cliente: {usuario:$scope.res.usuarioId},
                }).then(function (response) {
                    //crea el restaurante
                    $state.go('restauranteAdministradorList', {resNit: response.data.nit}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);