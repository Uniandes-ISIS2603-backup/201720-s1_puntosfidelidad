(function (ng) {
    var mod = ng.module("recargasModule", []);
    mod.constant("recargasContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/recarga/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('recargasList', {
                url: '/recargas',
                data: {
                    requireLogin: true
                },
                views: {                    
                    'mainView': {
                        controller: 'recargasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'recargas.list.html'
                    }
                }
            }).state('recargasNew', {
                url: '/recargas/crear',
                parent: 'clienteDetail',
                param: {
                    clienteUsuario: null
                },
                data: {
                    requireLogin: true
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: 'src/modules/cliente/clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'recargasNewCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'recargas.list.html'
                    }
                }
            });
        }]);

})(window.angular);

