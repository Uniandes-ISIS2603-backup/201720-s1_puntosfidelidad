(function (ng) {
    var mod = ng.module("restaurantesModule", []);
        mod.constant("restaurantesContext", "api/restaurantes");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
                var basePath = 'src/modules/restaurante/';
                $urlRouterProvider.otherwise("");
    
                $stateProvider.state('restaurantesList', {
                    url: '/restaurantes',
                    views: {
                        'mainView': {
                            controller: 'restaurantesCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'restaurantes.list.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);
    
    