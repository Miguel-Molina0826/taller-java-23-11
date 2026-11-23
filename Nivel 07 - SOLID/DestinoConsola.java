public class DestinoConsola implements Destino {
    @Override
    public void enviar(String contenido) {
        IO.println(contenido);
    }
}
