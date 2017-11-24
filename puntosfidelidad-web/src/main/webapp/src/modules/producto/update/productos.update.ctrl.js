(
        function (ng) {
            var mod = ng.module("productoModule");
            mod.constant("productosContext", "api/productos");
            mod.controller('productosUpdateCtrl', ['$scope', '$http', 'productosContext', '$state', '$rootScope',
                function ($scope, $http, productosContext, $state, $rootScope) {
                    $rootScope.edit = true;

                    var idProducto = $state.params.productoId;
                    
                    //Consulto el autor a editar.
                    $http.get(productosContext + '/' + idProducto).then(function (response) {
                        var producto = response.data;
                        $scope.productoId = producto.id;
                        $scope.productoName = producto.nombre;
                        $scope.productoValorPuntos = producto.valorPuntos;
                        $scope.productoValorDinero = producto.valorDinero; 
                        $scope.restauranteNit = producto.restaurante.nit;
                    });

                  


                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };


                    $scope.createProducto = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $http.put(productosContext + "/" + idProducto, {
                            id: $scope.productoId,
                            nombre: $scope.productoName,
                            valorPuntos: $scope.productoValorPuntos,
                            valorDinero: $scope.productoValorDinero,
                            restaurante: {nit: $scope.restauranteNit}
                        }).then(function (response) {
                
                            //Author created successfully
                            $state.go('productosList', {productoId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);