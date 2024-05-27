import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        ListaOfert listaOfert = new ListaOfert();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            wyswietlMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> dodajOferteSprzedazyDomu(scanner, listaOfert);
                case 2 -> dodajOferteSprzedazyMieszkania(scanner, listaOfert);
                case 3 -> wyswietlDomyOdObecnejDaty(listaOfert);
                case 4 -> wyswietlMieszkaniaAktualne(listaOfert);
                case 5 -> wyswietlDomyAktualneWgMiejscowosciOrazNiemniejszejNizPodanaPowierzchnia(scanner, listaOfert);
                case 6 -> wyswietlMieszkaniaAktualneWgMiejscowosciOdPietraWzwyzWgNiewiekszejCeny(scanner, listaOfert);
                case 7 -> testujProgram(listaOfert);
                case 8 -> running = false;
                default -> System.out.println("Podano zły argument");
            }
        }
    }

    public static void wyswietlMenu() {
        System.out.println("1. Dodaj ofertę sprzedaży domu");
        System.out.println("2. Dodaj ofertę sprzedaży mieszkania");
        System.out.println("3. Wyświetl domy od obecnej daty");
        System.out.println("4. Wyświetl mieszkania aktualne");
        System.out.println("5. Wyświetl domy aktualne wg miejscowości oraz niemniejszej niż podana powierzchnia");
        System.out.println("6. Wyświetl mieszkania aktualne wg miejscowości od piętra wzwyz wg niewiekszej ceny");
        System.out.println("7. Testuj program");
        System.out.println("8. Wyjście");
    }

    public static void dodajOferteSprzedazyDomu(Scanner scanner, ListaOfert listaOfert) {
        System.out.println("Podaj ulicę: ");
        String ulica = scanner.next();
        System.out.println("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.next();
        System.out.println("Podaj powierzchnię: ");
        int powierzchnia = scanner.nextInt();
        System.out.println("Podaj cenę: ");
        int cena = scanner.nextInt();
        System.out.println("Podaj datę obowiązywania oferty (yyyy-MM-dd): ");
        String dataObowiazywaniaOfertyStr = scanner.next();
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(dataObowiazywaniaOfertyStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Podaj powierzchnię działki: ");
        int powierzchniaDzialki = scanner.nextInt();
        listaOfert.dodajOferteDomu(new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty, powierzchniaDzialki));
    }

    public static void dodajOferteSprzedazyMieszkania(Scanner scanner, ListaOfert listaOfert) {
        System.out.println("Podaj ulicę: ");
        String ulica = scanner.next();
        System.out.println("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        System.out.println("Podaj numer mieszkania: ");
        int numerMieszkania = scanner.nextInt();
        System.out.println("Podaj piętro: ");
        int pietro = scanner.nextInt();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.next();
        System.out.println("Podaj powierzchnię: ");
        int powierzchnia = scanner.nextInt();
        System.out.println("Podaj cenę: ");
        int cena = scanner.nextInt();
        System.out.println("Podaj datę obowiązywania oferty (yyyy-MM-dd): ");
        String dataObowiazywaniaOfertyStr = scanner.next();
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(dataObowiazywaniaOfertyStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        listaOfert.dodajOferteMieszkania(new Mieszkanie(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty, numerMieszkania, pietro));
    }

    public static void wyswietlDomyOdObecnejDaty(ListaOfert listaOfert) {
        LocalDate obecnaData = LocalDate.now();
        for (Lokum oferta : listaOfert.wyswietlOferty(oferta -> 
                !oferta.getDataObowiazywaniaOferty().isBefore(obecnaData)
                && oferta instanceof Dom
            )
        ) {
            System.out.println(oferta);
        }
    }

    public static void wyswietlMieszkaniaAktualne(ListaOfert listaOfert) {
        LocalDate obecnaData = LocalDate.now();
        for (Lokum oferta : listaOfert.wyswietlOferty(oferta -> 
                !oferta.getDataObowiazywaniaOferty().isBefore(obecnaData)
                && oferta instanceof Mieszkanie
            )
        ) {
            System.out.println(oferta);
        }
    }

    public static void wyswietlDomyAktualneWgMiejscowosciOrazNiemniejszejNizPodanaPowierzchnia(Scanner scanner, ListaOfert listaOfert) {
        LocalDate obecnaData = LocalDate.now();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj powierzchnię: ");
        int powierzchnia = scanner.nextInt();
        for (Lokum oferta : listaOfert.wyswietlOferty(oferta -> 
                !oferta.getDataObowiazywaniaOferty().isBefore(obecnaData)
                && oferta instanceof Dom
                && oferta.getMiejscowosc().equals(miejscowosc)
                && oferta.getPowierzchnia() >= powierzchnia
            )
        ) {
            System.out.println(oferta);
        }

    }

    public static void wyswietlMieszkaniaAktualneWgMiejscowosciOdPietraWzwyzWgNiewiekszejCeny(Scanner scanner, ListaOfert listaOfert) {
        LocalDate obecnaData = LocalDate.now();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.next();
        System.out.println("Podaj piętro: ");
        int pietro = scanner.nextInt();
        System.out.println("Podaj cenę: ");
        int cena = scanner.nextInt();
        for (Lokum oferta : listaOfert.wyswietlOferty(oferta -> 
                !oferta.getDataObowiazywaniaOferty().isBefore(obecnaData)
                && oferta instanceof Mieszkanie
                && oferta.getMiejscowosc().equals(miejscowosc)
                && ((Mieszkanie) oferta).getPietro() >= pietro
                && oferta.getCena() <= cena
            )
        ) {
            System.out.println(oferta);
        }
    }

    public static void testujProgram(ListaOfert listaOfert) {
        System.out.println("Dodawanie 5 domów i 7 mieszkań");
        listaOfert.dodajOferteDomu(new Dom("Warszawska", 1, "Warszawa", "00-001", 120, 500000, LocalDate.of(2024, 6, 1), 300));
        listaOfert.dodajOferteDomu(new Dom("Krakowska", 2, "Gdańsk", "30-001", 150, 600000, LocalDate.of(2023, 7, 1), 350));
        listaOfert.dodajOferteDomu(new Dom("Gdańska", 3, "Gdańsk", "80-001", 200, 700000, LocalDate.of(2024, 8, 1), 400));
        listaOfert.dodajOferteDomu(new Dom("Poznańska", 4, "Poznań", "60-001", 180, 550000, LocalDate.of(2022, 9, 1), 330));
        listaOfert.dodajOferteDomu(new Dom("Wrocławska", 5, "Warszawa", "50-001", 160, 520000, LocalDate.of(2024, 10, 1), 310));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Marszałkowska", 6, "Warszawa", "00-002", 50, 300000, LocalDate.of(2026, 6, 1), 1, 2));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Floriańska", 7, "Warszawa", "30-002", 60, 350000, LocalDate.of(2026, 7, 1), 2, 3));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Długa", 8, "Gdańsk", "80-002", 70, 400000, LocalDate.of(2022, 8, 1), 3, 4));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Plac Wolności", 9, "Poznań", "60-002", 65, 320000, LocalDate.of(2024, 9, 1), 4, 5));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Ratuszowa", 10, "Poznań", "50-002", 55, 310000, LocalDate.of(2023, 10, 1), 5, 1));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Nowa", 11, "Warszawa", "00-003", 75, 450000, LocalDate.of(2023, 11, 1), 6, 2));
        listaOfert.dodajOferteMieszkania(new Mieszkanie("Stara", 12, "Kraków", "30-003", 80, 500000, LocalDate.of(2028, 12, 1), 7, 3));

    }
}
