(function (ng) {
    var mod = ng.module("inicioModule");
    mod.controller("inicioCtrl", [function () {
            
            if (sessionStorage.getItem("usuario")) {
                sessionStorage.clear();
            };   
            /**
             * Array con las imagenes que se iran mostrando en la web
             */
            var imagenes = ['./media/I1.jpg', './media/I2.jpg', './media/I3.jpg'];

            /**
             * Funcion para cambiar la imagen
             */
            function muteVideo()
            {
                document.getElementById("bgvid").muted = true;
            }
            /**
             * Función que se ejecuta una vez cargada la página
             */
            onload = function ()
            {
                muteVideo();
            };      
            
        }]);

})(window.angular);