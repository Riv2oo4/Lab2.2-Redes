public class Enlace {
    public boolean verificarParidad(String trama) {
        int unos = 0;
        for (int i = 0; i < trama.length() - 1; i++) {
            if (trama.charAt(i) == '1') {
                unos++;
            }
        }
        char bitParidad = trama.charAt(trama.length() - 1);
        return (unos % 2 == 0 && bitParidad == '0') || (unos % 2 == 1 && bitParidad == '1');
    }

    public String quitarBitParidad(String trama) {
        return trama.substring(0, trama.length() - 1);
    }
    public boolean verificarCRC(String trama) {
        int crcLength = 8;
        String mensaje = trama.substring(0, trama.length() - crcLength);
        String recibido = trama.substring(trama.length() - crcLength);
    
        int calculado = mensaje.hashCode() & 0xFF; 
        String calculadoBin = String.format("%8s", Integer.toBinaryString(calculado)).replace(' ', '0');
    
        return recibido.equals(calculadoBin);
    }
    
    public String quitarCRC(String trama) {
        int crcLength = 8;
        return trama.substring(0, trama.length() - crcLength);
    }
    
    public static class ResultadoHamming {
        public boolean huboError;
        public String mensajeCorregido;
    }
    
    public ResultadoHamming verificarYCorregirHamming(String trama) {
        ResultadoHamming resultado = new ResultadoHamming();
    
        int errorPos = 0;
        int r = 0;
        while (Math.pow(2, r) < trama.length()) r++;
    
        for (int i = 0; i < r; i++) {
            int pos = (int) Math.pow(2, i);
            int suma = 0;
            for (int j = pos; j <= trama.length(); j++) {
                if (((j >> i) & 1) == 1) {
                    if (j - 1 < trama.length() && trama.charAt(j - 1) == '1') {
                        suma++;
                    }
                }
            }
            if (suma % 2 != 0) {
                errorPos += pos;
            }
        }
    
        if (errorPos > 0 && errorPos <= trama.length()) {
            StringBuilder corregido = new StringBuilder(trama);
            corregido.setCharAt(errorPos - 1, trama.charAt(errorPos - 1) == '1' ? '0' : '1');
            trama = corregido.toString();
            resultado.huboError = true;
        }
    
        StringBuilder datos = new StringBuilder();
        for (int i = 1; i <= trama.length(); i++) {
            if ((i & (i - 1)) != 0) {
                datos.append(trama.charAt(i - 1));
            }
        }
    
        resultado.mensajeCorregido = datos.toString();
        return resultado;
    }
    
}
