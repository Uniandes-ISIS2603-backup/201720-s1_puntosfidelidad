(function (ng) {
var mod = ng.module("comprasModule", []);
    mod.constant("comprasContext", "api/compras");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/compra/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('comprasList', {
                url: '/compras',
                views: {
                    'mainView': {
                        controller: 'comprasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'compras.list.html'
                    }
                }
            });
        }]);

})(window.angular);

