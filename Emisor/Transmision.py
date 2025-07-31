import socket

class Transmision:
    def __init__(self, host='localhost', puerto=5001):
        self.host = host
        self.puerto = puerto

    def enviarInformacion(self, mensaje):
        try:
            with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
                s.connect((self.host, self.puerto))
                s.sendall(mensaje.encode())
                print("Mensaje enviado exitosamente.")
        except Exception as e:
            print(f"Error al enviar el mensaje: {e}")



