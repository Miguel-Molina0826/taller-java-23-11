public class Reserva implements Comparable<Reserva> {
    private final int id;
    private final String cliente;
    private final int personas;
    private String hora; // formato "18:30"

    public Reserva(int id, String cliente, int personas, String hora) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente obligatorio");
        }
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException("Personas debe ser entre 1 y 8: " + personas);
        }
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("Hora obligatoria");
        }
        this.id = id;
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public int getPersonas() { return personas; }
    public String getHora() { return hora; }

    public void setHora(String hora) {
        if (hora == null || hora.isBlank()) {
            throw new IllegalArgumentException("Hora inválida");
        }
        this.hora = hora;
    }

    @Override
    public int compareTo(Reserva otra) {
        return this.hora.compareTo(otra.hora);
    }

    @Override
    public String toString() {
        return "Reserva #" + id + ": " + cliente + " (" + personas + "p) a las " + hora;
    }
}
