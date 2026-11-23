public class Producto {
    // Atributos privados protegidos con encapsulamiento estricto
    private String nombre;
    private int precio;
    private int stock;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio < 0 || precio > 50000) {
            throw new IllegalArgumentException("Precio fuera de rango: " + precio);
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void reponer(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException("Cantidad a reponer inválida: " + unidades);
        }
        this.stock += unidades;
    }

    public int vender(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad a vender inválida: " + cantidad);
        }
        if (cantidad > stock) {
            IO.println("No alcanza: hay " + stock);
            return 0;
        }
        this.stock -= cantidad;
        return cantidad * precio;
    }
}
