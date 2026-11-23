import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Identificable> {
    // T acotado superiormente: garantiza que T implementa Identificable
    private final List<T> items = new ArrayList<>();

    public void guardar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("No se puede guardar un elemento nulo");
        }
        items.add(item);
    }

    public T porId(int id) {
        for (T item : items) {
            if (item.id() == id) {
                return item;
            }
        }
        throw new IllegalArgumentException("No existe el id " + id);
    }

    public int cantidad() {
        return items.size();
    }

    public List<T> todos() {
        return List.copyOf(items);
    }
}
