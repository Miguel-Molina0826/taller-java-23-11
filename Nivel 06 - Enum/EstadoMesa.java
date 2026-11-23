public enum EstadoMesa {
    LIBRE("Disponible para clientes"),
    OCUPADA("Clientes en servicio"),
    POR_LIMPIAR("Requiere desinfección"),
    RESERVADA("Apartada para reserva"),
    FUERA_DE_SERVICIO("Mantenimiento o avería");

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() {
        return aviso;
    }

    public boolean disponible() {
        return this == LIBRE;
    }

    // Switch exhaustivo de flechas sin default (el compilador exige cubrir todos los casos)
    public EstadoMesa siguiente() {
        return switch (this) {
            case LIBRE -> OCUPADA;
            case RESERVADA -> OCUPADA;
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
            case FUERA_DE_SERVICIO -> FUERA_DE_SERVICIO;
        };
    }
}
