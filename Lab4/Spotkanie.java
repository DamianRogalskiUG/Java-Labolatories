import java.time.LocalTime;

public class Spotkanie {
    public static final LocalTime minCzas = LocalTime.of(8, 0);
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private int priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, int prioryet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = prioryet;
    }
    public String getOpis() {
        return opis;
    }
    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }
    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }
    public int getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie: " + opis + ", Czas rozpoczęcia: " + czasPoczatku + ", Czas zakończenia: " + czasZakonczenia + ", Priorytet: " + priorytet;
    }
}
