(function (ng) {
    var mod = ng.module("comentariosModule");
    mod.controller("comentariosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios")
                    .then(function (response) {
                        $scope.elements = response.data;
            });

            $scope.mensajeStyle = {};

            $scope.revisarComentario = function(elem)
            {
                try 
                {
                    elem.calificacion = Number(elem.calificacion)
                } 
                catch (error) 
                {
                    $scope.mensajeStyle.colorClass = "red";
                    $scope.mensaje = 'Debe colocar un número entre 1 y 10';
                    return false;
                }
                
                if(!(elem.calificacion >= 1 && elem.calificacion <= 10))
                {
                    $scope.mensajeStyle.colorClass = "red";
                    $scope.mensaje = 'El número debe estar entre 1 y 10';
                    return false;
                }

                return true;
            }
        }]);
})(window.angular);