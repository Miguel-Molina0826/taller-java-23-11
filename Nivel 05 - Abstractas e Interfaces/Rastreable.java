public interface Rastreable {
    String estado();

    default boolean entregado() {
        return "entregado".equalsIgnoreCase(estado());
    }
}
