(function (ng) {
var mod = ng.module("eventosModule", []);
    mod.constant("eventosContext", "api/eventos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/evento/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('eventos', {
                url: '/eventos',
                abstract: true,                
                views: {
                    'mainView': {
                        templateUrl: basePath + 'eventos.html',
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('eventosList', {
                url: 'eventos/list',                
                parent: 'eventos',
                views: {
                     'detailView': {
                        templateUrl: basePath + 'eventosCarrusel.html',
                        controller: 'eventosCtrl'
                    },
                    'listView': {
                        controller: 'eventosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'eventos.list.html'
                    }
                }
            }).state('eventosPost', {
                url: '/create',
                parent: 'eventos',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/eventos.new.html',
                        controller: 'eventosNewCtrl'
                    }
                }
            }).state('eventosUpdate', {
                url: '/update/{eventoNombre:string}',
                parent: 'eventos',
                param: {
                    eventosId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'update/eventos.update.html',
                        controller: 'eventosUpdateCtrl'
                    }
                }
            }).state('eventosDelete', {
                url: '/delete/{eventoNombre:string}',
                parent: 'eventos',
                param: {
                    eventosId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/eventos.delete.html',
                        controller: 'eventosDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);