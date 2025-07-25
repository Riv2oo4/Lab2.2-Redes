import java.util.Scanner;

public class Aplicacion {
    private Scanner scanner;

    public Aplicacion() {
        scanner = new Scanner(System.in);
    }

    public String solicitarMensaje() {
        System.out.print("Ingrese el mensaje a enviar: ");
        return scanner.nextLine();
    }

    public double solicitarTasaDeRuido() {
        System.out.print("Ingrese la tasa de error (ej. 1/100 para 1 error cada 100 bits): ");
        String entrada = scanner.nextLine();

        try {
            String[] partes = entrada.split("/");
            double numerador = Double.parseDouble(partes[0]);
            double denominador = Double.parseDouble(partes[1]);

            return numerador / denominador;
        } catch (Exception e) {
            System.out.println("Entrada inválida. Se usará tasa por defecto 1/100.");
            return 0.01;
        }
    }
}
