public class Fidelidad implements Descuento {
    @Override
    public int aplicar(int total) {
        // Principio LSP: cumple la promesa de la interfaz evitando totales negativos
        return Math.max(0, total - 2000);
    }
}
