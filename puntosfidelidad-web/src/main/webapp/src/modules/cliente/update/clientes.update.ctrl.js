(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesUpdateCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.rutaImagenes = [
                "media/perfil/1.png",
                "media/perfil/2.png",
                "media/perfil/3.png",
                "media/perfil/4.png",
                "media/perfil/5.png",
                "media/perfil/6.png",
                "media/perfil/7.png",
                "media/perfil/8.png",
                "media/perfil/9.png",
                "media/perfil/10.png",
                "media/perfil/11.png",
                "media/perfil/12.png"
            ];
            
            $http.get("api/clientes" + $state.params.clienteUsuario)
                    .then(function (response) {
                        $scope.elementoCliente = response.data;
                    });

            $scope.updateCliente = function () {
                $http.put("api/clientes" + $state.params.clienteUsuario, {
                    usuario: $state.params.clienteUsuario,
                    nombre: $scope.elementoCliente.nombre,
                    contrasena: $scope.elementoCliente.contrasena,
                    imagen: $scope.elementoCliente.imagen
                }).then(function (response) {
                    $state.go('clienteDetail', {clienteUsuario: response.data.usuario}, {reload: true});
                });
            };


        }]);
}
)(window.angular);