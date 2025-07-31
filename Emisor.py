from Aplicacion import Aplicacion
from Presentacion import Presentacion
from Enlace import Enlace
from Ruido import Ruido

def main():
    aplicacion = Aplicacion()
    presentacion = Presentacion()
    enlace = Enlace()
    ruido = Ruido()

    mensaje = aplicacion.solicitar_mensaje()
    tasa_ruido = aplicacion.solicitar_tasa_de_ruido()

    binario = presentacion.codificar_mensaje(mensaje)
    print(f"Mensaje codificado en binario: {binario}")

    binario_con_paridad = enlace.calcular_integridad(binario)
    print(f"Mensaje con bit de paridad: {binario_con_paridad}")

    mensaje_con_ruido = ruido.aplicar_ruido(binario_con_paridad, tasa_ruido)
    print(f"Mensaje final con ruido: {mensaje_con_ruido}")

if __name__ == "__main__":
    main()
