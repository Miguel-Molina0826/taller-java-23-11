import java.util.List;

public record Recibo(int numero, List<LineaRecibo> lineas) {
    // Constructor compacto que realiza una copia inmutable defensiva
    public Recibo {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número de recibo inválido: " + numero);
        }
        if (lineas == null || lineas.isEmpty()) {
            throw new IllegalArgumentException("El recibo debe tener al menos una línea");
        }
        lineas = List.copyOf(lineas); // Protege la lista interna contra alteraciones externas
    }

    public int total() {
        int t = 0;
        for (LineaRecibo l : lineas) {
            t += l.subtotal();
        }
        return t;
    }
}
