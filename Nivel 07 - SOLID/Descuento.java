public interface Descuento {
    // Principio OCP: abierto a la extensión (nuevas promociones), cerrado a modificación
    // Principio LSP: el contrato establece que el resultado nunca debe ser negativo
    int aplicar(int total);
}
