class Presentacion:
    def codificar_mensaje(self, mensaje: str) -> str:
        binario = "".join(format(ord(c), "08b") for c in mensaje)
        return binario
