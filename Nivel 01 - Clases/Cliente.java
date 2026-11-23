public class Cliente {
    // Atributos: lo que cada cliente sabe de sí mismo
    String nombre;
    int puntos;

    // Métodos: lo que cada cliente hace con su tarjeta de puntos
    // 1 punto por cada $1000 de compra (división entera)
    void sumarPuntos(int compra) {
        puntos = puntos + compra / 1000;
    }

    boolean puedeCanjear() {
        return puntos >= 50;
    }

    void canjear() {
        if (puedeCanjear()) {
            puntos = puntos - 50;
            IO.println(nombre + " canjeó 50 puntos por un café.");
        } else {
            IO.println(nombre + " no tiene suficientes puntos para canjear (mínimo 50).");
        }
    }

    String tarjeta() {
        return nombre + ": " + puntos + " puntos";
    }
}
