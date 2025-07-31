import random

class Ruido:
    def aplicar_ruido(self, binario: str, tasa_error: float) -> str:
        ruidoso = []
        for bit in binario:
            if random.random() < tasa_error:
                bit = "1" if bit == "0" else "0"
            ruidoso.append(bit)
        ruidoso_str = "".join(ruidoso)
        return ruidoso_str
