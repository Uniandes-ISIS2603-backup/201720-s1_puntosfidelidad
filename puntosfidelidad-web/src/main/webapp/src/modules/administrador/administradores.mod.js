(function (ng) {
    var mod = ng.module("administradoresModule", ['restauranteAdministradorModule']);
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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.list.html'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'
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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        controller: 'administradoresDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.detail.html'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'administradoresDetailCtrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('administradorCreate', {
                url: 'administradores/create',
                data: {
                    requireLogin: true
                },
                views: {
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: basePath + 'new/administradores.new.html',
                        controller: 'administradoresNewCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: basePath + 'administradores.detail.html',
                        controller: 'administradoresUpdateCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: basePath + 'delete/administradores.delete.html',
                        controller: 'administradorDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

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
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('administradorEventos', {
                url: '/administradores/clientes',
                data: {
                    requireLogin: true
                },
                param: {
                    clienteUsuario: null
                },
                views: {
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: 'src/modules/cliente/clientes.list.html',
                        controller: 'administradorDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            });
            
        }]);
})(window.angular);

