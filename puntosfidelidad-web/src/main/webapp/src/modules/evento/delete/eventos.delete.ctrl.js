(function (ng) {
    var mod = ng.module("eventosModule");
    mod.constant("eventosContext", "api/eventos");
    mod.controller('eventosDeleteCtrl', ['$scope', '$http', 'eventosContext', '$state',
        function ($scope, $http, eventosContext, $state) {
            var nomEvento = $state.params.eventoNombre;
            $scope.deleteEvento = function () {
                $http.delete("api/eventos" + '/' + nomEvento, {}).then(function (response) {
                    $state.go('eventosList', {eventoNombre: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);