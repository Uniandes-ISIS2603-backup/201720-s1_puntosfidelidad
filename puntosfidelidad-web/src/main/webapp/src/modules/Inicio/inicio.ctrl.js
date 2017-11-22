(function (ng) {
    var mod = ng.module("inicioModule");
    mod.controller("inicioCtrl", ['$scope', '$http', function () {
            /**
             * Array con las imagenes que se iran mostrando en la web
             */
            var imagenes = ['./media/I1.jpg', './media/I2.jpg', './media/I3.jpg'];

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