(function (ng) {
    var mod = ng.module("clientesModule", ['recargasModule', 'tarjetasDeCreditoModule', 'tarjetasPuntosClienteModule']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('clientesList', {
                url: '/clientes',
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: 'clientes/{clienteUsuario:string}',
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
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.detail.html'
                    },
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'navBar.html'

                    }
                }
            }).state('clienteComprasList', {
                url: 'clientes/{clienteUsuario:string}/compras',
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
                url: 'clientes/{clienteUsuario:string}/compras/{compraId:int}/detail',
                param: {
                    clienteUsuario: null,
                    compraId: null
                    
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
                url: 'clientes/{clienteUsuario:string}/productos',
                param: {
                    clienteUsuario: null
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
                url: 'clientes/{clienteUsuario:string}/productos/{productoId:int}/detail',
                param: {
                    clienteUsuario: null,
                    productoId: null
                    
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
                url: 'clientes/create',
                views: {
                    'bannerView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: basePath + 'new/clientes.new.html',
                        controller: 'clientesNewCtrl'
                    }                   
                }
            }).state('clienteUpdate', {
                url: '/clientes/{clienteUsuario:string}/update',
                param: {
                    clienteUsuario: null
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
                url: '/clientes/{clienteUsuario:string}/delete',
                param: {
                    clienteUsuario: null
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

