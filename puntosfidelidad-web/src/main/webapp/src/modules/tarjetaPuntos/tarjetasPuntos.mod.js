(function (ng) {
    var mod = ng.module("tarjetasPuntosModule", []);
        mod.constant("tarjetasPuntosContext", "api/tarjetasPuntos");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/tarjetaPuntos/';
                $urlRouterProvider.otherwise("");
    
                $stateProvider.state('tarjetasPuntosList', {
                    url: '/tarjetasPuntos',
                    views: {
                        'mainView': {
                            controller: 'tarjetasPuntosCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'tarjetasPuntos.list.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);
    
    