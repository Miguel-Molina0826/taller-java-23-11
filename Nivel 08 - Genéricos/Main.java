import java.util.List;

// Métodos genéricos
<T> T ultimo(List<T> lista) {
    if (lista == null || lista.isEmpty()) {
        throw new IllegalArgumentException("Lista vacía");
    }
    return lista.getLast();
}

int sumarPrecios(List<? extends Producto> lista) {
    // Comodín con límite superior (lectura covariante)
    int s = 0;
    for (Producto p : lista) s += p.getPrecio();
    return s;
}

<T> int contar(List<T> lista, T buscado) {
    int c = 0;
    for (T item : lista) {
        if (item.equals(buscado)) c++;
    }
    return c;
}

int sumar(List<? extends Number> lista) {
    int s = 0;
    for (Number n : lista) {
        s += n.intValue();
    }
    return s;
}

<T> List<T> primeros(List<T> lista, int n) {
    if (lista == null) return List.of();
    int limite = Math.min(n, lista.size());
    return lista.subList(0, limite);
}

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 08: GENÉRICOS ===");

    // 1. Demostración de Repositorio<T extends Identificable> (Sesión 03)
    IO.println("--- 1. Pruebas con Repositorio Genérico Acotado ---");
    var productos = new Repositorio<Producto>();
    productos.guardar(new Producto(1, "Latte", 9500));
    productos.guardar(new Producto(2, "Brownie", 7000));

    var clientes = new Repositorio<Cliente>();
    clientes.guardar(new Cliente(7, "Sofía"));
    clientes.guardar(new Cliente(8, "Carlos"));

    // Sin casts: el compilador garantiza que sale un Producto
    Producto p = productos.porId(2);
    IO.println(p.getNombre() + " $" + p.getPrecio());
    IO.println(clientes.porId(7).nombre());

    // 2. Demostración de Métodos Genéricos y Comodines (Sesión 03 y 04)
    IO.println("\n--- 2. Pruebas con Métodos Genéricos y Comodines (? extends) ---");
    IO.println("Última bebida: " + ultimo(List.of("tinto", "latte", "moka")));

    var vitrina = List.of(
        new Producto(3, "Té", 4000),
        new Producto(4, "Moka", 10500)
    );
    IO.println("Total vitrina: $" + sumarPrecios(vitrina));

    // 3. Demostración de Bandeja<T> (Sesión 06)
    IO.println("\n--- 3. Pruebas con Bandeja Genérica ---");
    Bandeja<String> bandeja = new Bandeja<>();
    bandeja.poner("Latte mediano");
    bandeja.poner("Croissant caliente");
    IO.println("¿Bandeja vacía? " + bandeja.vacia());
    IO.println("Tomando: " + bandeja.tomar());
    IO.println("Tomando: " + bandeja.tomar());
    IO.println("¿Bandeja vacía ahora? " + bandeja.vacia());

    // 4. Demostración de Historial<T> (Sesión 07)
    IO.println("\n--- 4. Pruebas con Historial con Límite de Capacidad ---");
    Historial<Integer> cobros = new Historial<>(3);
    cobros.agregar(9500);
    cobros.agregar(7000);
    cobros.agregar(12000);
    cobros.agregar(3500); // Se descarta 9500 (el más viejo)

    IO.println("Cobros en historial (últimos 3): " + cobros.todos());
    IO.println("Más reciente: $" + cobros.masReciente());
    IO.println("Mayor cobro: $" + cobros.mayor());
    IO.println("Suma total de cobros con comodín: $" + sumar(cobros.todos()));

    // 5. Demostración de primeros(l, n) y contar (Sesión 08)
    IO.println("\n--- 5. Pruebas de primeros() y contar() ---");
    List<String> pedidos = List.of("Latte", "Tinto", "Latte", "Capuchino", "Latte");
    IO.println("Veces que pidieron Latte: " + contar(pedidos, "Latte"));
    IO.println("Primeros 2 pedidos: " + primeros(pedidos, 2));
}
