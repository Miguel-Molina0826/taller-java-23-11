public class Domicilio extends Entrega implements Rastreable {
    private final int kilometros;
    private String estadoActual;

    public Domicilio(int pedidoId, int kilometros) {
        super(pedidoId);
        this.kilometros = kilometros;
        this.estadoActual = "en camino";
    }

    @Override
    public int costo() {
        return 2000 + (800 * kilometros);
    }

    public void avanzar() {
        this.estadoActual = "entregado";
    }

    @Override
    public String estado() {
        return estadoActual;
    }
}
