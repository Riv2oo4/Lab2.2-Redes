class Enlace:
    def calcular_integridad(self, binario: str) -> str:
        resultado = []
        for i in range(0, len(binario), 8):
            bloque = binario[i : i + 8]
            unos = bloque.count("1")
            bit_paridad = "0" if unos % 2 == 0 else "1"
            resultado.append(bloque + bit_paridad)
        return "".join(resultado)
