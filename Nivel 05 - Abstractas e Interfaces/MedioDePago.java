public interface MedioDePago {
    // Contrato puro: define qué operaciones son obligatorias sin dictar el cómo
    String nombre();
    boolean pagar(int valor);
}
