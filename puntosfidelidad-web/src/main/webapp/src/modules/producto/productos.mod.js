(function (ng) {
var mod = ng.module("productoModule", []);
    mod.constant("productosContext", "api/productos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/producto/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('productos', {
                url: '/productos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'productos.html',
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('productosList', {
                url: '/list',
                views: {
                    'mainView': {
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'productos.list.html'
                    }
                }
            }).state('productoDetail', {
                url: '/{productoId:int}/detail',
                parent: 'productos',
                param: {
                    productoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'productos.detail.html',
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('productosCreate', {
                url: '/create',
                parent: 'productos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/productos.new.html',
                        controller: 'productosNewCtrl'
                    }
                }
            }).state('productoUpdate', {
                url: '/update/{productoId:int}',
                parent: 'productos',
                param: {
                    productoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/productos.new.html',
                        controller: 'productosUpdateCtrl'
                    }
                }
            }).state('productoDelete', {
                url: '/delete/{productoId:int}',
                parent: 'productos',
                param: {
                    productoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/producto.delete.html',
                        controller: 'productosDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);

