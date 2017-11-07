(
        function (ng) {
            var mod = ng.module("comprasModule");
            mod.constant("comprasContext", "api/compras");
            mod.controller('comprasUpdateCtrl', ['$scope', '$http', 'comprasContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, comprasContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idCompra = $state.params.compraId;
                    
                    //Consulto el autor a editar.
                    $http.get(comprasContext + '/' + idCompra).then(function (response) {
                        var compra = response.data;
                        $scope.compraId = compra.id;
                        $scope.compraPagoConpuntos = compra.valorPuntos;
                                  
                    });

                  


                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };


                    $scope.createCompra = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $http.put(comprasContext + "/" + idCompra, {
                            id: $scope.compraId,
                            pagoConpuntos: $scope.pagoConpuntos
                        }).then(function (response) {
                
                            //Author created successfully
                            $state.go('comprasList', {compraId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);