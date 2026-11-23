public record Billetera(int valor, String app) implements Pago {
    public Billetera {
        if (valor <= 0) throw new IllegalArgumentException("Valor positivo requerido");
        if (app == null || app.isBlank()) throw new IllegalArgumentException("App requerida");
    }
}
