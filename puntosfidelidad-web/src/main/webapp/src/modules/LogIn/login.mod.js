(function (ng) {
var mod = ng.module("loginModule", []);
    mod.constant("loginContext", "api/login");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/LogIn/';
            $urlRouterProvider.otherwise("/login");

            $stateProvider.state('login', {
                url: '/login',            
                views: {
                    'mainView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'login.html'
                    },
                    'bannerView':{                        
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'bannerLogin.html'
                    }
                }

            });
        }]);

})(window.angular);

