public record ItemMenu(String nombre, String categoria, int precio) {
    public ItemMenu {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio debe ser positivo: " + precio);
        }
    }

    // Método que permite "modificar" devolviendo una nueva instancia inmutable
    public ItemMenu conPrecio(int nuevoPrecio) {
        return new ItemMenu(nombre, categoria, nuevoPrecio);
    }
}
