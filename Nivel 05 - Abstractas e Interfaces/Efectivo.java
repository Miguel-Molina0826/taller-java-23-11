public class Efectivo implements MedioDePago {
    @Override
    public String nombre() {
        return "Efectivo";
    }

    @Override
    public boolean pagar(int valor) {
        // El efectivo siempre se recibe en caja física
        return valor > 0;
    }
}
