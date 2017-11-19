(function (ng) {
var mod = ng.module("loginModule", []);
    mod.constant("loginContext", "api/login");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/LogIn/';
            $urlRouterProvider.otherwise("/login");

            $stateProvider.state('login', {
                url: '/login',    
                data: {
                    requireLogin: false
                },
                views: {
                    'mainView': {
                        controller: 'loginCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'login.html'
                    }
                }

            });
        }]);

})(window.angular);

