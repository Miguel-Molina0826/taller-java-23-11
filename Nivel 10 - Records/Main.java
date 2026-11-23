import java.util.List;

String procesarPago(Pago pago) {
    return switch (pago) {
        case Efectivo(var v) -> "Efectivo directo: $" + v;
        case Tarjeta(var v, var c) when c > 1 -> "Tarjeta crédito a " + c + " cuotas por $" + v;
        case Tarjeta(var v, var c) -> "Tarjeta débito por $" + v;
        case Billetera(var v, var app) -> "Billetera digital (" + app + ") por $" + v;
    };
}

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 10: RECORDS Y PATTERN MATCHING ===");

    // 1. Demostración de LineaRecibo y Recibo inmutable (Sesión 03)
    IO.println("--- 1. Pruebas con Records de Recibo ---");
    var l1 = new LineaRecibo("Latte", 9500, 2);
    var l2 = new LineaRecibo("Brownie", 7000, 1);

    IO.println("toString generado automáticamente: " + l1);
    IO.println("Acceso directo a componentes: " + l1.producto() + " → $" + l1.subtotal());

    var otra = new LineaRecibo("Latte", 9500, 2);
    IO.println("¿Son iguales por datos (equals)? " + l1.equals(otra));

    var r = new Recibo(1001, List.of(l1, l2));
    IO.println("Recibo #" + r.numero() + " · Total: $" + r.total());

    // Pattern Matching para Records con deconstrucción de variables
    if (r.lineas().getFirst() instanceof LineaRecibo(var p, var precio, var c)) {
        IO.println("Deconstrucción de primera línea: " + c + " × " + p + " a $" + precio);
    }

    // 2. Demostración de Interfaces Selladas y Switch con Patrones (Sesión 04)
    IO.println("\n--- 2. Pruebas con Pagos y Jerarquía Sellada ---");
    List<Pago> pagos = List.of(
        new Efectivo(26000),
        new Tarjeta(50000, 3),
        new Tarjeta(15000, 1),
        new Billetera(12000, "Nequi")
    );

    for (Pago p : pagos) {
        IO.println(procesarPago(p));
    }

    // 3. Demostración de Calificacion (Sesión 06)
    IO.println("\n--- 3. Pruebas con Calificación ---");
    var cal = new Calificacion("Sofía", 5);
    IO.println("Calificación: " + cal.cliente() + " dio " + cal.estrellas() + " estrellas");
    try {
        new Calificacion("Martín", 6);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazada calificación: " + e.getMessage());
    }

    // 4. Demostración de Menú del Día e Inmutabilidad (Sesión 07)
    IO.println("\n--- 4. Pruebas con Menú del Día Inmutable ---");
    var item1 = new ItemMenu("Latte Vainilla", "Bebida", 10000);
    var item2 = new ItemMenu("Croissant Francés", "Panadería", 6500);

    var menu = new MenuDelDia("2026-11-21", List.of(item1, item2));
    IO.println("Promedio del menú del día: $" + menu.promedioPrecio());

    // Crear nueva versión sin mutar
    var itemActualizado = item1.conPrecio(11000);
    IO.println("Ítem original: " + item1);
    IO.println("Ítem nuevo tras conPrecio: " + itemActualizado);
    IO.println("¿El original cambió? " + item1.equals(itemActualizado));

    // 5. Demostración de Propina (Sesión 08)
    IO.println("\n--- 5. Pruebas con Propina ---");
    var propina = new Propina("Martín", 5000);
    IO.println("Propina registrada: " + propina);
}
