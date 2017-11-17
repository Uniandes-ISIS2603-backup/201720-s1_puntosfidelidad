(function (ng) {
    var app = angular.module('mainApp', [
        //Dependencias externas
        'ui.router',

        //Dependencias internas de módulos
        'productoModule',
        'comprasModule',
        'restaurantesModule',
        'comentariosModule',
        'tarjetasPuntosModule',
        'sucursalModule',
        'eventosModule',
        'clientesModule',
        'recargasModule',
        'administradoresModule',
        'tarjetasDeCreditoModule',
        'InicarSesionCliente'
    ]);
    // Resuelve problemas de las promesas AKA no tocar
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);

            /**
             * Array con las imagenes que se iran mostrando en la web
             */
            var imagenes = new Array(
                    './media/Index1.jpg',
                    './media/Index2.jpg',     
                    './media/Index3.jpg'
                    );

            /**
             * Funcion para cambiar la imagen
             */
            function rotarImagenes()
            {
                // obtenemos un numero aleatorio entre 0 y la cantidad de imagenes que hay
                var index = Math.floor((Math.random() * imagenes.length));

                // cambiamos la imagen
                document.getElementById("imagenIndex").src = imagenes[index];
            }

            /**
             * Función que se ejecuta una vez cargada la página
             */
            onload = function ()
            {
                // Cargamos una imagen aleatoria
                rotarImagenes();

                // Indicamos que cada 5 segundos cambie la imagen
                setInterval(rotarImagenes, 5000);
            };
        }]);
})(window.angular);