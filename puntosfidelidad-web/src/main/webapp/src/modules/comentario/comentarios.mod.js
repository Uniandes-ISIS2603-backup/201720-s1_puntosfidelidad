(function (ng) {
    var mod = ng.module("comentariosModule", []);
        mod.constant("comentariosContext", "api/comentarios");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/comentario/';
                $urlRouterProvider.otherwise("");
    
                $stateProvider.state('comentariosList', {
                    url: '/comentarios',
                    views: {
                        'mainView': {
                            controller: 'comentariosCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'comentarios.list.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);
    
    