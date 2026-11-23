public interface Notificador {
    // Principio ISP: interfaz pequeña y específica
    // Principio DIP: abstracción de la cual dependen la caja y los reportes
    void enviar(String destino, String mensaje);
}
