import java.util.Random;

class Ruido {
    Random random = new Random();

    public String aplicarRuido(String binario, double tasaError) {
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
