public class Receptor {
    public static void main(String[] args) {
        Transmision transmision = new Transmision(5001);
        Aplicacion app = new Aplicacion();
        Presentacion presentacion = new Presentacion();
        Enlace enlace = new Enlace();

        String tramaRecibida = transmision.recibirMensaje();
        if (tramaRecibida == null || tramaRecibida.isEmpty() || !tramaRecibida.contains("|")) {
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
                // Procesar bloques de 9 bits (8 datos + 1 paridad)
                StringBuilder sbParidad = new StringBuilder();
                for (int i = 0; i + 9 <= trama.length(); i += 9) {
                    String bloque = trama.substring(i, i + 9);
                    if (!enlace.verificarParidad(bloque)) {
                        error = true;
                    }
                    sbParidad.append(enlace.quitarBitParidad(bloque));
                }
                binarioLimpio = sbParidad.toString();
                break;

            case "hamming":
                // Tratar toda la trama como un solo bloque Hamming dinámico
                Enlace.ResultadoHamming resultado = enlace.verificarYCorregirHamming(trama);
                if (resultado.huboError) {
                    error = true;
                }
                // mensajeCorregido contiene sólo los bits de datos (sin los de paridad)
                binarioLimpio = resultado.mensajeCorregido;
                break;

            case "crc":
            case "crc32":
                // Validar CRC-32 sobre toda la trama
                if (!enlace.verificarCRC(trama)) {
                    error = true;
                }
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
