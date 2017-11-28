(function (ng) {
var mod = ng.module("restauranteAdministradorModule", []);
    mod.constant("restauranteAdministradorContext", "api/restaurantes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/restaurante/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('restauranteAdministradorList', {
                url: '/restaurantes',
                parent: 'administradorDetail',
               
                views: {                    
                    'info': {
                       controller: 'restauranteAdministradorCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'/administrador/restaurantes.administrador.list.html' 
                                              
                    }
                }
                
                }).state('restauranteAdministradorPost', {
                url: '/crear',
                parent: 'administradorDetail',
                param:{
                    administradorUsuario:null
                },
                views: {
                    'info': {
                       controller: 'restaurantesPostCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'postrestaurantes.post.html' 
                                              
                    }
                }
                
                }).state('restauranteAdministradorUpdate', {
                url: '/restaurante/crear',
                parent: 'administradorDetail',
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
                url: '/restaurante/borrar',
                parent: 'administradorDetail',
                param: {
                    restauranteNit: null
                },
                views: {
                    'info': {
                        controller: 'restaurantesDeleteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'delete/restaurantes.delete.html'
                    }
                }
            }).state('restauranteAdministradorDetail', {
                url: '/restaurante/detalle',
                parent: 'administradorDetail',
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
            });
        }]);

})(window.angular);

