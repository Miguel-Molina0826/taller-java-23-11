public record Calificacion(String cliente, int estrellas) {
    public Calificacion {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente obligatorio");
        }
        if (estrellas < 1 || estrellas > 5) {
            throw new IllegalArgumentException("Estrellas debe estar entre 1 y 5: " + estrellas);
        }
    }
}
