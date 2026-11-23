public record LineaRecibo(String producto, int precio, int cantidad) {
    // Constructor compacto: valida datos antes de la asignación automática
    public LineaRecibo {
        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException("Producto requerido");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad mínima: 1");
        }
    }

    // Método de cálculo adicional dentro del record
    public int subtotal() {
        return precio * cantidad;
    }
}
