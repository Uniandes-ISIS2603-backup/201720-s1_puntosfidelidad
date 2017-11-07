(function (ng) {
var mod = ng.module("administradoresModule", []);
    mod.constant("administradoresContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/administrador/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('administradorList', {
                url: '/administradores',
                views: {
                    'mainView': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.list.html'
                    }
                }
            }).state('administradorDetail', {
                url: '/{administradorUsuario:string}',
                parent: 'administradorList',
                param: {
                    administradorUsuario: null
                },
                views: {
                    'detailView': {
                        controller: 'administradoresDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + '/administradores.detail.html'                       
                    }
                }
            });
            
        }]);
})(window.angular);

