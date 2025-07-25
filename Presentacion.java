class Presentacion {
    public String codificarMensaje(String mensaje) {
        StringBuilder binario = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            binario.append(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0'));
        }
        System.out.println("Mensaje codificado en binario: " + binario);
        return binario.toString();
    }
}
