# emisor.py
from Aplicacion import Aplicacion
from Presentacion import Presentacion
from Enlace import Enlace
from Ruido import Ruido
from Transmision import Transmision

def main():
    aplicacion = Aplicacion()
    presentacion = Presentacion()
    enlace = Enlace()
    ruido = Ruido()
    transmision = Transmision()

    mensaje = aplicacion.solicitar_mensaje()
    tasa_ruido = aplicacion.solicitar_tasa_de_ruido()
    algoritmo = aplicacion.solicitar_algoritmo_integridad()

    binario = presentacion.codificar_mensaje(mensaje)
    print(f"Mensaje codificado en binario: {binario}")

    binario_con_integridad = enlace.calcular_integridad(binario, algoritmo)
    print(f"Mensaje con {algoritmo}: {binario_con_integridad}")

    mensaje_con_ruido = ruido.aplicar_ruido(binario_con_integridad, tasa_ruido)
    print(f"Mensaje final con ruido: {mensaje_con_ruido}")

    transmision.enviarInformacion(mensaje_con_ruido)

if __name__ == "__main__":
    main()
