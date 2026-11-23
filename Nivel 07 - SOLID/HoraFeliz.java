public class HoraFeliz implements Descuento {
    @Override
    public int aplicar(int total) {
        // 30 % de descuento, asegurando nunca devolver valor negativo
        return Math.max(0, total * 70 / 100);
    }
}
