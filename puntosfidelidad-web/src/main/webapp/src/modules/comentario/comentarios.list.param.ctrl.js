(function (ng) {
    var mod = ng.module("comentariosNuevosModule");
    mod.controller("comentariosNuevosCtrl", ['$scope', '$http', function ($scope, $http) {
            
            $scope.restauranteActualStr = '';
            $scope.comentarios = [];
            $scope.restaurantes = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/restaurantes")
                    .then(function (response) {
                        $scope.restaurantes = response.data;
            });           
            
           
            if($scope.restauranteActualStr != '')
            {
                $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios/restaurantes/" + $scope.restauranteActualStr)
                .then(function (response) {
                    $scope.comentarios = response.data;
                });

                console.log($scope.comentarios);
            }
            
            $scope.restauranteActual = function(restAct)
            {
                if(restAct != '')
                {
                    $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios/restaurantes/" + restAct)
                    .then(function (response) {
                        $scope.comentarios = response.data;
                    });    
                    console.log($scope.comentarios);
                }
            }

            $scope.restauranteActual($scope.restauranteActualStr);
                

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