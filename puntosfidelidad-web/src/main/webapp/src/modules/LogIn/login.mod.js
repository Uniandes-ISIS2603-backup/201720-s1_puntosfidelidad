(function (ng) {
var mod = ng.module("pf.login", []);
    mod.constant("loginContext", "api/login");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/LogIn/';
            $urlRouterProvider.otherwise("/login");

            $stateProvider.state('login', {
                url: '/login',
                templateUrl: basePath + 'login.html'
                
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

