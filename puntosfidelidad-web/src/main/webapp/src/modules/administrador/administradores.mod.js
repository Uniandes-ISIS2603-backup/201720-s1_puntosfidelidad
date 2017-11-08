(function (ng) {
    var mod = ng.module("administradoresModule", ['restauranteAdministradorModule']);
    mod.constant("administradoresContext", "api/administradores");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/administrador/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('administradoresList', {
                url: '/administradores',
                views: {
                    'mainView': {
                        controller: 'administradoresCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.list.html'
                    }
                }
            }).state('administradorDetail', {
                url: 'administradores/{administradorUsuario:string}',
                param: {
                    administradorUsuario: null
                },
                views: {
                    'mainView': {
                        controller: 'administradoresDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'administradores.detail.html'
                    }
                }
            }).state('administradorCreate', {
                url: 'administradores/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'new/administradores.new.html',
                        controller: 'administradoresNewCtrl'
                    }
                }
            }).state('administradorUpdate', {
                url: '/administradores/{administradorUsuario:string}/update',
                param: {
                    administradorUsuario: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'administradores.detail.html',
                        controller: 'administradoresUpdateCtrl'
                    }
                }
            });
            
        }]);
})(window.angular);

