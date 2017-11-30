(function (ng) {
    var mod = ng.module("restaurantesModule");
    mod.controller('restauranteDeleteCtrl', ['$scope', '$http', '$state',
        function ($scope, $http, $state) { 
            
            
            
            $scope.deleteRestaurante = function () {
                $http.delete("http://localhost:8080/puntosfidelidad-web/api/restaurantes/"+ $state.params.restauranteNit , {}).then(function () {
                    $state.go('restaurantesList', {reload: true});
                });
                
                
                
                
            };
            
            
            $scope.updateRestaurante = function () {
                $http.put("api/restaurantes/" + $state.params.restauranteNit, {
                    nit: "Anonimo",
                    nombre: "anonimo",
                    tipoComida:"anonimo",
                 
                }).then(function (response) {                    
                    $state.go('restauranteAdministradorList', {restauranteNit: response.data.usuario}, {reload: true});
                });
            };
        }
        
     
        
        
        
        
    ]);
}
)(window.angular);
