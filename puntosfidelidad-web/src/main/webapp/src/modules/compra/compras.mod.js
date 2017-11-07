(function (ng) {
var mod = ng.module("comprasModule", []);
    mod.constant("comprasContext", "api/compras");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/compra/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('compras', {
                url: '/compras',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'compras.html',
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('comprasList', {
                url: '/listCompras',
                views: {
                    'mainView': {
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'compras.list.html'
                    }
                }
            }).state('compraDetail', {
                url: '/{compraId:int}/detail',
                parent: 'compras',
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
            }).state('comprasCreate', {
                url: '/create',
                parent: 'compras',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/compras.new.html',
                        controller: 'comprasNewCtrl'
                    }
                }
            }).state('compraUpdate', {
                url: '/update/{compraId:int}',
                parent: 'compras',
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

