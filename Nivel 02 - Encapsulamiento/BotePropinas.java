public class BotePropinas {
    // Atributos privados: nadie puede cambiar el total sin dejar rastro
    private int total;
    private int aportes;

    public void aportar(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El aporte debe ser mayor a 0: " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona para repartir");
        }
        return total / personas; // División entera justa
    }

    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException("Debe haber al menos 1 persona");
        }
        return total % personas; // Residuo: monedas que no se pueden partir
    }

    public int getTotal() {
        return total;
    }

    public int getAportes() {
        return aportes;
    }
}
