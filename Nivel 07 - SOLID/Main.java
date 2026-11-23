import java.util.List;

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 07: PRINCIPIOS SOLID ===");

    // 1. Demostración del código viejo vs código refactorizado (Sesión 02 y 03)
    IO.println("--- 1. Ejecución con CajaVieja (Monolito) ---");
    CajaVieja vieja = new CajaVieja();
    vieja.cobrar(List.of(9500, 10500), "CAFE10", "300 555 0101");
    // Caso de error en caja vieja: fidelidad en compra pequeña
    vieja.cobrar(List.of(1500), "FIDELIDAD", "300 555 0102"); // Da -$500

    IO.println("\n--- 2. Ejecución con Caja Limpia (SOLID) ---");
    // Main ensambla las dependencias (DIP)
    Notificador notificador = new SmsSimulado();
    Caja caja = new Caja(notificador);

    caja.cobrar(List.of(9500, 10500), new Porcentaje(10), "300 555 0101");
    // Caso Liskov solucionado: fidelidad nunca da negativo
    caja.cobrar(List.of(1500), new Fidelidad(), "300 555 0102");
    // Nueva extensión sin tocar Caja: HoraFeliz (OCP)
    caja.cobrar(List.of(20000), new HoraFeliz(), "300 555 0103");

    // 2. Demostración de Cocina e Impresora (Sesión 06)
    IO.println("\n--- 3. Pruebas con Cocina e Impresora ---");
    Cocina cocina = new Cocina(new ImpresoraConsola());
    cocina.despachar("Café Mocha con avena");

    // 3. Demostración de Reporte Diario desacoplado (Sesión 07)
    IO.println("\n--- 4. Pruebas con Reporte Diario (SRP, OCP, DIP) ---");
    List<Integer> ventasDelDia = List.of(9500, 7000, 11000, 3500, 12000);

    // Formato Texto a Consola
    ReporteDiario reporteTexto = new ReporteDiario(new FormatoTexto(), new DestinoConsola());
    reporteTexto.generar(ventasDelDia);

    // Mismo reporte, formato CSV sin tocar Totales ni ReporteDiario
    IO.println("\n--- Exportación a CSV ---");
    ReporteDiario reporteCSV = new ReporteDiario(new FormatoCSV(), new DestinoConsola());
    reporteCSV.generar(ventasDelDia);
}
