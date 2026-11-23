void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 01: CLASES ===");

    // 1. Demostración de Producto (Sesión 03)
    IO.println("--- 1. Pruebas con Producto ---");
    Producto latte = new Producto();
    latte.nombre = "Latte";
    latte.precio = 9500;
    latte.stock = 3;

    Producto brownie = new Producto();
    brownie.nombre = "Brownie";
    brownie.precio = 7000;
    // brownie.stock queda en 0 por defecto

    IO.println(latte.descripcion());
    IO.println("¿Hay brownie? " + brownie.hayStock());
    int cobro = latte.vender(2);
    IO.println("Cobrar: $" + cobro);
    IO.println(latte.descripcion());
    latte.vender(5); // Caso límite: pedir más de lo que hay

    // 2. Demostración de Cliente (Sesión 04)
    IO.println("\n--- 2. Pruebas con Cliente ---");
    Cliente sofia = new Cliente();
    sofia.nombre = "Sofía";
    sofia.puntos = 41;
    sofia.sumarPuntos(12500); // Suma 12 puntos (12500 / 1000)
    IO.println(sofia.tarjeta());
    IO.println("¿Café gratis? " + sofia.puedeCanjear());
    sofia.canjear();
    IO.println(sofia.tarjeta());

    // 3. Demostración de Mesa (Sesión 06)
    IO.println("\n--- 3. Pruebas con Mesa ---");
    Mesa m4 = new Mesa();
    m4.numero = 4;
    m4.ocupar(3);
    IO.println(m4.estado());
    m4.liberar();
    IO.println(m4.estado());

    // 4. Demostración de Barista (Sesión 07)
    IO.println("\n--- 4. Pruebas con Barista ---");
    Barista martin = new Barista();
    martin.nombre = "Martín";
    martin.turno = "mañana";
    for (int i = 0; i < 3; i++) {
        martin.preparar("Latte");
    }
    IO.println(martin.resumen());
    IO.println("¿Martín merece pausa? " + martin.merecePausa());

    Barista ana = new Barista();
    ana.nombre = "Ana";
    ana.turno = "tarde";
    for (int i = 0; i < 21; i++) {
        ana.preparar("Capuchino");
    }
    IO.println(ana.resumen());
    IO.println("¿Ana merece pausa (caso límite 21 >= 20)? " + ana.merecePausa());
    ana.recibirPropina(5000);
    ana.recibirPropina(-1000); // Ignora negativa

    // 5. Demostración de Domicilio (Sesión 08)
    IO.println("\n--- 5. Pruebas con Domicilio ---");
    Domicilio dom = new Domicilio();
    dom.direccion = "Carrera 7 # 45-12";
    IO.println(dom.estado());
    dom.despachar();
    IO.println(dom.estado());
}
