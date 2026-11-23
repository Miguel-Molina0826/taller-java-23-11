import java.io.Serializable;

public record Insumo(int id, String nombre, int cantidad) implements Serializable {
    public Insumo {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa: " + cantidad);
        }
    }
}
