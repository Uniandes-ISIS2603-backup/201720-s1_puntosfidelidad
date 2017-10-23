(function (ng) {
    var app = angular.module('mainApp', [
        //Dependencias externas
        'ui.router',
       
        //Dependencias internas de módulos
        'pf.index_login'
    ]);
    // Resuelve problemas de las promesas AKA no tocar
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);