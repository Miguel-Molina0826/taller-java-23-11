import java.io.*;
import java.nio.file.*;
import java.util.List;

void main() throws Exception {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 11: SERIALIZACIÓN MODERNA ===");

    // 1. Demostración de Persistencia con Almacen (Sesión 03)
    IO.println("--- 1. Pruebas de Serialización de Bodega ---");
    Path rutaBodega = Path.of("bodega.ser");
    var almacen = new Almacen(rutaBodega);

    IO.println("Al abrir la cafetería: " + almacen.cargar());

    List<Insumo> hoy = List.of(
        new Insumo(1, "Leche entera (L)", 20),
        new Insumo(2, "Café en grano (kg)", 5),
        new Insumo(3, "Avena orgánica (L)", 8)
    );
    almacen.guardar(hoy);

    long bytes = Files.size(rutaBodega);
    IO.println("Guardado en disco: " + bytes + " bytes");

    // Simulando lectura "al día siguiente"
    List<Insumo> leidos = almacen.cargar();
    IO.println("Leído de disco al día siguiente: " + leidos);
    IO.println("¿Objetos exactamente iguales en datos? " + hoy.equals(leidos));

    // 2. Demostración de Turno (Sesión 06)
    IO.println("\n--- 2. Pruebas con Turno Serializable ---");
    Turno t = new Turno("Martín", 45, 15000);
    IO.println("Turno registrado: " + t);

    // 3. Demostración de ArchivoReservas y Exportación CSV (Sesión 07)
    IO.println("\n--- 3. Pruebas con Archivo de Reservas y CSV ---");
    Path rutaReservas = Path.of("reservas.ser");
    Path rutaCSV = Path.of("reservas.csv");
    ArchivoReservas gestorReservas = new ArchivoReservas(rutaReservas);

    List<Reserva> listaReservas = List.of(
        new Reserva(1, "Valeria", 4, "18:00"),
        new Reserva(2, "Julián", 2, "19:30"),
        new Reserva(3, "Carlos", 6, "20:00")
    );
    gestorReservas.guardar(listaReservas);
    IO.println("Reservas serializadas guardadas: " + gestorReservas.cargar());

    gestorReservas.exportarCSV(rutaCSV, listaReservas);
    IO.println("Reservas exportadas a CSV con éxito. Contenido:");
    for (String linea : Files.readAllLines(rutaCSV)) {
        IO.println("  " + linea);
    }

    // 4. Prueba de Seguridad con Filtro de Lista Blanca
    IO.println("\n--- 4. Demostración de Seguridad con Filtro ---");
    try {
        Path rutaMaliciosa = Path.of("test_filtro.ser");
        try (var out = new ObjectOutputStream(Files.newOutputStream(rutaMaliciosa))) {
            out.writeObject("Texto simple no autorizado en filtro de bodega");
        }
        try (var in = new ObjectInputStream(Files.newInputStream(rutaMaliciosa))) {
            in.setObjectInputFilter(ObjectInputFilter.Config.createFilter("Insumo;!*"));
            in.readObject();
        }
    } catch (InvalidClassException e) {
        IO.println("Rechazo de seguridad exitoso por filtro: " + e.getMessage());
    }
}
