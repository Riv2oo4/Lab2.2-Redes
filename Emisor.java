public class Emisor {
    public static void main(String[] args) {
        Aplicacion app = new Aplicacion();
        String mensaje = app.solicitarMensaje();

        Presentacion presentacion = new Presentacion();
        String binario = presentacion.codificarMensaje(mensaje);

        Enlace enlace = new Enlace();
        String mensajeConIntegridad = enlace.calcularIntegridad(binario);

        Ruido ruido = new Ruido();
        String mensajeConRuido = ruido.aplicarRuido(mensajeConIntegridad);

        System.out.println("Mensaje final con ruido: " + mensajeConRuido);
    }
}
