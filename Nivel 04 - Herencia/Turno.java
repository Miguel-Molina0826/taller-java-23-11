import java.util.ArrayList;
import java.util.List;

public class Turno {
    // Composición: el turno administra una lista de empleados
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregar(Empleado e) {
        if (e != null) {
            empleados.add(e);
        }
    }

    public int totalNomina() {
        int total = 0;
        for (Empleado e : empleados) {
            total += e.pago();
        }
        return total;
    }

    public void imprimirNomina() {
        IO.println("--- Resumen de Nómina del Turno ---");
        for (Empleado e : empleados) {
            IO.println(e.toString());
        }
        IO.println("Total Nómina: $" + totalNomina());
    }
}
