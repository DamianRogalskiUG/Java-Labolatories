import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            wyswietlMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> dodajSpotkanie(scanner, kalendarz);
                case 2 -> dodajZadanie(scanner, kalendarz);
                case 3 -> usunSpotkanie(scanner, kalendarz);
                case 4 -> usunZadanie(scanner, kalendarz);
                case 5 -> wyswietlSpotkaniaDanegoDnia(scanner, kalendarz);
                case 6 -> wyswietlZadaniaDanegoDnia(scanner, kalendarz);
                case 7 -> wyswietlSpotkaniaPoPriorytecieDanegoDnia(scanner, kalendarz);
                case 8 -> wyswietlZadaniaPoStatusieDanegoDnia(scanner, kalendarz);
                case 9 -> wyswietlSpotkaniaWgPriorytetuOdCzasu(scanner, kalendarz);
                case 10 -> wyswietlZadanieWgStatusuKonczacychPrzedCzasem(scanner, kalendarz);
                case 11 -> testujKalendarz(scanner, kalendarz);
                case 12 -> running = false;
                default -> System.out.println("Podano zły argument");
            }
        }
    }

    public static void wyswietlMenu() {
        System.out.println("1. Dodaj spotkanie");
        System.out.println("2. Dodaj zadanie");
        System.out.println("3. Usuń spotkanie");
        System.out.println("4. Usuń zadanie");
        System.out.println("5. Wyświetl spotkania danego dnia");
        System.out.println("6. Wyświetl zadania danego dnia");
        System.out.println("7. Wyświetl spotkania po priorytecie danego dnia");
        System.out.println("8. Wyświetl zadania po statusie danego dnia");
        System.out.println("9. Wyświetl spotkania wg priorytetu od czasu");
        System.out.println("10. Wyświetl zadanie wg statusu kończących przed czasem");
        System.out.println("11. Testuj kalendarz");
        System.out.println("12. Wyjście");
    }



    public static void dodajSpotkanie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        LocalTime czasPoczatku;
        do {
            czasPoczatku = pobierzCzasPoczatkuSpotkania(scanner);
            if (czasPoczatku == null) {
                System.out.println("Podano złą godzinę rozpoczęcia spotkania");
            }
        } while (czasPoczatku == null);
        System.out.println("Podaj godzinę zakończenia spotkania: ");
        int godzinaZakonczenia = scanner.nextInt();
        System.out.println("Podaj minutę zakończenia spotkania: ");
        int minutaZakonczenia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet spotkania: ");
        String priorytet = scanner.nextLine();
        kalendarz.dodajAktywnosc(dzienTygodnia, new Spotkanie(opis, czasPoczatku, LocalTime.of(godzinaZakonczenia, minutaZakonczenia), priorytet));
        System.out.println("Dodano spotkanie: " + opis);
    }

    public static void dodajZadanie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis zadania: ");
        String opis = scanner.nextLine();
        LocalTime czasPoczatku;
        do {
            czasPoczatku = pobierzCzasPoczątkuZadania(scanner);
            if (czasPoczatku == null) {
                System.out.println("Podano złą godzinę rozpoczęcia zadania");
            }
        } while (czasPoczatku == null);
        System.out.println("Podaj godzinę zakończenia zadania: ");
        int godzinaZakonczenia = scanner.nextInt();
        System.out.println("Podaj minutę zakończenia zadania: ");
        int minutaZakonczenia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status zadania: ");
        String status = scanner.nextLine();
        kalendarz.dodajAktywnosc(dzienTygodnia, new Zadanie(opis, czasPoczatku, LocalTime.of(godzinaZakonczenia, minutaZakonczenia), status));
        System.out.println("Dodano zadanie: " + opis);
    }


    public static LocalTime pobierzCzasPoczatkuSpotkania(Scanner scanner) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę rozpoczęcia spotkania: ");
        int minuta = scanner.nextInt();
        if (godzina < Spotkanie.MIN_CZAS.getHour() || godzina > 23 || minuta < 0 || minuta > 59) {
            return null;
        }
        return LocalTime.of(godzina, minuta);
    }

    public static LocalTime pobierzCzasPoczątkuZadania(Scanner scanner) {
        System.out.println("Podaj godzinę rozpoczęcia spotkania: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę rozpoczęcia spotkania: ");
        int minuta = scanner.nextInt();
        if (godzina < Zadanie.MIN_CZAS.getHour() || godzina > 23 || minuta < 0 || minuta > 59) {
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
        kalendarz.usunAktywnosc(dzienTygodnia, opis);
        System.out.println("Usunięto spotkanie: " + opis);
    }

    public static void usunZadanie(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis zadania: ");
        String opis = scanner.nextLine();
        kalendarz.usunAktywnosc(dzienTygodnia, opis);
        System.out.println("Usunięto zadanie: " + opis);
    }

    public static void wyswietlSpotkaniaDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println(
            kalendarz.wyswietlAktywnosci(
                dzienTygodnia, spotkanie -> true && spotkanie instanceof Spotkanie
                )
            );
    }

    public static void wyswietlZadaniaDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println(
            kalendarz.wyswietlAktywnosci(
                dzienTygodnia, spotkanie -> true && spotkanie instanceof Zadanie
                )
            );
    }

    public static void wyswietlSpotkaniaOdPodanegoCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        System.out.println("Podaj godzinę: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę: ");
        int minuta = scanner.nextInt();
        System.out.println(kalendarz.wyswietlAktywnosci(
            dzienTygodnia, spotkanie -> 
            !spotkanie.getCzasPoczatku().isBefore(LocalTime.of(godzina, minuta)) 
            && spotkanie instanceof Spotkanie
        ));
    }
    
    public static void wyswietlSpotkaniaPoPriorytecieDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        System.out.println(kalendarz.wyswietlAktywnosci(dzienTygodnia, aktywnosc -> {
            if (aktywnosc instanceof Spotkanie) {
                Spotkanie zadanie = (Spotkanie) aktywnosc;
                return zadanie.getPriorytet().equals(priorytet);
            }
            return false;
        }));
    }

    public static void wyswietlZadaniaPoStatusieDanegoDnia(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status: ");
        String status = scanner.nextLine();

        System.out.println(kalendarz.wyswietlAktywnosci(dzienTygodnia, aktywnosc -> {
            if (aktywnosc instanceof Zadanie) {
                Zadanie zadanie = (Zadanie) aktywnosc;
                return zadanie.getStatus().equals(status);
            }
            return false;
        }));
    }

    public static void wyswietlSpotkaniaWgPriorytetuOdCzasu(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet: ");
        String priorytet = scanner.nextLine();
        System.out.println("Podaj godzinę: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę: ");
        int minuta = scanner.nextInt();

        System.out.println(kalendarz.wyswietlAktywnosci(dzienTygodnia, aktywnosc -> {
            if (aktywnosc instanceof Spotkanie) {
                Spotkanie spotkanie = (Spotkanie) aktywnosc;
                return spotkanie.getPriorytet().equals(priorytet) && !spotkanie.getCzasPoczatku().isBefore(LocalTime.of(godzina, minuta));
            }
            return false;
        }));    
    }

    public static void wyswietlZadanieWgStatusuKonczacychPrzedCzasem(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Podaj dzień tygodnia (0-6): ");
        int dzienTygodnia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status: ");
        String status = scanner.nextLine();
        System.out.println("Podaj godzinę zakończenia: ");
        int godzina = scanner.nextInt();
        System.out.println("Podaj minutę zakończenia: ");
        int minuta = scanner.nextInt();
        System.out.println(kalendarz.wyswietlAktywnosci(dzienTygodnia, aktywnosc -> {
            if (aktywnosc instanceof Zadanie) {
                Zadanie zadanie = (Zadanie) aktywnosc;
                return zadanie.getStatus().equals(status) && !zadanie.getCzasZakonczenia().isAfter(LocalTime.of(godzina, minuta));
            }
            return false;
        }));
    }

    public static void testujKalendarz(Scanner scanner, Kalendarz kalendarz) {
        System.out.println("Dodawanie 7 spotkań i 7 zadań...");
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 1", LocalTime.of(10, 0), LocalTime.of(11, 0), "najwyzszy"));
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 2", LocalTime.of(14, 0), LocalTime.of(15, 0), "wysoki"));
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 3", LocalTime.of(11, 0), LocalTime.of(12, 0), "normalny"));
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 4", LocalTime.of(17, 15), LocalTime.of(13, 0), "najwyzszy"));
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 5", LocalTime.of(15, 0), LocalTime.of(14, 0), "wysoki"));
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 6", LocalTime.of(12, 30), LocalTime.of(21,15), "normalny"));      
        kalendarz.dodajAktywnosc(1, new Spotkanie("Spotkanie 7", LocalTime.of(19, 47), LocalTime.of(23,17), "wysoki"));      
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 1", LocalTime.of(10, 0), LocalTime.of(11, 0), "planowane"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 2", LocalTime.of(14, 0), LocalTime.of(15, 0), "potwierdzone"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 3", LocalTime.of(11, 0), LocalTime.of(12, 0), "realizowane"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 4", LocalTime.of(17, 15), LocalTime.of(19, 0), "planowane"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 5", LocalTime.of(15, 0), LocalTime.of(18, 0), "wykonane"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 6", LocalTime.of(12, 30), LocalTime.of(21,15), "wykonane"));
        kalendarz.dodajAktywnosc(1, new Zadanie("Zadanie 7", LocalTime.of(19, 47), LocalTime.of(23,17), "potwierdzone"));
    }

}
