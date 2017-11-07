(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule", []);
    mod.constant("tarjetasDeCreditoContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaDeCredito/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasDeCreditoList', {
                url: 'clientes/{clienteUsuario:string}/tarjetasDeCredito',
                parent: 'clienteDetail',
                param: {
                    clienteUsuario: null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'tarjetasDeCreditoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasDeCredito.list.html'
                    }
                }
            }).state('tarjetasDeCreditoNew', {
                url: 'clientes/{clienteUsuario:string}/tarjetasDeCredito/crear',
                parent: 'clienteDetail',
                param: {
                    clienteUsuario: null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'tarjetasDeCreditoNewCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasDeCredito.list.html'
                    }
                }
            }).state('tarjetasDeCreditoUpdate', {
                url: 'clientes/{clienteUsuario:string}/tarjetasDeCredito/update',
                parent: 'clienteDetail',
                param: {
                    clienteUsuario: null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'tarjetasDeCreditoUpdateCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasDeCredito.list.html'
                    }
                }
            });
        }]);

})(window.angular);

