public class Bebida {
    // Atributos finales: inmutabilidad tras la construcción
    private final String nombre;
    private final String tamano;
    private final int precio;
    private final boolean leche;

    // Constructor completo canónico
    public Bebida(String nombre, String tamano, int precio, boolean leche) {
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido: " + precio);
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Sin nombre");
        }
        this.nombre = nombre;
        this.tamano = tamano;
        this.precio = precio;
        this.leche = leche;
    }

    // Constructor corto con prólogo de Java 25 (JEP 513)
    public Bebida(String nombre, int precio) {
        // Prólogo: validar argumentos antes de delegar con this(...)
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Sin nombre");
        }
        this(nombre, "mediano", precio, false);
    }

    // Sobrecarga de métodos: precioCon(int) vs precioCon(String)
    public int precioCon(int extras) {
        if (extras < 0) {
            throw new IllegalArgumentException("Extras inválidos");
        }
        return precio + extras * 1500;
    }

    public int precioCon(String cupon) {
        if (cupon != null && cupon.equals("CAFE10")) {
            return precio * 90 / 100; // 10 % de descuento
        }
        return precio;
    }

    public String descripcion() {
        return nombre + " " + tamano + " $" + precio + (leche ? " · con leche" : "");
    }

    public String getNombre() { return nombre; }
    public String getTamano() { return tamano; }
    public int getPrecio() { return precio; }
    public boolean tieneLeche() { return leche; }
}
