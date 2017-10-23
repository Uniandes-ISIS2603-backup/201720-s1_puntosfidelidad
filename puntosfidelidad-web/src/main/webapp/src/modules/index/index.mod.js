(function (ng) {
var mod = ng.module("pf.index", []);
    mod.constant("indexContext", "api/login");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/index/';
            $urlRouterProvider.otherwise("/home");

            $stateProvider.state('home', {
                url: '/home',
                templateUrl: basePath + 'index.html'
                
                //Código comentado porque no servía (Toca ver cuando se necesite controllers)

                /*
                views: {
                    'mainView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'login.html'
                    }
                }*/

            });
        }]);

})(window.angular);

