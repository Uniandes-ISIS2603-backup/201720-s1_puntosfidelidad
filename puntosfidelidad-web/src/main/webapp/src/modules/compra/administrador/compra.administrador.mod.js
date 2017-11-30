(function (ng) {
var mod = ng.module("tarjetasPuntosClienteModule", []);
    mod.constant("tarjetasPuntosClienteContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaPuntos/cliente/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasPuntosClienteList', {
                url: '/tarjetasPuntosCliente',
                data: {
                    requireLogin: true
                },
                views: {                    
                    'mainView': {
                       controller: 'tarjetasPuntosClienteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'tarjetasPuntos.cliente.list.html' 
                    }
                }
            });
        }]);

})(window.angular);

