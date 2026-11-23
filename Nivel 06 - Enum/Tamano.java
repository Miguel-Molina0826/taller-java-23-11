public enum Tamano {
    // Lista cerrada de constantes con sus argumentos para el constructor
    PEQUENO(240, 0),
    MEDIANO(350, 1500),
    GRANDE(470, 2800);

    private final int ml;
    private final int recargo;

    // Constructor privado del enum
    Tamano(int ml, int recargo) {
        this.ml = ml;
        this.recargo = recargo;
    }

    public int ml() { return ml; }
    public int recargo() { return recargo; }
}
