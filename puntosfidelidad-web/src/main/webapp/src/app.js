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
        'tarjetasDeCreditoModule',
        'comentariosNuevosModule'
    ]);
    // Resuelve problemas de las promesas AKA no tocar
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false); 
        }]);
    
    app.run(['$rootScope', '$transitions', function ($rootScope, $transitions) {

            $transitions.onSuccess({to: '*'}, function (trans) {

                var $state = trans.router.stateService;
                var requireLogin = $state.current.data.requireLogin;
                var roles = $state.current.data.roles;

                if (sessionStorage.getItem("usuario") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("usuario");
                };

                $rootScope.isAuthenticated = function () {

                    if (sessionStorage.getItem("usuario") != null) {
                        $rootScope.currentUser = sessionStorage.getItem("usuario");
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

                $rootScope.darUsuario = function () {
                    return sessionStorage.getItem("usuario");
                };
                
                $rootScope.esCliente= function () {
                    return sessionStorage.getItem("rol")==='cliente';
                };
                
                $rootScope.esAdmin= function () {
                    return sessionStorage.getItem("rol")==='administrador';
                };

                if (requireLogin && (sessionStorage.getItem("usuario") === null)) {
                    event.preventDefault();
                    $state.go('login',$state.params, {reload: true});
                }
                               
                
                $rootScope.perfil= function () {  
                    event.preventDefault();
                   
                    if($rootScope.esCliente()){
                        $state.go('clienteDetail',{'clienteUsuario':$rootScope.currentUser}, {reload: true});
                    }
                    else{
                        $state.go('administradorDetail',{'administradorUsuario':$rootScope.currentUser}, {reload: true});
                    }
                };
                
                $rootScope.compras = function(){
                    event.preventDefault();
                    $state.go('clienteComprasList',{'clienteUsuario':$rootScope.currentUser}, {reload: true});
                };
                
                $rootScope.productos = function(){
                    event.preventDefault();
                    $state.go('clienteProductosList',{'clienteUsuario':$rootScope.currentUser}, {reload: true});
                };

            });        
            console.log($rootScope);

        }]);
})(window.angular);