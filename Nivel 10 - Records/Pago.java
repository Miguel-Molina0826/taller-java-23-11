public sealed interface Pago permits Efectivo, Tarjeta, Billetera {
    // Interfaz sellada: el compilador conoce exhaustivamente todas las implementaciones
    int valor();
}
