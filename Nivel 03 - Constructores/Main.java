void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 03: CONSTRUCTORES ===");

    // 1. Demostración de Bebida y prólogos (Sesión 03)
    IO.println("--- 1. Pruebas con Bebida ---");
    Bebida a = new Bebida("Latte", "grande", 11000, true);
    Bebida b = new Bebida("Tinto", 3500);

    IO.println(a.descripcion());
    IO.println(b.descripcion());
    IO.println("Latte + 2 extras: $" + a.precioCon(2));
    IO.println("Con cupón: $" + a.precioCon("CAFE10"));

    try {
        new Bebida(" ", 3000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazada: " + e.getMessage());
    }

    // 2. Demostración de Reserva (Sesión 04)
    IO.println("\n--- 2. Pruebas con Reserva ---");
    Reserva r1 = new Reserva("Valeria", 4, 20);
    Reserva r2 = new Reserva("Carlos", 2); // Hora 18 por defecto
    IO.println(r1.resumen());
    IO.println(r2.resumen());

    // 3. Demostración de Postre (Sesión 06)
    IO.println("\n--- 3. Pruebas con Postre ---");
    Postre p1 = new Postre("Torta de chocolate", 8500, 450);
    Postre p2 = new Postre("Muffin de arándanos", 6000);
    IO.println(p1.descripcion());
    IO.println(p2.descripcion());

    // 4. Demostración de Combo (Sesión 07)
    IO.println("\n--- 4. Pruebas con Combo ---");
    Combo c1 = new Combo("Capuchino", "Galleta", 12000);
    Combo c2 = new Combo("Espresso", 5000);
    IO.println(c1.resumen());
    IO.println("Combo 1 con 10% propina: $" + c1.precioFinal(10));
    IO.println(c2.resumen());

    // 5. Demostración de Domicilio (Sesión 08)
    IO.println("\n--- 5. Pruebas con Domicilio ---");
    Domicilio d1 = new Domicilio("Calle 100 # 15-20", 6000);
    Domicilio d2 = new Domicilio("Av. Santander # 54-10");
    IO.println(d1.resumen());
    IO.println(d2.resumen());
}
