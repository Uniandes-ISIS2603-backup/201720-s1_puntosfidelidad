(
        function (ng) {
            var mod = ng.module("sucursalModule");
            mod.constant("sucursalContext", "api/sucursales");
            mod.controller('sucursalUpdateCtrl', ['$scope', '$http', 'sucursalContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, productosContext, $state, $rootScope, $filter) {                    

                    var idsucursal = $state.params.sucursalId;
                    
                    //Consulto el autor a editar.
                    $http.get("api/sucursales" + '/' + idsucursal).then(function (response) {
                        var sucursal = response.data;
                        $scope.sucursalId = sucursal.id;
                        $scope.sucursalName = sucursal.nombre;
                        $scope.sucursalDescripcion = sucursal.descripcion;
                        $scope.sucursalApertura = sucursal.horaApertura; 
                        $scope.sucursalCierre = sucursal.horaCierre;
                        
                       $http.get("api/ubicaciones" + '/' + sucursal.ubicacion.direccion).then(function (response) {
                        var ubicacion = response.data;
                        $scope.ubicacionDireccion = ubicacion.direccion;
                        $scope.ubicacionLatitud = ubicacion.latitud;
                        $scope.ubicacionLongitud = ubicacion.longitud;  
                        });
                    });

                    
                    //funciones para el drag and drop de HTML5 nativo
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };
                    
                    

                    $scope.updateSucursal = function () {
                        
                        $http.put("api/ubicaciones" + "/" + $scope.ubicacionDireccion, {
                            id: $scope.sucursalId,
                            nombre: $scope.sucursalName,
                            descripcion: $scope.sucursalDescripcion,
                            horaApertura: $scope.sucursalApertura,
                            horaCierre: $scope.sucursalCierre                            
                        });
                        
                        $http.put("api/sucursales" + "/" + idsucursal, {
                            id: $scope.sucursalId,
                            nombre: $scope.sucursalName,
                            descripcion: $scope.sucursalDescripcion,
                            horaApertura: $scope.sucursalApertura,
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