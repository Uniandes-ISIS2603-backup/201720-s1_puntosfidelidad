(function (ng) {
    var mod = ng.module("restauranteAdministradorModule", []);
    mod.constant("restauranteAdministradorContext", "api/restaurantes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/restaurante/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('restauranteAdministradorList', {
                url: '/restaurantes',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                views: {
                    'info': {
                        controller: 'restauranteAdministradorCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administrador/restaurantes.administrador.list.html'
                    }
                }
            }).state('restauranteAdministradorPost', {
                url: '/crear',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                param: {
                    administradorUsuario: null
                },
                views: {
                    'info': {
                        controller: 'restaurantesCreateCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administrador/restaurantes.administrador.listPost.html'

                    }
                }

            }).state('restauranteAdministradorUpdate', {
                url: '/restaurante/editar/{restauranteNit:string}',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                param: {
                    restauranteNit: null
                },
                views: {
                    'info': {
                        controller: 'restaurantesUpdateCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'update/restaurantes.update.html'
                    }
                }
            }).state('restauranteAdministradorDelete', {
                url: '/restaurante/borrar/{restauranteNit:string}',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                param: {
                    restauranteNit: null
                },
                views: {
                    'info': {
                        controller: 'restauranteDeleteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'delete/restaurantes.delete.html'
                    }
                }
            }).state('restauranteAdministradorDetail'            , {
                url: '/restaurante/{restauranteNit:string}/detalle',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true                    
                },
                param: {
                    restauranteNit: null
                },
                views: {
                    'info': {
                        controller: 'restaurantesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'restaurantes.detail.html'
                    }
                }
            }).state('restauranteAdministradorSucursal', {
                url: '/sucursal',
                parent: 'restauranteAdministradorDetail',
                data: {
                    requireLogin: true
                },
                param: {
                    restauranteNit2: null
                },
                views: {
                    'infoRes': {
                        controller: 'restaurantesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'restaurantes.sucursales.html'
                    }
                }
            }).state('restauranteAdministradorProducto', {
                url: '/producto',
                parent: 'restauranteAdministradorDetail',
                data: {
                    requireLogin: true
                },
                param: {
                    restauranteNit: null
                },
                views: {
                    'infoRes': {
                        controller: 'restaurantesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'restaurantes.productos.html'
                    }
                }
            });
        }]);

})(window.angular);

