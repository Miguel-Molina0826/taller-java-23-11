public class FormatoTexto implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "REPORTE DIARIO\nVentas: " + ventas + "\nTotal: $" + total;
    }
}
