public class Te extends Bebida {
    private final String origen;

    public Te(String nombre, int precio, int ml, String origen) {
        super(nombre, precio, ml);
        this.origen = origen;
    }

    public String getOrigen() { return origen; }

    @Override
    public String descripcion() {
        return super.descripcion() + " · Origen: " + origen;
    }
}
