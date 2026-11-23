public abstract class Producto {
    // Plantilla abstracta: no se puede instanciar directamente con new
    private final String nombre;
    private final int precio;

    protected Producto(String nombre, int precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("Precio inválido: " + precio);
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }

    // Método abstracto: hueco obligatorio que toda subclase concreta debe implementar
    public abstract int minutosPreparacion();

    // Método concreto común a todos los productos
    public String ficha() {
        return nombre + " $" + precio + " · " + minutosPreparacion() + " min";
    }
}
