import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Program obliczający pola powierzchni walca oraz jego objętość");
        Walec walec = new Walec();
        while (running) {
            wyswietlMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> opcja1(walec);
                case 2 -> opcja2(scanner, walec);
                case 3 -> opcja3(walec);
                case 4 -> opcja4(walec);
                case 5 -> running = false;
                default -> System.out.println("Podano zły argument");
            } 

        }
        scanner.close();
    }
    public static double wczytajDouble(Scanner scanner, String type) {
        System.out.println("Podaj " + type + ": ");
        return scanner.nextDouble();
    }
    public static void wyswietlMenu() {
        System.out.println("Wybierz operację:\n1) Wyświetl wartości zmiennych\n2) Zmień wartości zmiennych");
        System.out.println("3) Oblicz pole powierzchni walca\n4) Oblicz objętość walca\n5) Zakończ program");
    }
    public static void opcja1(Walec walec) {
        System.out.println("Promień: " + walec.getPromienPodstawy() + "\nWysokość: " + walec.getWysokosc());
    }
    public static void opcja2(Scanner scanner, Walec walec) {
        double promienPodstawy = wczytajDouble(scanner, "promień podstawy walca");
        double wysokosc = wczytajDouble(scanner, "wysokość walca");
        walec.setPromienPodstawy(promienPodstawy);
        walec.setWysokosc(wysokosc);
    }
    public static void opcja3(Walec walec) {
        System.out.println("Pole podstawy: " + Math.floor((walec.obliczPolePodstawy()) * 100) / 100);
        System.out.println("Pole boczne: " + Math.floor((walec.obliczPoleBoczne()) * 100) /100 );
        System.out.println("Pole całkowite: " + Math.floor(walec.obliczPoleCalkowite() * 100) / 100);
    }
    public static void opcja4(Walec walec) {
        System.out.println("Objętość: " + Math.floor(walec.obliczObjetosc() * 100) / 100);
    }
}
