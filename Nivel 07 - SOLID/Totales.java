import java.util.List;

public class Totales {
    // SRP: cálculo numérico puro de totales y ventas
    private final int totalRecaudado;
    private final int cantidadVentas;

    public Totales(List<Integer> ventas) {
        int sum = 0;
        for (int v : ventas) sum += v;
        this.totalRecaudado = sum;
        this.cantidadVentas = ventas.size();
    }

    public int getTotalRecaudado() { return totalRecaudado; }
    public int getCantidadVentas() { return cantidadVentas; }
}
