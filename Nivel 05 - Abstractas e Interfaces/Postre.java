public class Postre extends Producto {
    public Postre(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public int minutosPreparacion() {
        return 1; // Un postre solo se saca de vitrina
    }
}
