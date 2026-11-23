public class ImpresoraConsola implements Impresora {
    @Override
    public void imprimir(String texto) {
        IO.println("COMANDA › " + texto);
    }
}
