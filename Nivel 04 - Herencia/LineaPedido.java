public class LineaPedido {
    // Composición: la línea de pedido contiene un Producto y una cantidad
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto requerido");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser positiva: " + cantidad);
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public int getCantidad() { return cantidad; }
    public Producto getProducto() { return producto; }

    public String texto() {
        return cantidad + " × " + producto.getNombre() + " = $" + subtotal();
    }
}
