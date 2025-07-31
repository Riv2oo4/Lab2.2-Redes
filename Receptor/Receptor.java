public class Receptor {
    public static void main(String[] args) {
        Transmision transmision = new Transmision(5001);
        Aplicacion app = new Aplicacion();
        Presentacion presentacion = new Presentacion();
        Enlace enlace = new Enlace();

        String tramaRecibida = transmision.recibirMensaje();

        if (tramaRecibida == null || tramaRecibida.length() == 0 || !tramaRecibida.contains("|")) {
            System.out.println("Trama inválida recibida.");
            return;
        }

        String[] partes = tramaRecibida.split("\\|", 2);
        String algoritmo = partes[0].toLowerCase();
        String trama = partes[1];

        boolean error = false;
        String binarioLimpio = "";

        switch (algoritmo) {
            case "paridad":
                error = !enlace.verificarParidad(trama);
                binarioLimpio = enlace.quitarBitParidad(trama);
                break;
            case "hamming":
                Enlace.ResultadoHamming resultado = enlace.verificarYCorregirHamming(trama);
                error = resultado.huboError;
                binarioLimpio = resultado.mensajeCorregido;
                break;
            case "crc":
            case "crc32":
                error = !enlace.verificarCRC(trama);
                binarioLimpio = enlace.quitarCRC(trama);
                break;
            default:
                System.out.println("Algoritmo no reconocido: " + algoritmo);
                return;
        }

        if (error) {
            app.mostrarMensaje("Mensaje con error detectado", true);
        } else {
            String mensaje = presentacion.decodificarBinario(binarioLimpio);
            app.mostrarMensaje(mensaje, false);
        }
    }
}
