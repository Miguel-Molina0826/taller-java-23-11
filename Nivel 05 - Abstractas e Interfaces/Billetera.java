public class Billetera implements MedioDePago {
    private int saldo;

    public Billetera(int saldoInicial) {
        this.saldo = Math.max(0, saldoInicial);
    }

    @Override
    public String nombre() {
        return "Billetera digital";
    }

    @Override
    public boolean pagar(int valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public int getSaldo() { return saldo; }
}
