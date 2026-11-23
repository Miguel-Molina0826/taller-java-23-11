public class Ticket {
    // Principio SRP: su única responsabilidad y razón de cambio es formatear el ticket
    public String formatear(int total) {
        return "TICKET · total $" + total;
    }
}
