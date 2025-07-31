public class Receptor {
    public static void main(String[] args) {
        Transmision transmision = new Transmision(5001);
        Enlace enlace = new Enlace();
        Presentacion presentacion = new Presentacion();
        Aplicacion aplicacion = new Aplicacion();

        String tramaRecibida = transmision.recibirMensaje();

        boolean error = !enlace.verificarParidad(tramaRecibida);
        String sinParidad = enlace.quitarBitParidad(tramaRecibida);

        if (error) {
            aplicacion.mostrarMensaje("", true);
        } else {
            String mensaje = presentacion.decodificarBinario(sinParidad);
            aplicacion.mostrarMensaje(mensaje, false);
        }
    }
}
