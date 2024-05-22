import java.time.LocalTime;
import java.util.ArrayList;

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

    public void wyswietlSpotkaniaDanegoDnia(int dzienTygodnia) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            for (Spotkanie spotkanie : spotkaniaTygodniowe.get(dzienTygodnia)) {
                System.out.println(spotkanie);
            }
        }
    }

    public void wyswietlSpotkaniaOPriorytecie(int dzienTygodnia, int priorytet) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            for (Spotkanie spotkanie : spotkaniaTygodniowe.get(dzienTygodnia)) {
                if (spotkanie.getPriorytet() == priorytet) {
                    System.out.println(spotkanie);
                }
            }
        }
    }

    public void wyswietlSpotkaniaOdCzasu(int dzienTygodnia, LocalTime czas) {
        if (dzienTygodnia >= 0 && dzienTygodnia < 7) {
            for (Spotkanie spotkanie : spotkaniaTygodniowe.get(dzienTygodnia)) {
                if (!spotkanie.getCzasPoczatku().isBefore(czas)) {
                    System.out.println(spotkanie);
                }
            }
        }
    }
    
}
