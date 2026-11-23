public class Reserva {
    private final String cliente;
    private final int personas;
    private final int hora; // formato 24h, ej. 18

    // Constructor completo
    public Reserva(String cliente, int personas, int hora) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Cliente requerido");
        }
        if (personas <= 0) {
            throw new IllegalArgumentException("Personas debe ser mayor a 0");
        }
        if (hora < 6 || hora > 22) {
            throw new IllegalArgumentException("Hora fuera de servicio: " + hora);
        }
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    // Constructor sobrecargado con hora por defecto (18:00)
    public Reserva(String cliente, int personas) {
        this(cliente, personas, 18);
    }

    public String getCliente() { return cliente; }
    public int getPersonas() { return personas; }
    public int getHora() { return hora; }

    public String resumen() {
        return "Reserva: " + cliente + " · " + personas + " personas a las " + hora + ":00";
    }
}
