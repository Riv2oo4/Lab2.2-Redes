public class Enlace {

    public String calcularIntegridad(String binario) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < binario.length(); i += 8) {
            String bloque = binario.substring(i, Math.min(i + 8, binario.length()));
            int unos = 0;

            for (char c : bloque.toCharArray()) {
                if (c == '1') unos++;
            }

            char bitParidad = (unos % 2 == 0) ? '0' : '1';

            resultado.append(bloque).append(bitParidad);
        }

        return resultado.toString();
    }
}
