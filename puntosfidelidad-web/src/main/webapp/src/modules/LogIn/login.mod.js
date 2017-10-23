(function (ng) {
var mod = ng.module("pf.index_login", []);
    mod.constant("loginContext", "api/login");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/login/';
            $urlRouterProvider.otherwise("/#");

            $stateProvider.state('login', {
                url: '/login',
                templateUrl: basePath + 'login.html'/*
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

