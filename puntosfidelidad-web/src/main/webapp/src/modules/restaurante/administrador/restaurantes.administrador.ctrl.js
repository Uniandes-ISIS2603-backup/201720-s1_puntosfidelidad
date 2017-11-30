(function (ng) {
    var mod = ng.module("restauranteAdministradorModule");
    mod.controller("restauranteAdministradorCtrl", ['$scope', '$http','$state' ,function ($scope, $http, $state) {
            $scope.elementosRes = [];
            $scope.actual = $state.params.restauranteNit;
            $http.get("http://localhost:8080/puntosfidelidad-web/api/administradores/"+$state.params.administradorUsuario+"/restaurantes")
                    .then(function (response) {
                        $scope.elementosRes = response.data;
                
                 });
                
                 $scope.postRestaurante = function(TP)
            {
                restaurante = {};
                restaurante.nit = TP.nit;
                restaurante.nombre = TP.nombre;
                restaurante.tipoComida = TP.tipoComida;
                
                cliente = null;

                $http.get('http://localhost:8080/puntosfidelidad-web/api/clientes/' + TP.usuarioCliente).then(
                    function(response)
                    {
                        resp = response.data;
                        cliente = {};
                        cliente.usuario = resp.usuario;

                        restaurante.cliente = cliente;
                        $scope.elements = $scope.elements.concat(restaurante);
                        $scope.crear = false;
                        $http.post('http://localhost:8080/puntosfidelidad-web/api/clientes/' + TP.usuarioCliente + '/tarjetasPuntos/' + restaurante.id).then(
                            function(response)
                            {
                                alert('Tarjeta puntos creada exitosamente!');
                            },
                            function(error)
                            {
                                //console.log(error); comentado para reducir deuda técnica
                                //alert('Error creando la tarjeta de puntos: ' + error.message);
                            }
                        )
                    },
                    function(error)
                    {
                        alert("El cliente no existe!");
                    }
                );                
            }
                
                
           
        }]);

})(window.angular);




