public class Barista extends Empleado {
    private final int bebidas;

    public Barista(String nombre, int salarioBase, int bebidas) {
        super(nombre, salarioBase);
        this.bebidas = Math.max(0, bebidas);
    }

    @Override
    public int pago() {
        // Bono de $200 por cada bebida preparada
        return super.pago() + bebidas * 200;
    }
}
