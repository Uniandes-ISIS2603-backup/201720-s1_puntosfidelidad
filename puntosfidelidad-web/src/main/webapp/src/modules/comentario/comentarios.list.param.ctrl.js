(function (ng) {
    var mod = ng.module("comentariosNuevosModule");
    mod.controller("comentariosNuevosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.restaurantes = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes")
                    .then(function (response) {
                        $scope.restaurantes = response.data;
            });

            $scope.asignarEstrellasCSS = function(calificacion)
            {
                estaEnRango = calificacion <= 10 && calificacion>=0
                if(typeof(calificacion) === 'number')
                    return "estrellasComentario"+calificacion
                else
                    return "hueputa"
            }
        }]);
})(window.angular);
