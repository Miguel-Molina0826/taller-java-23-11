public record Tarjeta(int valor, int cuotas) implements Pago {
    public Tarjeta {
        if (valor <= 0) throw new IllegalArgumentException("Valor positivo requerido");
        if (cuotas < 1) throw new IllegalArgumentException("Mínimo 1 cuota");
    }
}
