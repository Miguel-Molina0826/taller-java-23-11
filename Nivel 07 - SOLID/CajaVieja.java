import java.util.List;

public class CajaVieja {
    // Clase "Dios" monolítica previa a SOLID (4 razones de cambio acumuladas)
    public void cobrar(List<Integer> precios, String descuento, String tel) {
        // Razón 1: Cálculo de la suma
        int total = 0;
        for (int p : precios) total += p;

        // Razón 2: Descuentos acoplados con condicionales if-else (rompe OCP y LSP)
        if (descuento.equals("CAFE10")) {
            total = total * 90 / 100;
        } else if (descuento.equals("FIDELIDAD")) {
            total = total - 2000; // Si total < 2000, ¡deja el total negativo! (viola Liskov)
        }

        // Razón 3: Formato visual del ticket (acoplado a la caja)
        IO.println("TICKET · total $" + total);

        // Razón 4: Notificación por canal fijo (acoplado a SMS)
        IO.println("SMS a " + tel + ": gracias");
    }
}
