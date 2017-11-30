(function (ng) {
    var mod = ng.module("tarjetasPuntosModule", []);
    mod.constant("tarjetasPuntosContext", "api/tarjetasPuntos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaPuntos/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasPuntosList', {
                url: '/tarjetasPuntos',
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        controller: 'tarjetasPuntosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasPuntos.list.html'
                    }
                }
                
                }).state('tarjetasPuntosListAdmin', {
                url: '/tarjetasPuntoslist',                
                parent: 'administradorDetail',
                data: {
                    requireLogin: true
                },
                views: {
                     'info': {
                        templateUrl: basePath + 'tarjetasPuntos.listAdmin.html',
                        controller: 'tarjetasPuntosCtrl'
                    },
                    'listView': {
                        controller: 'tarjetasPuntosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasPuntos.listAdmin.html'
                    }
                }
            });
        }]);

})(window.angular);

    