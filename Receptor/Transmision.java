import java.io.*;
import java.net.*;

public class Transmision {
    private int puerto;

    public Transmision(int puerto) {
        this.puerto = puerto;
    }

    public String recibirMensaje() {
        String mensaje = "";
        try (ServerSocket serverSocket = new ServerSocket(puerto);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            mensaje = in.readLine();
            System.out.println("Mensaje recibido: " + mensaje);
        } catch (IOException e) {
            System.err.println("Error al recibir mensaje: " + e.getMessage());
        }
        return mensaje;
    }
}
