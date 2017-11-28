(function (ng) {
    var app = angular.module('mainApp', [
        //Dependencias externas
        'ui.router',

        //Dependencias internas de módulos
        'inicioModule',
        'loginModule',
        'productoModule',
        'comprasModule',
        'restaurantesModule',
        'comentariosModule',
        'tarjetasPuntosModule',
        'sucursalModule',
        'eventosModule',
        'clientesModule',
        'recargasModule',
        'administradoresModule',
        'tarjetasDeCreditoModule'
    ]);
    // Resuelve problemas de las promesas AKA no tocar
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false); 
        }]);
    
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin
                var roles = $state.current.data.roles


                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("usuario") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("nombre");
                        return true;
                    } else {
                        return false;
                    }
                };

                $rootScope.hasPermissions = function () {
                    if (($rootScope.isAuthenticated) && (roles.indexOf(sessionStorage.getItem("rol")) > -1)) {
                        return true;
                    } else {
                        return false;
                    }
                };


                if (requireLogin && (sessionStorage.getItem("usuario") === null)) {
                    event.preventDefault();
                    $state.go('login', $state.params);
                }

            });
            
            $rootScope.doTheBack = function() {window.history.back();};


        }]);
})(window.angular);