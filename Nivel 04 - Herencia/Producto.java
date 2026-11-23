public class Producto {
    // Campos privados accesibles mediante getters
    private final String nombre;
    private final int precio;

    public Producto(String nombre, int precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }

    public String descripcion() {
        return nombre + " $" + precio;
    }
}
