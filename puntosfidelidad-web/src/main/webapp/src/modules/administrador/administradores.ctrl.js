(function (ng) {
    var mod = ng.module("administradoresModule");
    mod.controller("administradoresCtrl", ['$scope', '$http', function ($scope, $http) {
            $scope.elements = [];
            $http.get("http://localhost:8080/puntosfidelidad-web/api/administradores")
                    .then(function (response) {
                        $scope.elements = response.data;
            });           
            
        }]);

})(window.angular);