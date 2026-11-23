public interface Descontable {
    int precioBase();

    default int conDescuento(int pct) {
        if (pct < 0 || pct > 100) {
            throw new IllegalArgumentException("Porcentaje inválido");
        }
        return precioBase() * (100 - pct) / 100;
    }
}
