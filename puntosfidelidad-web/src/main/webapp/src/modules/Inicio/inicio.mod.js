(function (ng) {
    var mod = ng.module("inicioModule", []);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/Inicio/';

            $stateProvider.state('inicio', {   
                url: '/inicio',
                data: {
                    requireLogin: false
                },                 
                views: {
                    'mainView': {
                        controller: 'inicioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'inicio.html'
                    }
                }
            });
            
        }]);
})(window.angular);

