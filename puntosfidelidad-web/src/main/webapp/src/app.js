(function (ng) {
    var app = angular.module('mainApp', [
        //Dependencias externas
        'ui.router',
       
        //Dependencias internas de módulos
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
})(window.angular);