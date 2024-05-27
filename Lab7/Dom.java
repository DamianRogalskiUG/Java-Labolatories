import java.time.LocalDate;

public final class Dom extends Lokum {
    private int powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, int powierzchnia, int cena, LocalDate dataObowiazywaniaOferty, int powierzchniaDzialki) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }
    

    public int getPowierzchniaDzialki() {
        return powierzchniaDzialki;
    }


    @Override
    public String toString() {
        return "Dom{" +
                "ulica='" + getUlica() + '\'' +
                ", numerDomu=" + getNumerDomu() +
                ", miejscowosc='" + getMiejscowosc() + '\'' +
                ", kodPocztowy='" + getKodPocztowy() + '\'' +
                ", powierzchnia=" + getPowierzchnia() +
                ", cena=" + getCena() +
                ", dataObowiazywaniaOferty=" + getDataObowiazywaniaOferty() +
                ", powierzchniaDzialki=" + getPowierzchniaDzialki() +
                '}';
    }
}
