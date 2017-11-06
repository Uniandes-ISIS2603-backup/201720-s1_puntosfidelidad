(function (ng) {
    var mod = ng.module("sucursalesModule", []);
        mod.constant("sucursalesContext", "api/sucursales");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider, $scope) {
                var basePath = 'src/modules/sucursal/';
                $urlRouterProvider.otherwise("/sucursales");
    
                $stateProvider.state('sucursalList', {
                    url: '/sucursales',
                    views: {
                        'mainView': {
                            controller: 'sucursalesCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'sucursal.list.html'
                        }
                    }
                }).state('sucursalSelect', {
                    url: '/sucursal',
                    parent: 'sucursalList',
                    views: {
                        'selectView': {
                            templateUrl: basePath + 'sucursal.detail.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);
    