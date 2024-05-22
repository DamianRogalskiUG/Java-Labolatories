import java.util.ArrayList;
import java.util.function.Predicate;


public class Kalendarz {

    private ArrayList<ArrayList<Aktywnosc>> aktywnosciTygodniowe;

    public Kalendarz() {
        this.aktywnosciTygodniowe = new ArrayList<>(7); 
        for (int i = 0; i < 7; i++) {
            aktywnosciTygodniowe.add(new ArrayList<>()); 
        }
    }

    public void dodajAktywnosc(int dzienTygodnia, Aktywnosc aktywnosc) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            aktywnosciTygodniowe.get(dzienTygodnia).add(aktywnosc);
        }

    }

    public void usunAktywnosc(int dzienTygodnia, String opisAktywnosci) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            ArrayList<Aktywnosc> aktywnosci = aktywnosciTygodniowe.get(dzienTygodnia);
            for (int i = 0; i < aktywnosci.size(); i++) {
                Aktywnosc aktywnosc = aktywnosci.get(i);
                if (aktywnosc.getOpis().equals(opisAktywnosci)) {
                    aktywnosci.remove(i);
                }
            }
        }
    }

    public ArrayList<Aktywnosc> wyswietlAktywnosci(int dzienTygodnia, Predicate<Aktywnosc> warunek) {
        ArrayList<Aktywnosc> aktywnosciDoWyswietlenia = new ArrayList<>();
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            ArrayList<Aktywnosc> aktywnosci = aktywnosciTygodniowe.get(dzienTygodnia);
            for (Aktywnosc aktywnosc : aktywnosci) {
                if (warunek.test(aktywnosc)) {
                    aktywnosciDoWyswietlenia.add(aktywnosc);
                }
            }
        }
        return aktywnosciDoWyswietlenia;
    }
    
}
