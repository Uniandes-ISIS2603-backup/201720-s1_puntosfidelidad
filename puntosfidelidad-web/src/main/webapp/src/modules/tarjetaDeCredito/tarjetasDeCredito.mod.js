(function (ng) {
    var mod = ng.module("tarjetasDeCreditoModule", []);
    mod.constant("tarjetasDeCreditoContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetaDeCredito/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('tarjetasDeCreditoList', {
                url: '/tarjetasDeCredito',
                data: {
                    requireLogin: true
                },                
                views: {                    
                    'mainView': {
                        controller: 'tarjetasDeCreditoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasDeCredito.list.html'
                    }
                }
            }).state('tarjetasDeCreditoNew', {
                url: '/tarjetasDeCreditoCrear',
                data: {
                    requireLogin: true
                },                
                views: {
                    'mainView': {
                        controller: 'tarjetasDeCreditoNewCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'tarjetasDeCredito.list.html'
                    }
                }
            }).state('tarjetasDeCreditoDelete', {
                url: '/tarjetasDeCredito/{tarjetaCreditoId:int}/eliminar',                 
                data: {
                    requireLogin: true
                },
                param: {
                    tarjetaCreditoId:null
                },
                views: {
                    'mainView': {
                        controller: 'tarjetaDeCreditoDeleteCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'delete/tarjetasDeCredito.delete.html'
                    }
                }
            }).state('tarjetasDeCreditoUpdate', {
                url: '/tarjetasDeCredito/{tarjetaCreditoId:int}/update',                 
                data: {
                    requireLogin: true
                },
                param: {
                    tarjetaCreditoId:null
                },
                views: {
                    'mainView': {
                        controller: 'tarjetasDeCreditoUpdateCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath+'update/tarjetasDeCredito.update.html'
                    }
                }
            });
        }]);

})(window.angular);

