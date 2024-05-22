import java.time.LocalTime;

public sealed abstract class Aktywnosc permits Spotkanie, Zadanie {
    private final String opis;
    private final LocalTime czasPoczatku;
    private final LocalTime czasZakonczenia;
    
    public Aktywnosc(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
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
}
