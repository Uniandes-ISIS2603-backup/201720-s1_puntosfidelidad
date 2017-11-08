(function (ng) {
    var mod = ng.module("tarjetasPuntosModule");
    mod.controller("tarjetasPuntosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/tarjetasPuntos")
                    .then(function (response) {
                        $scope.elements = response.data;
            });

            $scope.postTarjetaPuntos = function(TP)
            {
                tarjetaPuntos = {};
                tarjetaPuntos.id = TP.id;
                tarjetaPuntos.montoBasico = TP.montoBasico;
                tarjetaPuntos.montoActual = TP.montoActual;
                
                cliente = null;

                $http.get('http://localhost:8080/puntosfidelidad-web/api/clientes/' + TP.usuarioCliente).then(
                    function(response)
                    {
                        resp = response.data;
                        cliente = {};
                        cliente.usuario = resp.usuario;

                        tarjetaPuntos.cliente = cliente;
                        $scope.elements = $scope.elements.concat(tarjetaPuntos);
                        $scope.crear = false;
                        $http.post('http://localhost:8080/puntosfidelidad-web/api/clientes/' + TP.usuarioCliente + '/tarjetasPuntos/' + tarjetaPuntos.id).then(
                            function(response)
                            {
                                alert('Tarjeta puntos creada exitosamente!');
                            },
                            function(error)
                            {
                                console.log(error);
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

            $scope.revisarTP = function(tarjetaPts)
            {
                if(tarjetaPts.montoBasico == undefined || tarjetaPts.montoActual == undefined)      
                {
                    return false;
                }          

                if(tarjetaPts.montoBasico > tarjetaPts.montoActual)
                {
                    $scope.mensaje = 'El monto básico debe ser inferior al monto actual';
                    return false;
                }
                return true;
            }

            $scope.putTarjetaPuntos = function(tarjetas, tarjeta)
            {
                usuario = tarjeta.cliente.usuario;
                tarjetasCliente = [];
                
                for(tp in tarjetas)
                {
                    if(tarjetas[tp].cliente.usuario == usuario)
                    {
                        tarjetasCliente.push(tarjetas[tp]);
                    }
                }

                $http.put('http://localhost:8080/puntosfidelidad-web/api/clientes/' + usuario + '/tarjetasPuntos', tarjetasCliente).then(
                    function todoBien(response) 
                    {
                        alert('Tarjeta puntos actualizada exitosamente!')
                        console.log("todo bien!");
                    },
                    function todoMal(error)
                    {
                        console.log(error);
                    }
                );
            }

            $scope.deleteTarjetaPuntos = function(tarjetaPts)
            {
                quiereBorrar = confirm("¿Quiere borrar la tarjeta puntos?");
                
                if(quiereBorrar)
                {
                    usuario = tarjetaPts.cliente.usuario;
                    idTarjeta = tarjetaPts.id;

                    $http.delete('http://localhost:8080/puntosfidelidad-web/api/clientes/' + usuario + '/tarjetasPuntos/' + idTarjeta).then(
                        function todoBien(response)
                        {
                            index = $scope.elements.indexOf(tarjetaPts);
                            if(index > -1)
                            {
                                $scope.elements.splice(index, 1);
                                console.log("todo bien!");
                            }
                            else
                            {
                                console.log("Error con el index!")
                            }
                        },
                        function todoMal(error)
                        {
                            console.log(error);
                        }
                    );
                }
            }
        }]);
})(window.angular);