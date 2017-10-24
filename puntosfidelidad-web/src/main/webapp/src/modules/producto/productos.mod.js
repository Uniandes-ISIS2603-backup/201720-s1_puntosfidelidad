(function (ng) {
var mod = ng.module("productoModule", []);
    mod.constant("productosContext", "api/productos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/producto/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('productosList', {
                url: '/productos',
                views: {
                    'mainView': {
                        controller: 'productosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'productos.list.html'
                    }
                }
            }).state('productosDetail', {
                url: '/productos/detail',
                views: {
                    'mainView': {
                        controller: 'productosDetailCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'cities.create.html'
                    }
                }

            });
        }]);

})(window.angular);

