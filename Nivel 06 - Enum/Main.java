import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

void registrar(Map<Categoria, Integer> v, Categoria c, int valor) {
    v.put(c, v.getOrDefault(c, 0) + valor);
}

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 06: ENUM ===");

    // 1. Demostración de Tamano y EstadoPedido (Sesión 03)
    IO.println("--- 1. Pruebas con Tamano de Vaso ---");
    for (Tamano t : Tamano.values()) {
        IO.println(t + ": " + t.ml() + " ml, +$" + t.recargo());
    }

    IO.println("\n--- 2. Pruebas con Transición de Estados de Pedido ---");
    EstadoPedido e = EstadoPedido.RECIBIDO;
    while (e != EstadoPedido.ENTREGADO) {
        e = e.siguiente();
        String aviso = switch (e) {
            case EN_PREPARACION -> "En barra";
            case LISTO -> "¡Listo para recoger!";
            default -> "Entregado";
        };
        IO.println(e.ordinal() + " " + e + " → " + aviso);
    }

    var conteo = new EnumMap<EstadoPedido, Integer>(EstadoPedido.class);
    conteo.put(EstadoPedido.LISTO, 3);
    conteo.put(EstadoPedido.RECIBIDO, 5);
    IO.println("Conteo EnumMap: " + conteo);
    IO.println("Mililitros de GRANDE con valueOf: " + Tamano.valueOf("GRANDE").ml());

    // 2. Demostración de Categoria (Sesión 04)
    IO.println("\n--- 3. Pruebas con Ventas por Categoría ---");
    Map<Categoria, Integer> ventas = new EnumMap<>(Categoria.class);
    registrar(ventas, Categoria.FRIA, 12000);
    registrar(ventas, Categoria.CALIENTE, 9500);
    registrar(ventas, Categoria.CALIENTE, 3500);
    registrar(ventas, Categoria.POSTRE, 7000);

    for (Categoria c : ventas.keySet()) {
        IO.println(c.etiqueta() + ": $" + ventas.get(c));
    }
    for (Categoria c : Categoria.values()) {
        if (!ventas.containsKey(c)) {
            IO.println("Sin ventas: " + c.etiqueta());
        }
    }

    // 3. Demostración de Leche (Sesión 06)
    IO.println("\n--- 4. Pruebas con Leches Vegetales ---");
    for (Leche l : Leche.values()) {
        if (l.vegetal()) {
            IO.println(l + " +$" + l.recargo());
        }
    }

    // 4. Demostración de EstadoMesa (Sesión 07)
    IO.println("\n--- 5. Pruebas con Plano de Mesas del Salón ---");
    EstadoMesa[] mesas = {
        EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.LIBRE, EstadoMesa.RESERVADA,
        EstadoMesa.POR_LIMPIAR, EstadoMesa.OCUPADA, EstadoMesa.LIBRE, EstadoMesa.FUERA_DE_SERVICIO
    };

    EnumMap<EstadoMesa, Integer> plano = new EnumMap<>(EstadoMesa.class);
    for (EstadoMesa em : mesas) {
        plano.put(em, plano.getOrDefault(em, 0) + 1);
    }
    IO.println("Distribución inicial de mesas: " + plano);

    // Avanzar mesas
    for (int i = 0; i < mesas.length; i++) {
        mesas[i] = mesas[i].siguiente();
    }
    plano.clear();
    for (EstadoMesa em : mesas) {
        plano.put(em, plano.getOrDefault(em, 0) + 1);
    }
    IO.println("Distribución tras avanzar un paso: " + plano);

    // 5. Demostración de MedioPago (Sesión 08)
    IO.println("\n--- 6. Pruebas con MedioPago ---");
    for (MedioPago mp : MedioPago.values()) {
        IO.println(mp + " (Comisión: " + mp.comisionPct() + "%) de $50000 -> Neto: $" + mp.neto(50000));
    }
}
