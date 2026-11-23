public interface Formato {
    // OCP: interfaz para agregar cualquier formato de reporte sin tocar las otras clases
    String dar(int total, int ventas);
}
