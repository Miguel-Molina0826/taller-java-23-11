public interface Destino {
    // DIP: abstracción para el destino de entrega del reporte
    void enviar(String contenido);
}
