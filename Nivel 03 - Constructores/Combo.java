public class Combo {
    private final String bebida;
    private final String postre;
    private final int precio;

    // Constructor completo
    public Combo(String bebida, String postre, int precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio de combo inválido: " + precio);
        }
        if (bebida == null || bebida.isBlank()) {
            throw new IllegalArgumentException("Bebida requerida en el combo");
        }
        this.bebida = bebida;
        this.postre = postre;
        this.precio = precio;
    }

    // Constructor corto con prólogo de Java 25
    public Combo(String bebida, int precio) {
        if (bebida == null || bebida.isBlank()) {
            throw new IllegalArgumentException("Bebida vacía");
        }
        this(bebida, "sin postre", precio);
    }

    // Sobrecarga de métodos de precio final
    public int precioFinal() {
        return precio;
    }

    public int precioFinal(int propinaPct) {
        if (propinaPct < 0) {
            throw new IllegalArgumentException("Propina inválida");
        }
        return precioFinal() + (precioFinal() * propinaPct / 100);
    }

    public String resumen() {
        return "Combo: " + bebida + " + " + postre + " = $" + precio;
    }
}
