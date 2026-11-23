public class Mesa {
    // Atributos del estado de la mesa en salón
    int numero;
    int personas;
    boolean ocupada;

    // Métodos de comportamiento de la mesa
    void ocupar(int cuantas) {
        personas = cuantas;
        ocupada = true;
    }

    void liberar() {
        personas = 0;
        ocupada = false;
    }

    String estado() {
        if (ocupada) {
            return "Mesa " + numero + " ocupada por " + personas;
        }
        return "Mesa " + numero + " libre";
    }
}
