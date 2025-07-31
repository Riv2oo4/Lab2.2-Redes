class Aplicacion:
    def __init__(self):
        pass

    def solicitar_mensaje(self) -> str:
        return input("Ingrese el mensaje a enviar: ")

    def solicitar_tasa_de_ruido(self) -> float:
        entrada = input("Ingrese la tasa de error (ej. 1/100 para 1 error cada 100 bits): ")
        try:
            numerador, denominador = entrada.split("/")
            return float(numerador) / float(denominador)
        except Exception:
            print("Entrada inválida. Se usará tasa por defecto 1/100.")
            return 0.01
