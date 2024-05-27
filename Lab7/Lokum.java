import java.time.LocalDate;

public sealed abstract class Lokum permits Dom, Mieszkanie {
    private String ulica;
    private int numerDomu;
    private String miejscowosc;
    private String kodPocztowy;
    private int powierzchnia;
    private int cena;
    private LocalDate dataObowiazywaniaOferty;

    public Lokum(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate dataObowiazywaniaOferty) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywaniaOferty = dataObowiazywaniaOferty;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public LocalDate getDataObowiazywaniaOferty() {
        return dataObowiazywaniaOferty;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public int getCena() {
        return cena;
    }
}
