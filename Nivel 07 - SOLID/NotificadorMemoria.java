import java.util.ArrayList;
import java.util.List;

public class NotificadorMemoria implements Notificador {
    // Permite probar el sistema sin enviar mensajes reales
    private final List<String> mensajes = new ArrayList<>();

    @Override
    public void enviar(String destino, String mensaje) {
        mensajes.add(destino + ": " + mensaje);
    }

    public List<String> getMensajes() {
        return List.copyOf(mensajes);
    }
}
