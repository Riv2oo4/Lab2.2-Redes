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
}
