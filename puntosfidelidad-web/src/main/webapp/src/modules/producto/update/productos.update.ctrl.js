(
        function (ng) {
            var mod = ng.module("productoModule");
            mod.constant("productosContext", "api/productos");
            mod.constant("booksContext", "api/books");
            mod.controller('productosUpdateCtrl', ['$scope', '$http', 'productosContext', '$state', 'booksContext', '$rootScope', '$filter',
                function ($scope, $http, productosContext, $state, booksContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idProducto = $state.params.productoId;

                    // Este arreglo guardara los ids de los books asociados y por asociar al autor.
                    var idsBook = [];

                    // Este arreglo mostrará los books una vez esten filtrados visualmente por lo que el autor ya tiene asociado.
                    $scope.allBooksShow = [];

                    //Consulto el autor a editar.
                    $http.get(productosContext + '/' + idProducto).then(function (response) {
                        var producto = response.data;
                        $scope.productoName = producto.nombre;
                        $scope.productoValorPuntos = producto.valorPuntos;
                        $scope.productoValorDinero = producto.valorDinero;                                   
                    });

                  


                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.dropAdd = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Cuando un book se añade al autor, se almacena su id en el array idsBook
                        idsBook.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        //Para remover el book que no se va asociar, por eso se usa el splice que quita el id del book en el array idsBook
                        var index = idsBook.indexOf(data);
                        if (index > -1) {
                            idsBook.splice(index, 1);
                        }
                    };

                    $scope.createProducto = function () {
                        /*Se llama a la función newBooks() para buscar cada uno de los ids de los books
                         en el array que tiene todos los books y así saber como queda la lista final de los books asociados al autor.
                         */
                        $scope.newBooks();
                        $http.put(productosContext + "/" + idProducto, {
                            name: $scope.productoName,
                            productoValorPuntos: $scope.productoValorPuntos,
                            productoValorDinero: $scope.productoValorDinero,
                        }).then(function (response) {
                
                            //Author created successfully
                            $state.go('productosList', {productoId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);