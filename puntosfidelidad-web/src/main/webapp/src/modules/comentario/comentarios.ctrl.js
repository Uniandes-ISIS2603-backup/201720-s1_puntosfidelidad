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

                //$scope.mensaje = '';
                return true;
            }

            $scope.revisarFotos = function(elem)
            {
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
                            $scope.mensaje = "\nInserte una url válida"; 
                        }
                        return false;
                    }
                }

                //Si llega acá es porque está todo bien
                //$scope.mensaje = '';
                return true;
            }

            $scope.nuevaFoto = function(fotos)
            {
                nuevaFoto = {}
                nuevaFoto.url = '';
                fotos.push(nuevaFoto);                
            }

            $scope.borrarFoto = function(fotos, ph)
            {
                index = fotos.indexOf(ph);

                if(index > -1)
                {
                    fotos.splice(index,1);
                }                    
            }

            $scope.postComentario = function(comentarios, comentario)
            {
                usuario = comentario.cliente.usuario;
                comentariosCliente = [];
                
                for(cmnt in comentarios)
                {
                    if(comentarios[cmnt].cliente.usuario == usuario)
                    {
                        comentariosCliente.push(comentarios[cmnt]);
                    }
                }

                console.log("comentarios: ");
                console.log(comentariosCliente);

                $http.put('http://localhost:8080/puntosfidelidad-web/api/clientes/' + usuario + '/comentarios', comentarios).then(
                    function todoBien(response) 
                    {
                        console.log("todo bien!")
                    },
                    function todoMal(error)
                    {
                        console.log(error);
                    }
                );
            }
        }]);
})(window.angular);