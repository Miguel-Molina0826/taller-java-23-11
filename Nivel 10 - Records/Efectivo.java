public record Efectivo(int valor) implements Pago {
    public Efectivo {
        if (valor <= 0) throw new IllegalArgumentException("Valor positivo requerido");
    }
}
