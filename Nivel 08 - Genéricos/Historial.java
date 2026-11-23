import java.util.ArrayList;
import java.util.List;

public class Historial<T extends Comparable<T>> {
    private final int capacidad;
    private final List<T> elementos = new ArrayList<>();

    public Historial(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser mayor a 0");
        }
        this.capacidad = capacidad;
    }

    public void agregar(T elemento) {
        if (elemento == null) return;
        if (elementos.size() >= capacidad) {
            elementos.removeFirst(); // Borra el elemento más viejo
        }
        elementos.add(elemento);
    }

    public T masReciente() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("Historial vacío");
        }
        return elementos.getLast();
    }

    public List<T> todos() {
        return List.copyOf(elementos);
    }

    public T mayor() {
        if (elementos.isEmpty()) {
            throw new IllegalStateException("Historial vacío");
        }
        T max = elementos.getFirst();
        for (T item : elementos) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
