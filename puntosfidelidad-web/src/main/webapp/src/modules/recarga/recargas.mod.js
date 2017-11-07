(function (ng) {
var mod = ng.module("recargasModule", []);
    mod.constant("recargasContext", "api/recargas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/recarga/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('recargasList', {
                url: 'clientes/{clienteUsuario:string}/recargas',
                param:{
                    clienteUsuario:null
                },
                views: {
                    'mainView': {
                        controller: 'clientesDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'clientes.detail.html'
                    },
                    'detailClienteView': {
                        controller: 'recargasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'recargas.list.html'
                    }
                }
            });
        }]);

})(window.angular);

