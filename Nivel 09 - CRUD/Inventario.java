import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventario {
    private final List<Insumo> insumos = new ArrayList<>();
    private int siguienteId = 1;

    // C · Crear (Create)
    public Insumo crear(String nombre, int cantidad) {
        Insumo i = new Insumo(siguienteId++, nombre, cantidad);
        insumos.add(i);
        return i;
    }

    // R · Leer (Read - Todos los elementos con copia defensiva inmutable)
    public List<Insumo> listar() {
        return List.copyOf(insumos);
    }

    // R · Leer (Read - Búsqueda por ID devolviendo Optional para evitar null)
    public Optional<Insumo> buscar(int id) {
        for (Insumo i : insumos) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // U · Actualizar (Update)
    public boolean actualizar(int id, int cantidad) {
        Optional<Insumo> o = buscar(id);
        if (o.isEmpty()) {
            return false;
        }
        o.get().setCantidad(cantidad);
        return true;
    }

    // D · Eliminar (Delete - Usando removeIf con expresión lambda)
    public boolean eliminar(int id) {
        return insumos.removeIf(i -> i.getId() == id);
    }

    public boolean existe(String nombre) {
        if (nombre == null) return false;
        for (Insumo i : insumos) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public int totalInsumos() {
        return insumos.size();
    }
}
