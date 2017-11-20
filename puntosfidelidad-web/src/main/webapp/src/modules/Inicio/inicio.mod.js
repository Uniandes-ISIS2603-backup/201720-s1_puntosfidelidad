(function (ng) {
    var mod = ng.module("inicioModule", []);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/Inicio/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('inicio', {   
                url: '/inicio', 
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

