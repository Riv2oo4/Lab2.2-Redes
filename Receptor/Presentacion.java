public class Presentacion {
    public String decodificarBinario(String binario) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < binario.length(); i += 8) {
            if (i + 8 <= binario.length()) {
                String byteStr = binario.substring(i, i + 8);
                int ascii = Integer.parseInt(byteStr, 2);
                resultado.append((char) ascii);
            }
        }
        return resultado.toString();
    }
}
