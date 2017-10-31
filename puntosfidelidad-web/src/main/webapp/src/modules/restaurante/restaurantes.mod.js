(function (ng) {
    var mod = ng.module("restaurantesModule", []);
        mod.constant("restaurantesContext", "api/restaurantes");
        mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider, $scope) {
                var basePath = 'src/modules/restaurante/';
                $urlRouterProvider.otherwise("/restaurantes");
    
                $stateProvider.state('restaurantesList', {
                    url: '/restaurantes',
                    views: {
                        'mainView': {
                            controller: 'restaurantesCtrl',
                            controllerAs: 'ctrl',
                            templateUrl: basePath + 'restaurantes.list.html'
                        }
                    }
                }).state('restauranteSelect', {
                    url: '/restaurante',
                    parent: 'restaurantesList',
                    views: {
                        'selectView': {
                            templateUrl: basePath + 'restaurante.detail.html'
                        }
                    }
                });
            }]);
    
    })(window.angular);
    