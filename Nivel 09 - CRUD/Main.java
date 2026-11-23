import java.util.List;

void main() {
    IO.println("=== CAFÉ SINTAXIS · NIVEL 09: CRUD CON ARRAYLIST ===");

    // 1. Demostración de las 4 operaciones CRUD de Inventario (Sesión 03)
    IO.println("--- 1. Pruebas de CRUD con Inventario ---");
    Inventario inv = new Inventario();

    // C · Crear
    inv.crear("Leche entera (L)", 12);
    inv.crear("Café en grano (kg)", 5);
    inv.crear("Avena (L)", 3);
    IO.println("1 Listado inicial: " + inv.listar());

    // R · Leer
    IO.println("2 Buscar ID 2: " + inv.buscar(2).orElseThrow());
    IO.println("3 ¿Existe ID 9? " + inv.buscar(9).isPresent());

    // U · Actualizar
    inv.actualizar(1, 20);
    IO.println("4 Actualizado ID 1 a 20: " + inv.buscar(1).get());

    // D · Eliminar
    inv.eliminar(3);
    IO.println("5 Tras eliminar ID 3: " + inv.listar());

    // Métodos SequencedCollections de Java 21/25
    var lista = inv.listar();
    IO.println("6 Primero: " + lista.getFirst() + " · Último: " + lista.getLast());
    IO.println("7 ¿Existe café? " + inv.existe("Café en grano (kg)"));

    // 2. Demostración de Agenda de Reservas (Sesión 07)
    IO.println("\n--- 2. Pruebas de CRUD con Agenda de Reservas ---");
    Agenda agenda = new Agenda();
    agenda.crear("Valeria", 4, "19:00");
    agenda.crear("Martín", 2, "18:30");
    agenda.crear("Ana", 6, "20:00");
    agenda.crear("Julián", 3, "18:30");

    IO.println("Listado ordenado por hora: " + agenda.listar());
    IO.println("Reservas de las 18:30: " + agenda.deLaHora("18:30"));

    agenda.cambiarHora(1, "21:00");
    IO.println("Tras cambiar hora de reserva #1: " + agenda.buscar(1).get());

    agenda.cancelar(2);
    IO.println("Tras cancelar reserva #2: " + agenda.listar());
}
