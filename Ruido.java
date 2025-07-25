// Ruido.java
import java.util.Random;

class Ruido {
    Random random = new Random();
    double tasaError = 0.01; // 1% de error

    public String aplicarRuido(String binario) {
        StringBuilder ruidoso = new StringBuilder();
        for (char bit : binario.toCharArray()) {
            if (random.nextDouble() < tasaError) {
                bit = (bit == '1') ? '0' : '1'; // flip
            }
            ruidoso.append(bit);
        }
        System.out.println("Mensaje con ruido aplicado: " + ruidoso);
        return ruidoso.toString();
    }
}
