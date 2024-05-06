import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;


public class Kalendarz {

    private ArrayList<ArrayList<Spotkanie>> spotkaniaTygodniowe;

    public Kalendarz() {
        this.spotkaniaTygodniowe = new ArrayList<>(7); 
        for (int i = 0; i < 7; i++) {
            spotkaniaTygodniowe.add(new ArrayList<>()); 
        }
    }

    public void dodajSpotkanie(int dzienTygodnia, Spotkanie spotkanie) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            spotkaniaTygodniowe.get(dzienTygodnia).add(spotkanie);
        }

    }

    public void usunSpotkanie(int dzienTygodnia, String opisSpotkania) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            ArrayList<Spotkanie> spotkania = spotkaniaTygodniowe.get(dzienTygodnia);
            for (int i = 0; i < spotkania.size(); i++) {
                Spotkanie spotkanie = spotkania.get(i);
                if (spotkanie.getOpis().equals(opisSpotkania)) {
                    spotkania.remove(i);
                }
            }
        }
    }

    public ArrayList<Spotkanie> wyswietlSpotkania(int dzienTygodnia, Predicate<Spotkanie> warunek) {
        ArrayList<Spotkanie> spotkaniaDoWyswietlenia = new ArrayList<>();
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            ArrayList<Spotkanie> spotkania = spotkaniaTygodniowe.get(dzienTygodnia);
            for (Spotkanie spotkanie : spotkania) {
                if (warunek.test(spotkanie)) {
                    spotkaniaDoWyswietlenia.add(spotkanie);
                }
            }
        }
        return spotkaniaDoWyswietlenia;
    }
    
}
