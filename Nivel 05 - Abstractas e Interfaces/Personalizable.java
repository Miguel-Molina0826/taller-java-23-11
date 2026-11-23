public interface Personalizable {
    // Contrato de métodos que prometen cumplir las clases que lo firmen
    int extra(String opcion);

    // Método default: provee comportamiento predeterminado en la interfaz
    default String opciones() {
        return "leche de avena, shot extra";
    }
}
