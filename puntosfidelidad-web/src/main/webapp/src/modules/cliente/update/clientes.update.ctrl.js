(function (ng) {
    var mod = ng.module("clientesModule");
    mod.constant("clientesContext", "api/clientes");
    mod.controller('clientesUpdateCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {
            $rootScope.edit = true;

            $scope.rutaImagenes = [
                "media/perfil/1.jpg",
                "media/perfil/2.jpg",
                "media/perfil/3.jpg",
                "media/perfil/4.jpg",
                "media/perfil/5.jpg",
                "media/perfil/6.jpg",
                "media/perfil/7.jpg",
                "media/perfil/8.jpg",
                "media/perfil/9.jpg",
                "media/perfil/10.jpg",
                "media/perfil/11.jpg",
                "media/perfil/12.jpg"
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