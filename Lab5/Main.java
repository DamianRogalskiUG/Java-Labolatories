import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Wybierz operację:\n1. Dodaj spotkanie\n2. Usuń spotkanie\n3. Wyświetl spotkania danego dnia\n4. Wyświetl spotkania od danego czasu\n5. Wyświetl spotkania o danym priorytecie\n6. Dodawanie testowych spotkań\n7. Wyświetl spotkania w danym przedziale czasu\n8. Wyświetl spotkania o danym priorytecie i od danego czasu\n9. Wyjście");
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> dodajSpotkanie(scanner, kalendarz);
                case 2 -> usunSpotkanie(scanner, kalendarz);
                case 3 -> wyswietlSpotkaniaDanegoDnia(scanner, kalendarz);
                case 4 -> wyswietlSpotkaniaOdPodanegoCzasu(scanner, kalendarz);
                case 5 -> wyswietlSpotkaniaPoPriorytecie(scanner, kalendarz);
                case 6 -> testujKalendarz(scanner, kalendarz);
                case 7 -> wyswietlSpotkaniaWPrzedzialeCzasu(scanner, kalendarz);    
                case 8 -> wyswietlSpotkaniaWgPriorytetuOdCzasu(scanner, kalendarz);
                case 9 -> running = false;
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
        LocalTime czasPoczatku;
        do {
            czasPoczatku = pobierzCzasPoczatku(scanner);
            if (czasPoczatku == null) {
                System.out.println("Podano złą godzinę rozpoczęcia spotkania");
            }
        } while (czasPoczatku == null);
        System.out.println("Podaj godzinę zakończenia spotkania: ");
        int godzinaZakonczenia = scanner.nextInt();
        System.out.println("Podaj minutę zakończenia spotkania: ");
        int minutaZakonczenia = scanner.nextInt();
        System.out.println("Podaj priorytet spotkania (0-2): ");
        int priorytet = scanner.nextInt();
        kalendarz.dodajSpotkanie(dzienTygodnia, new Spotkanie(opis, czasPoczatku, LocalTime.of(godzinaZakonczenia, minutaZakonczenia), priorytet));
        System.out.println("Dodano spotkanie: " + opis);
    }

    public static LocalTime pobierzCzasPoczatku(Scanner scanner) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę rozpoczęcia spotkania: ");
        int minuta = scanner.nextInt();
        if (godzina < Spotkanie.MIN_CZAS.getHour() || godzina > 23 || minuta < 0 || minuta > 59) {
            return null;
        }
        return LocalTime.of(godzina, minuta);
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
        System.out.println(kalendarz.wyswietlSpotkania(dzienTygodnia, spotkanie -> true));
    }

    public static void wyswietlSpotkaniaOdPodanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj godzinę: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę: ");
        int minuta = scanner.nextInt();
        System.out.println(kalendarz.wyswietlSpotkania(dzienTygodnia, spotkanie -> !spotkanie.getCzasPoczatku().isBefore(LocalTime.of(godzina, minuta))));
    }
    
    public static void wyswietlSpotkaniaPoPriorytecie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj priorytet (0-2): ");
        int priorytet = scanner.nextInt();
        System.out.println(kalendarz.wyswietlSpotkania(dzienTygodnia, spotkanie -> spotkanie.getPriorytet() == priorytet));
    }

    public static void wyswietlSpotkaniaWPrzedzialeCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj godzinę początkową: ");
        int godzinaPoczatkowa = scanner.nextInt();
        System.out.println("Podaj minutę początkową: ");
        int minutaPoczatkowa = scanner.nextInt();
        System.out.println("Podaj godzinę końcową: ");
        int godzinaKoncowa = scanner.nextInt();
        System.out.println("Podaj minutę końcową: ");
        int minutaKoncowa = scanner.nextInt();
        System.out.println(kalendarz.wyswietlSpotkania(dzienTygodnia, spotkanie -> 
                !spotkanie.getCzasPoczatku().isBefore(LocalTime.of(godzinaPoczatkowa, minutaPoczatkowa)) && !spotkanie.getCzasZakonczenia().isAfter(LocalTime.of(godzinaKoncowa, minutaKoncowa))
            )
            );
    }

    public static void wyswietlSpotkaniaWgPriorytetuOdCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj priorytet (0-2): ");
        int priorytet = scanner.nextInt();
        System.out.println("Podaj godzinę: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę: ");
        int minuta = scanner.nextInt();
        System.out.println(kalendarz.wyswietlSpotkania(dzienTygodnia, spotkanie -> spotkanie.getPriorytet() == priorytet && !spotkanie.getCzasPoczatku().isBefore(LocalTime.of(godzina, minuta))));
    }

    public static void testujKalendarz(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Dodawanie 7 spotkań...");
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 1", LocalTime.of(10, 0), LocalTime.of(11, 0), 2));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 2", LocalTime.of(14, 0), LocalTime.of(15, 0), 1));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(12, 0), 0));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 4", LocalTime.of(17, 15), LocalTime.of(13, 0), 2));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 5", LocalTime.of(15, 0), LocalTime.of(14, 0), 1));
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 6", LocalTime.of(12, 30), LocalTime.of(21,15), 0));      
        kalendarz.dodajSpotkanie(1, new Spotkanie("Spotkanie 7", LocalTime.of(19, 47), LocalTime.of(23,17), 1));      
    }

}
