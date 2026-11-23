import java.io.Serializable;

public record Reserva(int id, String cliente, int personas, String hora) implements Serializable {
    public Reserva {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente obligatorio");
        }
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Capacidad de mesa entre 1 y 8 personas");
        }
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("Hora obligatoria");
        }
    }
}
