public enum MedioPago {
    EFECTIVO(0),
    TARJETA(2),
    BILLETERA(1);

    private final int comisionPct;

    MedioPago(int comisionPct) {
        this.comisionPct = comisionPct;
    }

    public int comisionPct() {
        return comisionPct;
    }

    public int neto(int valor) {
        return valor - (valor * comisionPct / 100);
    }
}
