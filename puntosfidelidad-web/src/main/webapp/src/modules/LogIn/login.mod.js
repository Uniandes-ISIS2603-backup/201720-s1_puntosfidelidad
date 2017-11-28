(function (ng) {
var mod = ng.module("loginModule", []);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/LogIn/';
            $urlRouterProvider.otherwise("/login");

            $stateProvider.state('login', {
                url: '/login',    
                data: {
                    requireLogin: false
                },
                views: {
                    'bannerView':{
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'bannerLogin.html'
                    },
                    'mainView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'login.html'
                    }
                }

            });
        }]);

})(window.angular);

