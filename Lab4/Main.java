import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Wybierz operację:\n1. Dodaj spotkanie\n2. Usuń spotkanie\n3. Wyświetl spotkania danego dnia\n4. Wyświetl spotkania od danego czasu\n5. Wyświetl spotkania o danym priorytecie\n6. Dodawanie testowych spotkań\n7. Wyjście");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> dodajSpotkanie(scanner, kalendarz);
                case 2 -> usunSpotkanie(scanner, kalendarz);
                case 3 -> wyswietlSpotkaniaDanegoDnia(scanner, kalendarz);
                case 4 -> wyswietlSpotkaniaOdPodanegoCzasu(scanner, kalendarz);
                case 5 -> wyswietlSpotkaniaPoPriorytecie(scanner, kalendarz);
                case 6 -> testujKalendarz(scanner, kalendarz);
                case 7 -> running = false;
                default -> System.out.println("Podano zły argument");
            }
        }
    }
    public static void dodajSpotkanie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        int godzinaPoczatku;
        int minutaPoczatku;
        do {
            System.out.println("Podaj godzinę rozpoczęcia spotkania: ");
            godzinaPoczatku = scanner.nextInt();
        } while (godzinaPoczatku < Spotkanie.minCzas.getHour() || godzinaPoczatku > 23);
        do {
            System.out.println("Podaj minutę rozpoczęcia spotkania: ");
            minutaPoczatku = scanner.nextInt();
        } while (minutaPoczatku < 0 || minutaPoczatku > 59);
        System.out.println("Podaj godzinę zakończenia spotkania: ");
        int godzinaZakonczenia = scanner.nextInt();
        System.out.println("Podaj minutę zakończenia spotkania: ");
        int minutaZakonczenia = scanner.nextInt();
        System.out.println("Podaj priorytet spotkania (0-2): ");
        int priorytet = scanner.nextInt();
        kalendarz.dodajSpotkanie(dzienTygodnia, new Spotkanie(opis, LocalTime.of(godzinaPoczatku, minutaPoczatku), LocalTime.of(godzinaZakonczenia, minutaZakonczenia), priorytet));
        System.out.println("Dodano spotkanie: " + opis);
    }
    
    public static void usunSpotkanie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        kalendarz.usunSpotkanie(dzienTygodnia, opis);
        System.out.println("Usunięto spotkanie: " + opis);
    }
    public static void wyswietlSpotkaniaDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        kalendarz.wyswietlSpotkaniaDanegoDnia(dzienTygodnia);
    }
    public static void wyswietlSpotkaniaOdPodanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj godzinę: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę: ");
        int minuta = scanner.nextInt();
        kalendarz.wyswietlSpotkaniaOdCzasu(dzienTygodnia, LocalTime.of(godzina, minuta));
    }
    public static void wyswietlSpotkaniaPoPriorytecie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj priorytet (0-2): ");
        int priorytet = scanner.nextInt();
        kalendarz.wyswietlSpotkaniaOPriorytecie(dzienTygodnia, priorytet);
    }
    public static void testujKalendarz(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Testowanie wszystkich funkcji!\nDodawanie 7 spotkań...");
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 1", LocalTime.of(10, 0), LocalTime.of(11, 0), 2));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 2", LocalTime.of(14, 0), LocalTime.of(15, 0), 1));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(12, 0), 0));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 4", LocalTime.of(17, 15), LocalTime.of(13, 0), 2));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 5", LocalTime.of(15, 0), LocalTime.of(14, 0), 1));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 6", LocalTime.of(12, 30), LocalTime.of(21,15), 0));      
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 7", LocalTime.of(19, 47), LocalTime.of(23,17), 1));      
    }

}
