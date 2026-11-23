import java.io.Serializable;

public record Turno(String barista, int bebidas, int propinas) implements Serializable {
    public Turno {
        if (barista == null || barista.isBlank()) {
            throw new IllegalArgumentException("Barista requerido");
        }
        if (bebidas < 0 || propinas < 0) {
            throw new IllegalArgumentException("Valores no pueden ser negativos");
        }
    }
}
