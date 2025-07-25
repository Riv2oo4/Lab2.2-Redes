class Enlace {
    public String calcularIntegridad(String binario) {
        int countOnes = 0;
        for (char bit : binario.toCharArray()) {
            if (bit == '1') countOnes++;
        }
        char paridad = (countOnes % 2 == 0) ? '0' : '1';
        String resultado = binario + paridad;
        System.out.println("Mensaje con bit de paridad: " + resultado);
        return resultado;
    }
}
