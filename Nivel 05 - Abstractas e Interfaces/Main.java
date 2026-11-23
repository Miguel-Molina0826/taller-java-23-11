import java.util.List;

String cobrar(MedioDePago medio, int valor) {
    String r = medio.pagar(valor) ? "aprobado" : "rechazado";
    return medio.nombre() + " $" + valor + ": " + r;
}

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 05: ABSTRACTAS E INTERFACES ===");

    // 1. Demostración de Plantilla Abstracta y Contrato (Sesión 03)
    IO.println("--- 1. Pruebas con Menú de Barra ---");
    List<Producto> menu = List.of(
        new Bebida("Capuchino", 9000),
        new Postre("Brownie", 7000)
    );

    for (Producto p : menu) {
        IO.println(p.ficha());
        // Pattern Matching para instanceof en Java moderno
        if (p instanceof Personalizable per) {
            IO.println("  opciones: " + per.opciones());
            IO.println("  avena: +$" + per.extra("avena"));
        }
    }

    // 2. Demostración de Medios de Pago polimórficos (Sesión 04)
    IO.println("\n--- 2. Pruebas con Medios de Pago ---");
    List<MedioDePago> medios = List.of(
        new Efectivo(),
        new Billetera(12000),
        new Tarjeta("Visa", 50000)
    );

    for (MedioDePago m : medios) {
        IO.println(cobrar(m, 9500));
        IO.println(cobrar(m, 9500));
    }

    // 3. Demostración de Descontable y Galleta (Sesión 06)
    IO.println("\n--- 3. Pruebas con Snacks Descontables ---");
    Snack s = new Galleta();
    IO.println(s.nombre() + ": $" + s.precioBase());
    Descontable d = s;
    IO.println("Con 20 %: $" + d.conDescuento(20));

    // 4. Demostración de Entregas y Rastreable (Sesión 07)
    IO.println("\n--- 4. Pruebas con Formas de Entrega ---");
    Domicilio dom = new Domicilio(101, 3);
    List<Entrega> entregas = List.of(
        new EnMesa(102),
        new ParaLlevar(103),
        dom
    );

    for (Entrega e : entregas) {
        IO.println(e.resumen());
        if (e instanceof Rastreable r) {
            IO.println("  Estado: " + r.estado() + " (¿Entregado? " + r.entregado() + ")");
            dom.avanzar();
            IO.println("  Estado tras avanzar: " + r.estado() + " (¿Entregado? " + r.entregado() + ")");
        }
    }
}
