(function (ng) {
    var mod = ng.module("comentariosNuevosModule");
    mod.controller("comentariosNuevosCtrl", ['$scope', '$http', '$state', function ($scope, $http, $state) {
        
            $scope.restauranteActual = function(restAct)
            {
                if(restAct != '')
                {
                    $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios/restaurantes/" + restAct)
                    .then(function (response) {
                        $scope.comentarios = response.data;
                    });
                }
            } 

            $scope.isParametrized = $state.params.restauranteNit !== undefined;
            $scope.restauranteActualStr = '';
            $scope.comentarios = [];
            $scope.restaurantes = [];

            if($scope.isParametrized)
            {
                $scope.restauranteActual($state.params.restauranteNit);
            }
            else
            {
                $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes")
                        .then(function (response) {
                            $scope.restaurantes = response.data;
                });           
            }

            console.log($scope.isParametrized + ' // ' + $state.params.restauranteNit)
              

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