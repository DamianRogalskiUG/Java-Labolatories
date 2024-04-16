import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    System.out.println("Program do przechowywania i operacji na ocenach studenta");
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    GradeList gradeList = new GradeList();
    while (running) {
      System.out.println("Wybierz operację:\n1) Dodaj ocenę\n2) Oblicz średnią ocen\n3) Oblicz najwyższą ocenę\n4) Oblicz najniższą ocenę\n5) Zakończ program");
      int wybor = scanner.nextInt();
      switch (wybor) {
        case 1 -> opcja1(scanner, gradeList);
        case 2 -> opcja2(gradeList);
        case 3 -> opcja3(gradeList);
        case 4 -> opcja4(gradeList);
        case 5 -> running = false;
        default -> System.out.println("Podano zły argument");
      } 
    }
  }
  public static void opcja1(Scanner scanner, GradeList gradeList) {
    System.out.println("Podaj ocenę: ");
    Float ocena = scanner.nextFloat();
    if (ocena < 2 || ocena > 5) {
      System.out.println("Podano złą ocenę");
    } else {
      gradeList.addGrade(ocena);
      System.out.println("Ocena dodana: " + ocena);
    }
  }
  public static void opcja2(GradeList gradeList) {
    Float srednia = gradeList.avgGrade();
    if (Float.isNaN(srednia)) {
      System.out.println("Brak ocen");
    } else {
      System.out.println("Srednia ocen: " + (Math.floor(gradeList.avgGrade() * 100)) / 100);
    }
  }
  public static void opcja3(GradeList gradeList) {
    Float max = gradeList.printMaxGrade();
    if (Float.isNaN(max)) {
      System.out.println("Brak ocen");
    } else {
      System.out.println("Najwyzsza ocena: " + (Math.floor(gradeList.printMaxGrade() * 10)) / 10);
    }
  }
  public static void opcja4(GradeList gradeList) {
    Float min = gradeList.printMinGrade();
    if (Float.isNaN(min)) {
      System.out.println("Brak ocen");
    } else {
      System.out.println("Najnizsza ocena: " + (Math.floor(gradeList.printMinGrade() * 10)) / 10);
    }
  }
}
