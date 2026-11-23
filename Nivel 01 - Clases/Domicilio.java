public class Domicilio {
    // Atributos del servicio de entrega a domicilio
    String direccion;
    boolean entregado;

    void despachar() {
        entregado = true;
        IO.println("Pedido despachado a la dirección: " + direccion);
    }

    String estado() {
        return "Domicilio en " + direccion + " · " + (entregado ? "Entregado" : "Pendiente");
    }
}
