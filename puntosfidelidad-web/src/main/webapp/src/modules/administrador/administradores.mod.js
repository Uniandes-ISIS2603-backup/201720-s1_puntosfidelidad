(function (ng) {
    var mod = ng.module("administradoresModule", ['restauranteAdministradorModule','comprasModule' ]);
    mod.constant("administradoresContext", "api/administradores");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/administrador/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('administradoresList', {
                url: '/administradores',
                data: {
                    requireLogin: true
                },
                views: {                   
                    'mainView': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.list.html'
                    }
                }
            }).state('administradorDetail', {
                url: 'administradores/{administradorUsuario:string}',
                param: {
                    administradorUsuario: null
                },
                data: {
                    requireLogin: true
                },
                views: {                    
                    'mainView': {
                        controller: 'administradoresDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.detail.html'
                    }
                }
                }).state('administradoresBuscar', {
                url: '/buscar',
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.buscar.list.html'
                    }
                }
                
            }).state('administradorCreate', {
                url: 'administradores/create',
                data: {
                    requireLogin: true
                },
                views: {                    
                    'mainView': {
                        templateUrl: basePath + 'new/administradores.new.html',
                        controller: 'administradoresNewCtrl'
                    }
                }
            }).state('administradorUpdate', {
                url: '/administradores/{administradorUsuario:string}/update',
                data: {
                    requireLogin: true
                },
                param: {
                    administradorUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: basePath + 'administradores.detail.html',
                        controller: 'administradoresUpdateCtrl'
                    }
                }

            }).state('administradorDelete', {
                url: '/administradores/{administradorUsuario:string}/delete',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: basePath + 'delete/administradores.delete.html',
                        controller: 'administradorDeleteCtrl'
                    }
                }
            }).state('administradorClientes', {
                url: '/administradores/clientes',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {                   
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    }
                }
            }).state('administradorOtros', {
                url: '/administradores/clientes',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    }
                }
            }).state('administradorRestaurantes', {
                url: '/administradores/clientes',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    },
                }
            }).state('administradorEventos', {
                url: '/administradores/eventos',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: 'src/modules/evento/eventos.html',
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: 'src/modules/evento/eventosCarrusel.html',
                        controller: 'eventosCtrl'
                    },
                    'listView': {
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/evento/eventos.list.html'
                    }
                }
            });

        }]);
})(window.angular);

