public class Termo {
    // Atributo privado de capacidad disponible
    private int ml;

    public Termo(int capacidadInicial) {
        if (capacidadInicial < 0) {
            throw new IllegalArgumentException("Capacidad inválida");
        }
        this.ml = capacidadInicial;
    }

    public int getMl() {
        return ml;
    }

    public void recargar(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Recarga inválida");
        }
        this.ml += cantidad;
    }

    public void servir(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad a servir inválida");
        }
        if (cantidad > ml) {
            throw new IllegalArgumentException("No hay suficiente café: quedan " + ml + " ml");
        }
        this.ml -= cantidad;
    }
}
