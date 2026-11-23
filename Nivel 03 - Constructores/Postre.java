public class Postre {
    // Atributos inmutables
    private final String nombre;
    private final int precio;
    private final int calorias;

    // Constructor completo
    public Postre(String nombre, int precio, int calorias) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Sin nombre");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido: " + precio);
        }
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
    }

    // Constructor corto con prólogo (Java 25)
    public Postre(String nombre, int precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Sin nombre");
        }
        this(nombre, precio, 250); // Calorías por defecto: 250
    }

    public String descripcion() {
        return nombre + " · $" + precio + " (" + calorias + " cal)";
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
    public int getCalorias() { return calorias; }
}
