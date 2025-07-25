import java.util.Scanner;

class Aplicacion {
    Scanner scanner = new Scanner(System.in);

    public String solicitarMensaje() {
        System.out.print("Ingrese el mensaje a enviar: ");
        return scanner.nextLine();
    }
}
