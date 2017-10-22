(function (ng) {
var mod = ng.module("puntosFidelidadModule", []);
    mod.constant("citiesContext", "api/cities");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/cities/';
            $urlRouterProvider.otherwise("/citiesList");

            $stateProvider.state('puntosFidelidadEj1', {
                url: '/login',
                views: {
                    'mainView': {
                        controller: 'puntosFidelidadCTRL',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pf.login.html'
                    }
                }
            }).state('puntosFidelidadEj2', {
                url: '/restaurantes',
                views: {
                    'mainView': {
                        controller: 'puntosFidelidadCTRL',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pf.restaurantes.html'
                    }
                }

            })
        }]);

})(window.angular);