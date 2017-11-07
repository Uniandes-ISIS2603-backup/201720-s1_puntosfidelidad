(function (ng) {
var mod = ng.module("tarjetasPuntosClienteModule", []);
    mod.constant("tarjetasPuntosClienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaPuntos/cliente/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasPuntosClienteList', {
                url: 'clientes/{clienteUsuario:string}/tarjetasPuntos',
                parent: 'clienteDetail',
                param:{
                    clienteUsuario:null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'                        
                    },
                    'detailClienteView': {
                       controller: 'tarjetasPuntosClienteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'tarjetasPuntos.cliente.list.html' 
                    }
                }
            });
        }]);

})(window.angular);

