void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 02: ENCAPSULAMIENTO ===");

    // 1. Demostración de Caja protegida (Sesión 03)
    IO.println("--- 1. Pruebas con Caja ---");
    Caja caja = new Caja();
    caja.cobrar(19000);
    caja.cobrar(7000);
    IO.println(caja.resumen());
    try {
        caja.cobrar(-500);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    IO.println("Saldo: $" + caja.getSaldo());

    // 2. Demostración de Producto encapsulado (Sesión 04)
    IO.println("\n--- 2. Pruebas con Producto ---");
    Producto latte = new Producto();
    latte.setNombre("Latte");
    latte.setPrecio(9500);
    latte.reponer(10);
    IO.println(latte.getNombre() + " $" + latte.getPrecio() + " · stock: " + latte.getStock());
    try {
        latte.setPrecio(-9500);
    } catch (IllegalArgumentException e) {
        IO.println("Excepción capturada: " + e.getMessage());
    }
    IO.println("Sigue en $" + latte.getPrecio());

    // 3. Demostración de TarjetaRegalo (Sesión 06)
    IO.println("\n--- 3. Pruebas con TarjetaRegalo ---");
    TarjetaRegalo t = new TarjetaRegalo();
    t.recargar(30000);
    IO.println("¿Pagó latte ($9500)? " + t.pagar(9500));
    IO.println("¿Pagó torta ($25000)? " + t.pagar(25000));
    IO.println("Saldo: $" + t.getSaldo());

    // 4. Demostración de BotePropinas (Sesión 07)
    IO.println("\n--- 4. Pruebas con BotePropinas ---");
    BotePropinas bote = new BotePropinas();
    bote.aportar(2000);
    bote.aportar(5000);
    bote.aportar(3500);
    IO.println("Total propinas: $" + bote.getTotal() + " en " + bote.getAportes() + " aportes");
    try {
        bote.aportar(-100);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado aporte negativo: " + e.getMessage());
    }
    int porPersona = bote.repartir(3);
    int sobran = bote.sobrante(3);
    IO.println("Cada uno recibe: $" + porPersona + " · Sobran para el fondo común: $" + sobran);

    // 5. Demostración de Termo (Sesión 08)
    IO.println("\n--- 5. Pruebas con Termo ---");
    Termo termo = new Termo(1000);
    termo.servir(300);
    IO.println("Termo restante: " + termo.getMl() + " ml");
    try {
        termo.servir(800);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado servir en termo: " + e.getMessage());
    }
}
