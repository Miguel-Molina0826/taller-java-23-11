public enum EstadoPedido {
    RECIBIDO,
    EN_PREPARACION,
    LISTO,
    ENTREGADO;

    // Transición de estados mediante switch de flechas moderno de Java
    public EstadoPedido siguiente() {
        return switch (this) {
            case RECIBIDO -> EN_PREPARACION;
            case EN_PREPARACION -> LISTO;
            case LISTO, ENTREGADO -> ENTREGADO; // El estado final se queda en sí mismo
        };
    }
}
