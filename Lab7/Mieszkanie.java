import java.time.LocalDate;

public final class Mieszkanie extends Lokum {
    private int numerMieszkania;
    private int pietro;

    public Mieszkanie(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate dataObowiazywaniaOferty, int numerMieszkania, int pietro) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.numerMieszkania = numerMieszkania;
        this.pietro = pietro;
    }

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public int getPietro() {
        return pietro;
    }

    @Override
    public String toString() {
        return "Mieszkanie{" +
                "ulica='" + getUlica() + '\'' +
                ", numerDomu=" + getNumerDomu() +
                ", numerMieszkania=" + getNumerMieszkania() +
                ", pietro=" + getPietro() +
                ", miejscowosc='" + getMiejscowosc() + '\'' +
                ", kodPocztowy='" + getKodPocztowy() + '\'' +
                ", powierzchnia=" + getPowierzchnia() +
                ", cena=" + getCena() +
                ", dataObowiazywaniaOferty=" + getDataObowiazywaniaOferty() +
                '}';
    }
}

