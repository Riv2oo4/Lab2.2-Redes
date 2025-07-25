public class Emisor {
    public static void main(String[] args) {
        Aplicacion aplicacion = new Aplicacion();
        Presentacion presentacion = new Presentacion();
        Enlace enlace = new Enlace();
        Ruido ruido = new Ruido();

        String mensaje = aplicacion.solicitarMensaje();
        double tasaRuido = aplicacion.solicitarTasaDeRuido();

        String binario = presentacion.codificarMensaje(mensaje);
        System.out.println("Mensaje codificado en binario: " + binario);

        String binarioConParidad = enlace.calcularIntegridad(binario);
        System.out.println("Mensaje con bit de paridad: " + binarioConParidad);

        String mensajeConRuido = ruido.aplicarRuido(binarioConParidad, tasaRuido);
        System.out.println("Mensaje con ruido aplicado: " + mensajeConRuido);

        System.out.println("Mensaje final con ruido: " + mensajeConRuido);
    }
}
