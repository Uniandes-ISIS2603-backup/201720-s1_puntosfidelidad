(function (ng) {
    var mod = ng.module("comentariosNuevosModule", []);
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/evento/';
                $urlRouterProvider.otherwise("");
    
                $stateProvider.state('comentariosssNuevos', {
                    url: '/comentariosss',
                    abstract: true, 
                    data: {
                        requireLogin: true
                    },
                    views: {
                        'mainView': {
                            templateUrl: basePath + 'eventos.html',
                            controller: 'eventosCtrl',
                            controllerAs: 'ctrl'
                        }
                    }
                });
            }]);
    
    })(window.angular);