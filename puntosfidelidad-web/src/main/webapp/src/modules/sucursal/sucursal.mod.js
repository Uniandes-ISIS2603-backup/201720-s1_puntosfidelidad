(function (ng) {
var mod = ng.module("sucursalModule", []);
    mod.constant("sucursalContext", "api/sucursal");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/sucursal/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('sucursal', {
                url: '/sucursal',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'sucursal.html',
                        controller: 'sucursalCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('sucursalList', {
                url: 'sucursales/list',
                views: {
                    'mainView': {
                        controller: 'sucursalCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'sucursal.list.html'
                    }
                }
            }).state('sucursalDetail', {
                url: '/{sucursalId:int}/detail',
                parent: 'sucursal',
                param: {
                    sucursalId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'sucursal.detail.html',
                        controller: 'sucursalCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('sucursalCreate', {
                url: '/create',
                parent: 'sucursal',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/sucursal.new.html',
                        controller: 'sucursalNewCtrl'
                    }
                }
            }).state('sucursalUpdate', {
                url: '/update/{sucursalId:int}',
                parent: 'sucursal',
                param: {
                    sucursalId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/sucursal.update.html',
                        controller: 'sucursalUpdateCtrl'
                    }
                }
            }).state('sucursalDelete', {
                url: '/delete/{sucursalId:int}',
                parent: 'sucursal',
                param: {
                    sucursalId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/sucursal.delete.html',
                        controller: 'sucursalDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);