import java.util.List;

public record MenuDelDia(String fecha, List<ItemMenu> items) {
    public MenuDelDia {
        if (fecha == null || fecha.isBlank()) {
            throw new IllegalArgumentException("Fecha obligatoria");
        }
        items = List.copyOf(items); // Inmutabilidad estricta
    }

    public int promedioPrecio() {
        if (items.isEmpty()) return 0;
        int suma = 0;
        for (ItemMenu item : items) {
            suma += item.precio();
        }
        return suma / items.size();
    }
}
