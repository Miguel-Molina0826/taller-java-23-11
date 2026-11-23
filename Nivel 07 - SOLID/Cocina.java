public class Cocina {
    private final Impresora impresora;

    public Cocina(Impresora impresora) {
        this.impresora = impresora;
    }

    public void despachar(String plato) {
        impresora.imprimir("Preparar: " + plato);
    }
}
