import java.util.List;

public class ReporteDiario {
    // Ensambla responsabilidades sin acoplarse a detalles
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Formato formato, Destino destino) {
        this.formato = formato;
        this.destino = destino;
    }

    public void generar(List<Integer> ventas) {
        Totales t = new Totales(ventas);
        String texto = formato.dar(t.getTotalRecaudado(), t.getCantidadVentas());
        destino.enviar(texto);
    }
}
