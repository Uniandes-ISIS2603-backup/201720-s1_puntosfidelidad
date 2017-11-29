(function (ng) {
    var mod = ng.module("clientesModule", ['recargasModule', 'tarjetasDeCreditoModule', 'tarjetasPuntosClienteModule']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("/login");
            
            $stateProvider.state('clientesList', {
                url: '/clientes',
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: '/clienteDetail/{clienteUsuario:string}',
                param: {
                    clienteUsuario: null
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
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.detail.html'
                    },
                    'navBar': {                        
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('clienteComprasList', {
                url: '/{clienteUsuario:string}/compras',
                param: {
                    clienteUsuario: null
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
                        controller: 'clientesComprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'subrecursoCompra/compras.list.html'
                    },
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('clienteComprasDetail', {
                url: '/{clienteUsuario:string}/compras/{compraId:int}/detail',
                param: {
                    clienteUsuario: null,
                    compraId: null

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
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/navBar.html'

                    },
                    'mainView': {
                        controller: 'clientesComprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'subrecursoCompra/compras.detail.html'

                    }
                }
            }).state('clienteProductosList', {
                url: '/{clienteUsuario:string}/productos',
                param: {
                    clienteUsuario: null
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
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/navBar.html'

                    },
                    'mainView': {
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'subrecursoProducto/productos.list.html'
                    }
                }
            }).state('clienteProductosDetail', {
                url: '/{clienteUsuario:string}/productos/{productoId:int}/detail',
                param: {
                    clienteUsuario: null,
                    productoId: null
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
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/navBar.html'

                    },
                    'mainView': {
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'subrecursoProducto/productos.detail.html'

                    }
                }
            }).state('clienteCreate', {
                url: '/nuevo',  
                data: {
                    requireLogin: false
                },
                views: {
                    'bannerView': {                       
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        controller: 'clientesNewCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'new/clientes.new.html'
                    }
                }
            }).state('clienteUpdate', {
                url: '{clienteUsuario:string}/update',
                param: {
                    clienteUsuario: null
                },
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clientesUpdateCtrl'
                    },
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('clienteDelete', {
                url: '{clienteUsuario:string}/delete',
                param: {
                    clienteUsuario: null
                },
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    },
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            });
        }]);
})(window.angular);

