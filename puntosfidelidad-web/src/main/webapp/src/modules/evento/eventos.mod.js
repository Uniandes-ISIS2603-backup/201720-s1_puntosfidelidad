(function (ng) {
    var mod = ng.module("eventosModule", []);
        mod.constant("eventosContext", "api/eventos");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/evento/';
                $urlRouterProvider.otherwise("");
    
                $stateProvider.state('eventosList', {
                    url: '/eventos',
                    views: {
                        'mainView': {
                            controller: 'eventosCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'eventos.list.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);


