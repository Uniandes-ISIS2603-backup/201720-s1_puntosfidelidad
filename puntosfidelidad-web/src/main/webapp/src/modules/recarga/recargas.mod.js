(function (ng) {
var mod = ng.module("recargasModule", []);
    mod.constant("recargasContext", "api/recargas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/recarga/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('recargasList', {
                url: '/recargas',
                views: {
                    'mainView': {
                        controller: 'recargasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'recargas.list.html'
                    }
                }
            });
        }]);

})(window.angular);

