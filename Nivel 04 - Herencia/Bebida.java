public class Bebida extends Producto {
    private final int ml;

    public Bebida(String nombre, int precio, int ml) {
        super(nombre, precio); // Inicializa los campos del padre
        if (ml <= 0) {
            throw new IllegalArgumentException("Volumen en ml inválido: " + ml);
        }
        this.ml = ml;
    }

    public int getMl() { return ml; }

    @Override
    public String descripcion() {
        return super.descripcion() + " · " + ml + " ml";
    }
}
