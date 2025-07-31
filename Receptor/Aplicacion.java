public class Aplicacion {
    public void mostrarMensaje(String mensaje, boolean hayError) {
        if (hayError) {
            System.out.println("Error detectado en la transmisión. El mensaje podría estar corrupto.");
        } else {
            System.out.println("Mensaje recibido sin errores: " + mensaje);
        }
    }
}
