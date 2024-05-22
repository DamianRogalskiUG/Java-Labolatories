import java.time.LocalTime;

public final class Spotkanie extends Aktywnosc {
    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
    private String priorytet;
    
    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String priorytet) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.priorytet = priorytet;
    }

    public String getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie: " + getOpis() + ", Czas rozpoczęcia: " + getCzasPoczatku() + ", Czas zakończenia: " + getCzasZakonczenia() + ", Priorytet: " + getPriorytet();
    }
}
