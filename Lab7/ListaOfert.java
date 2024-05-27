import java.util.ArrayList;
import java.util.function.Predicate;


public class ListaOfert {
    private ArrayList<Lokum> ofertyLokum;

    public ListaOfert() {
        ofertyLokum = new ArrayList<>();
    }

    public void dodajOferteDomu(Dom dom) {
        ofertyLokum.add(dom);
    }

    public void dodajOferteMieszkania(Mieszkanie mieszkanie) {
        ofertyLokum.add(mieszkanie);
    }

    public ArrayList<Lokum> wyswietlOferty(Predicate<Lokum> warunek) {
        ArrayList<Lokum> ofertyDoWyswietlenia = new ArrayList<>();
            for (Lokum oferta : ofertyLokum) {
                if (warunek.test(oferta)) {
                    ofertyDoWyswietlenia.add(oferta);
                }
            }
        return ofertyDoWyswietlenia;
    }

}
