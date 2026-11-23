import java.util.List;

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 04: HERENCIA Y COMPOSICIÓN ===");

    // 1. Demostración de Herencia y Polimorfismo con Producto (Sesión 03)
    IO.println("--- 1. Pruebas con Vitrina de Productos (Polimorfismo) ---");
    Bebida latte = new Bebida("Latte", 9500, 350);
    Postre torta = new Postre("Torta de zanahoria", 8000, true);
    IO.println(latte.getNombre() + " cuesta " + latte.getPrecio());

    List<Producto> vitrina = List.of(
        latte,
        torta,
        new Producto("Galleta", 3000)
    );

    for (Producto p : vitrina) {
        IO.println(p.descripcion());
    }

    // 2. Demostración de Composición con Pedido (Sesión 04)
    IO.println("\n--- 2. Pruebas con Pedido y Líneas de Pedido ---");
    Pedido p = new Pedido(4);
    p.agregar(new Bebida("Latte", 9500, 350), 2);
    p.agregar(new Postre("Brownie", 7000, false), 1);
    p.imprimir();
    IO.println("Cantidad total de ítems: " + p.cantidadDeItems());

    // 3. Demostración de Temporada y Combo (Sesión 06)
    IO.println("\n--- 3. Pruebas con Temporada y Combo ---");
    Producto ponque = new Temporada("Ponqué de calabaza", 8500, "octubre");
    Combo c = new Combo(new Bebida("Latte", 9500, 350), ponque);
    IO.println(ponque.descripcion());
    IO.println("Combo: $" + c.precio());

    // 4. Demostración de Nómina de Turno (Sesión 07)
    IO.println("\n--- 4. Pruebas con Nómina de Empleados ---");
    Turno turno = new Turno();
    turno.agregar(new Barista("Martín", 50000, 45)); // 50000 + (45 * 200) = 59000
    turno.agregar(new Mesero("Sofía", 45000, 15000)); // 45000 + 15000 = 60000
    turno.imprimirNomina();

    // 5. Demostración de Te (Sesión 08)
    IO.println("\n--- 5. Pruebas con Te ---");
    Te matcha = new Te("Matcha Ceremonial", 12000, 250, "Uji, Japón");
    IO.println(matcha.descripcion());
}
