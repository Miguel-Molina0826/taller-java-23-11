import java.util.ArrayList;
import java.util.List;

public class Bandeja<T> {
    // Clase genérica sin acotar: sirve para transportar cualquier tipo de objeto
    private final List<T> items = new ArrayList<>();

    public void poner(T item) {
        if (item != null) {
            items.add(item);
        }
    }

    public T tomar() {
        if (items.isEmpty()) {
            throw new IllegalStateException("La bandeja está vacía");
        }
        return items.removeLast();
    }

    public boolean vacia() {
        return items.isEmpty();
    }

    public int cantidad() {
        return items.size();
    }
}
