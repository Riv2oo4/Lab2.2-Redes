# enlace.py
import binascii

class Enlace:
    def calcular_integridad(self, binario: str, algoritmo: str) -> str:
        if algoritmo == "hamming":
            return self._calcular_hamming(binario)
        elif algoritmo == "crc32":
            return self._calcular_crc32(binario)
        else:
            return self._calcular_paridad(binario)

    def _calcular_paridad(self, binario: str) -> str:
        resultado = []
        for i in range(0, len(binario), 8):
            bloque = binario[i : i + 8]
            unos = bloque.count("1")
            bit_paridad = "0" if unos % 2 == 0 else "1"
            resultado.append(bloque + bit_paridad)
        return "".join(resultado)

    def _calcular_hamming(self, binario: str) -> str:
        m = len(binario)
        r = 0
        while 2**r < m + r + 1:
            r += 1
        n = m + r
        code = ["0"] * (n + 1)
        j = 0
        for i in range(1, n + 1):
            if (i & (i - 1)) != 0:
                code[i] = binario[j]
                j += 1
        for i in range(r):
            p = 2 ** i
            suma = 0
            for k in range(1, n + 1):
                if k & p and k != p:
                    suma ^= int(code[k])
            code[p] = str(suma)
        return "".join(code[1:])

    def _calcular_crc32(self, binario: str) -> str:
        pad_len = (8 - len(binario) % 8) % 8
        binario_padded = "0" * pad_len + binario
        data = bytearray()
        for i in range(0, len(binario_padded), 8):
            byte = int(binario_padded[i : i + 8], 2)
            data.append(byte)
        checksum = binascii.crc32(data) & 0xFFFFFFFF
        checksum_bin = format(checksum, "032b")
        return binario + checksum_bin

