(function (ng) {
    var mod = ng.module("comprasModule", []);
    mod.constant("comprasContext", "api/compras");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/compra/';
            //var basePathProdutos = 'src/modules/producto/'; SEGUN SONAR ESTO NO SE USA -julián
            $urlRouterProvider.otherwise("");

            $stateProvider.state('compras', {
                url: '/compras',
                abstract: true,
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'compras.html',
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('comprasList', {
                url: '/listCompras',
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'compras.list.html'
                    }
                }
                 }).state('comprasListAdmin', {
                url: '/listComprasAdmin',
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                views: {
                    'info': {
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'compras.listAdmin.html'
                    }
                }
                
            }).state('compraDetail', {
                url: '/{compraId:int}/detail',
                parent: 'compras',
                data: {
                    requireLogin: true
                },
                param: {
                    compraId: null                    
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'compras.detail.html',
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('comprasProductosList', {
                url: '/{compraId:int}/productos',
                parent: 'compras',
                data: {
                    requireLogin: true
                },
                param: {
                    compraId: null
                },
                views: {                    
                    'navBar': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/navBar.html'

                    },
                    'detailView': {
                        templateUrl: basePath + 'compras.productos.list.html',
                        controller: 'comprasProductosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('comprasCreate', {
                url: '/create',
                parent: 'compras',
                data: {
                    requireLogin: true
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/compras.new.html',
                        controller: 'comprasNewCtrl'
                    }
                }
            }).state('compraUpdate', {
                url: '/update/{compraId:int}',
                parent: 'compras',
                data: {
                    requireLogin: true
                },
                param: {
                    compraId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/compras.new.html',
                        controller: 'comprasUpdateCtrl'
                    }
                }
            }).state('compraDelete', {
                url: '/delete/{compraId:int}',
                parent: 'compras',
                data: {
                    requireLogin: true
                },
                param: {
                    compraId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/compras.delete.html',
                        controller: 'comprasDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);

