import java.util.ArrayList;
import java.util.List;

public class DestinoMemoria implements Destino {
    private final List<String> enviados = new ArrayList<>();

    @Override
    public void enviar(String contenido) {
        enviados.add(contenido);
    }

    public List<String> getEnviados() { return List.copyOf(enviados); }
}
