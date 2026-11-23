public record Propina(String barista, int valor) {
    public Propina {
        if (barista == null || barista.isBlank()) {
            throw new IllegalArgumentException("Barista obligatorio");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo: " + valor);
        }
    }
}
