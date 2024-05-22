import java.time.LocalTime;

public final class Zadanie extends Aktywnosc {
    public static final LocalTime MIN_CZAS = LocalTime.of(9, 0);
    private String status;

    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, String status) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Zadanie: " + getOpis() + ", Czas rozpoczęcia: " + getCzasPoczatku() + ", Czas zakończenia: " + getCzasZakonczenia() + ", Priorytet: " + getStatus();
    }
}
