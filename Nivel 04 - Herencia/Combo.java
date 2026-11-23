public class Combo {
    // Composición: un combo contiene un producto principal y un acompañante
    private final Producto principal;
    private final Producto acompanante;

    public Combo(Producto principal, Producto acompanante) {
        if (principal == null || acompanante == null) {
            throw new IllegalArgumentException("Ambos productos son obligatorios en el combo");
        }
        this.principal = principal;
        this.acompanante = acompanante;
    }

    public int precio() {
        int suma = principal.getPrecio() + acompanante.getPrecio();
        return suma * 90 / 100; // 10 % de descuento por combo
    }

    public String descripcion() {
        return "Combo: " + principal.getNombre() + " + " + acompanante.getNombre() + " = $" + precio();
    }
}
