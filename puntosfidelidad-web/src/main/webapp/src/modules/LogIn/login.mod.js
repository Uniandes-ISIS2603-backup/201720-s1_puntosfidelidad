/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {
var mod = ng.module("LoginModule", []);
    mod.constant("LoginContext", "api/LogIn");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/LogIn/';
            $urlRouterProvider.otherwise("/LogIn");

            $stateProvider.state('LogIn', {
                url: '/LogIn',
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

