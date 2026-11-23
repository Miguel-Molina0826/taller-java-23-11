public class Bebida extends Producto implements Personalizable {
    public Bebida(String nombre, int precio) {
        super(nombre, precio);
    }

    @Override
    public int minutosPreparacion() {
        return 4; // Las bebidas toman 4 minutos en barra
    }

    @Override
    public int extra(String opcion) {
        if (opcion != null && opcion.equals("shot extra")) {
            return 2000;
        }
        return 1500; // Por defecto adicional (ej. leche vegetal)
    }
}
