import java.util.Scanner;

public class Zad1 {
    public static void main(String[] args) {
        System.out.println("Program do obliczenia sumy liczb naturalnych z podanego zakresu");
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println("Wybierz funkcję podając jej numer:\n1) Suma liczb naturalnych z podanego zakresu\n2) Potęga 2^n");
            String wybor = scanner.nextLine();
            if (wybor.equals("1")) {
                long liczbaOd = wczytajLong(scanner, " początkową: ");
                long liczbaDo = wczytajLong(scanner, " końcową: ");
                long suma = Obliczenia.wylicz(liczbaOd, liczbaDo);
                System.out.println("Suma liczb naturalnych z zakresu od " + liczbaOd + " do " + liczbaDo + " wynosi: " + suma);
            } else if (wybor.equals("2")) {
                long liczba = wczytajLong(scanner, ": ");
                long wynik = Obliczenia.poteguj(liczba);
                System.out.println("Wynik potęgowania 2 do potęgi " + liczba + " to " + wynik);
            } else {
                System.out.println("Podano zły argument");
            }
            System.out.println("Jeżeli chcesz zakończyć to naciśnij q albo Q, jeśli nie to naciśnij inny klawisz");
            scanner.nextLine();
            String sygnal = scanner.nextLine();
            if (sygnal.equalsIgnoreCase("q")) {
                running = false;
            }
        }
        scanner.close();
    }
    public static long wczytajLong(Scanner scanner, String type) {
        System.out.println("Podaj liczbę" + type);
        return scanner.nextLong();
    }
}
