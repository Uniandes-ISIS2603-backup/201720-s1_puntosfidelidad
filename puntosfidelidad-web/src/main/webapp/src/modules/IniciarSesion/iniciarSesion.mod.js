(function (ng) {
    var mod = ng.module("InicarSesionCliente", ['recargasModule', 'tarjetasDeCreditoModule','tarjetasPuntosClienteModule']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/IniciarSesion/';
            $urlRouterProvider.otherwise("");

            $stateProvider.state('iniciar', {
                url: '/iniciar',
                views: {
                    'panelInicial': {                        
                        templateUrl: basePath + 'iniciarSesion.html'
                    }
                }
            });
            
        }]);
})(window.angular);

