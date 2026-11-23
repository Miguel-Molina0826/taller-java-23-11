public class Domicilio {
    private final String direccion;
    private final int valor;

    public Domicilio(String direccion, int valor) {
        if (direccion == null || direccion.isBlank()) {
            throw new IllegalArgumentException("Dirección requerida");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("Valor de domicilio no puede ser negativo");
        }
        this.direccion = direccion;
        this.valor = valor;
    }

    // Sobrecarga: domicilio con valor estándar de $4000
    public Domicilio(String direccion) {
        this(direccion, 4000);
    }

    public String getDireccion() { return direccion; }
    public int getValor() { return valor; }

    public String resumen() {
        return "Domicilio a " + direccion + " · Costo de envío: $" + valor;
    }
}
