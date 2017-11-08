(function (ng) {
var mod = ng.module("restauranteAdministradorModule", []);
    mod.constant("restauranteAdministradorContext", "api/restaurantes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/restaurante/administrador/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('restauranteAdministradorList', {
                url: 'administradores/{administradorUsuario:string}/restaurantes',
                parent: 'administradorDetail',
                param:{
                    administradorUsuario:null
                },
                views: {
                    'mainView': {
                        controller: 'administradoresDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/administrador/administradores.detail.html'                        
                    },
                    'detailAdministradorView': {
                       controller: 'restauranteAdministradorCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'restaurantes.administrador.list.html' 
                    }
                }
            });
        }]);

})(window.angular);

