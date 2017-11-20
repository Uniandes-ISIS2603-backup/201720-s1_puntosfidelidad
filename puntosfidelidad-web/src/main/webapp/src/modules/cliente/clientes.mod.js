(function (ng) {
    var mod = ng.module("clientesModule", ['recargasModule', 'tarjetasDeCreditoModule','tarjetasPuntosClienteModule']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cliente/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('clientesList', {
                url: '/clientes',
                views: {
                    'mainView': {
                        controller: 'clientesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.list.html'
                    }
                }
            }).state('clienteDetail', {
                url: 'clientes/{clienteUsuario:string}',
                param: {
                    clienteUsuario: null
                },
                views: {
                    'bannerView':{
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl:  'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.detail.html'
                    }
                }
            }).state('clienteCreate', {
                url: 'clientes/create',
                views: {
                    'bannerView':{
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/LogIn/bannerLogin.html'
                    },
                    'mainView': {
                        templateUrl: basePath + 'new/clientes.new.html',
                        controller: 'clientesNewCtrl'
                    }
                }
            }).state('clienteUpdate', {
                url: '/clientes/{clienteUsuario:string}/update',
                param: {
                    clienteUsuario: null
                },
                views: {                   
                    'mainView': {
                        templateUrl: basePath + 'clientes.detail.html',
                        controller: 'clientesUpdateCtrl'
                    }
                }
            }).state('clienteDelete', {
                url: '/clientes/{clienteUsuario:string}/delete',
                param: {
                    clienteUsuario: null
                },
                views: {                    
                    'mainView': {
                        templateUrl: basePath + 'delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                }
            });
            
        }]);
})(window.angular);

