(function (ng) {
    var mod = ng.module("comentariosModule");
    mod.controller("comentariosCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/comentarios")
                    .then(function (response) {
                        $scope.elements = response.data;
            });

            $scope.mensajeStyle = {};
            regExpHttp = /^http:\/\//;

            $scope.revisarComentario = function(elem)
            {
                temp = elem.calificacion;;
                try 
                {
                    elem.calificacion = Number(elem.calificacion);
                } 
                catch (error) 
                {
                    elem.calificacion = temp;
                    $scope.mensajeStyle.colorClass = "red";
                    $scope.mensaje = 'Debe colocar un número entre 1 y 10';
                    return false;
                }
                

                if(("" + elem.calificacion).includes("."))
                {
                    $scope.mensajeStyle.colorClass = "red";
                    $scope.mensaje = 'Debe colocar un número entero';
                    return false;   
                }
                else if(!(elem.calificacion >= 1 && elem.calificacion <= 10))
                {
                    $scope.mensajeStyle.colorClass = "red";
                    $scope.mensaje = 'El número debe estar entre 1 y 10';
                    return false;
                }

                $scope.mensaje = '';
                return true;
            }

            $scope.revisarFotos = function(elem)
            {
                todoBien = true;
                for(ph in elem.fotos)
                {
                    url = elem.fotos[ph].url;
                    if(!regExpHttp.test(url))
                    {
                        $scope.mensajeStyle.colorClass = "red";                      
                        if($scope.mensaje == '')
                        {
                            $scope.mensaje = "Inserte una url válida";                              
                        }
                        else
                        {
                            $scope.mensaje += "<br>Inserte una url válida"; 
                        }
                        $scope.mensaje += "<br>Inserte una url válida";
                        todoBien = false;
                        return todoBien;
                    }
                }

                //Si llega acá es porque está todo bien
                $scope.mensaje = '';
                return todoBien;
            }
        }]);
})(window.angular);