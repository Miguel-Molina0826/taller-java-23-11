import java.util.List;

public class Caja {
    // Principio DIP: recibe sus dependencias por constructor
    private final Notificador notificador;
    private final Ticket ticket = new Ticket();

    public Caja(Notificador notificador) {
        if (notificador == null) {
            throw new IllegalArgumentException("Notificador requerido");
        }
        this.notificador = notificador;
    }

    public int cobrar(List<Integer> precios, Descuento d, String tel) {
        int total = 0;
        for (int p : precios) total += p;

        total = d.aplicar(total);

        IO.println(ticket.formatear(total));
        notificador.enviar(tel, "gracias");

        return total;
    }
}
