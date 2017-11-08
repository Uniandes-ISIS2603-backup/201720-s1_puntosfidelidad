(
        function (ng) {
            var mod = ng.module("sucursalModule");
            mod.constant("sucursalContext", "api/sucursales");
            mod.controller('sucursalUpdateCtrl', ['$scope', '$http', 'sucursalContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, productosContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idsucursal = $state.params.sucursalId;
                    
                    //Consulto el autor a editar.
                    $http.get("api/sucursales" + '/' + idsucursal).then(function (response) {
                        var sucursal = response.data;
                        $scope.sucursalId = sucursal.id;
                        $scope.sucursalName = sucursal.nombre;
                        $scope.sucursalDescripcion = sucursal.descripcion;
                        $scope.sucursalApertura = sucursal.horaAperutra; 
                        $scope.sucursalCierre = sucursal.horaCierre;
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
                        $http.put("api/sucursales" + "/" + idsucursal, {
                            id: $scope.sucursalId,
                            nombre: $scope.sucursalName,
                            descrpcion: $scope.sucursalDescripcion,
                            horaApetura: $scope.sucursalApertura,
                            horaCierre: $scope.sucursalCierre                            
                        }).then(function (response) {
                
                            //Author created successfully
                            $state.go('sucursalList', {sucursalId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);