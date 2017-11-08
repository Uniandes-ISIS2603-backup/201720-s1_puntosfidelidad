(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.controller("administradoresCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.administradoresLista = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/administradores")
                    .then(function (response) {
                        $scope.administradoresLista = response.data;
            });           
            
        
    
    $scope.deleteAdministrador = function(administrador)
            {
                quiereBorrar = confirm("¿Seguro desea borrar el Administrador?");

                if(quiereBorrar)
                {
                    usuario = administrador.usuario;
                    

                    $http.delete('http://localhost:8080/puntosfidelidad-web/api/administradores/' + usuario).then(
                        function todoBien(response)
                        {
                            index = $scope.elements.indexOf(administrador);
                            if(index > -1)
                            {
                                $scope.elements.splice(index, 1);
                                console.log("todo bien!");
                            }
                            else
                            {
                                console.log("Error con el index!")
                            }
                        },
                        function todoMal(error)
                        {
                            console.log(error);
                        }
                    );
                }
            }
}]);
})(window.angular);