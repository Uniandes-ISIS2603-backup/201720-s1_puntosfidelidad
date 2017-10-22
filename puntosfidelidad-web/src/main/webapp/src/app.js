(function (ng) {
    var app = angular.module('mainApp', [
        //Dependencias externas
        'ui.router',
       
        //Dependencias internas de módulos
        'puntosFidelidadModule',
    ]);
    // Resuelve problemas de las promesas AKA no tocar
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);