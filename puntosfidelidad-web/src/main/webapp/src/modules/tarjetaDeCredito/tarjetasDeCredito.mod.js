(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule", []);
    mod.constant("tarjetasDeCreditoContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaDeCredito/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasDeCreditoList', {
                url: '/tarjetasDeCredito',
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
                url: '/tarjetasDeCredito/crear',
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
            }).state('tarjetasDeCreditoDelete', {
                url: '/tarjetasDeCredito/{tarjetaCreditoId:int}/eliminar',                 
                parent: 'clienteDetail',
                param: {
                    tarjetaCreditoId:null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'tarjetaDeCreditoDeleteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'delete/tarjetasDeCredito.delete.html'
                    }
                }
            }).state('tarjetasDeCreditoUpdate', {
                url: '/tarjetasDeCredito/{tarjetaCreditoId:int}/update',                 
                parent: 'clienteDetail',
                param: {
                    tarjetaCreditoId:null
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
                        templateUrl: basePath+'update/tarjetasDeCredito.update.html'
                    }
                }
            });
        }]);

})(window.angular);
