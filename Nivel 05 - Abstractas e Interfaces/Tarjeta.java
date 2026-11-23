public class Tarjeta implements MedioDePago {
    private final String banco;
    private final int saldoDisponible;

    public Tarjeta(String banco, int saldoDisponible) {
        this.banco = banco;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String nombre() {
        return "Tarjeta (" + banco + ")";
    }

    @Override
    public boolean pagar(int valor) {
        // Cobra 2% de comisión
        int totalConComision = valor + (valor * 2 / 100);
        return totalConComision <= saldoDisponible;
    }
}
