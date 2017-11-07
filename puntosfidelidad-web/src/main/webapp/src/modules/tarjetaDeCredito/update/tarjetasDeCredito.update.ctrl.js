(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule");
    mod.controller('tarjetasDeCreditoUpdateCtrl', ['$scope', '$http', '$state', 
        function ($scope, $http, $state) {  
                        
            $http.get("api/clientes/" + $state.params.clienteUsuario+ "/tarjetasDeCredito/"+ $state.params.tarjetaCreditoId)
                    .then(function (response) {
                        $scope.elementoTC = response.data;
            });
            
            $scope.updateTC = function () {
                $http.put("api/clientes/" + $state.params.clienteUsuario+ "/tarjetasDeCredito/"+ $state.params.tarjetaCreditoId, {
                    usuario: $state.params.tarjetaCreditoId,
                    numero: $scope.elementoTC.numero,
                    banco: $scope.elementoTC.banco
                }).then(function () {                    
                    $state.go('tarjetasDeCreditoList', {reload: true});
                });
            };
            
         
        }]);
}
)(window.angular);