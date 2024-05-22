// Class Inheritance


class BigCat {
    protected double size;
}

public class Panthera extends BigCat {
    public Panthera() {
        size = 10.2;
    }
    public void printDetails() {
        System.out.println("Size: " + size);
    }

}

// In java, you can extend a class by adding the parent class name 
// in the definition using the extends keyword.

// Extending a class


// public abstract class ElephantSeal extends Seal {
//     // methods and variables
// }


// The class BigCat ends the inheritance chain. It is not possible to extend it further.
// public final class BigCat {
//     protected double size;
// }


// Inheritance can be restricted to explicitly specified classes by marking the class with the pair sealed/permits modifiers.

// sealed class BigCat permits Panthera {
//     protected double size;
// }

// public final class Panthera extends BigCat {
//     public Panthera(double size) {
//         this.size = size;
//     }
//     public void printDetails() {
//         System.out.println(size);
//     }
// }

// public non-sealed class Panthera extends BigCat {
//     public Panthera(double size) {
//         this.size = size;
//     }
//     public void printDetails() {
//         System.out.println(size);
//     }
// }


// public sealed class Panthera extends BigCat permits Jaguar {
//     public Panthera() {
//         size = 10.2;
//     }
// }

// final class Jaguar extends Panthera {
//     public double getSize() {
//         return size;
//     }
// }


// java.lang.Object

// public class Animal {}
// To samo co:
// public class Animal extends java.lang.Object {}
// the syntax is optional, but the compiler will add it automatically.


// this() - calls the constructor of the same class
// super() - calls the constructor of the parent class

// super() must be the first statement in the constructor body.


// all of these Donkey classes are the same

// public class Donkey {
// }

// public class Donkey {
//     public Donkey() {
//     }
// }

// public class Donkey {
//     public Donkey() {
//         super();
//     }
// }

// class Primate {
//     public Primate() {
//         System.out.println("Primate");
//     }
// }

// class Ape extends Primate {
//     public Ape() {
//         System.out.println("Ape");
//     }
// }

// public class Chimpanzee extends Ape {
//     public static void main(String[] args) {
//         new Chimpanzee();
//     }
// }


// super keyword is used to access the parent class members (variables and methods).
// super() is used to call the parent class constructor.


// method overriding - when a subclass provides a specific implementation of a method that is already provided by its parent class.

// Overriding a Method

// public class Predator {
//     public double getAvaregeWeight() {
//         return 50;
//     }
// }

// public class Wolf extends Predator {
//     public double getAvaregeWeight() {
//         return super.getAvaregeWeight() + 20;
//     }
    // public static void main(String[] args) {
    //     System.out.println(new Predator().getAvaregeWeight());
    //     System.out.println(new Wolf().getAvaregeWeight());
    // }
// }

// Overriding rules (It can't be a private method.)
// 1. The same signature
// 2. At least as accessible as the method in the parent class
// 3. Cannot throw a broader or new checked exception
// 4. Must return the same type or a subtype


// redeclaring - nadpisywanie ale to oddzielna metoda w klasie dziedziczącej niezależna od ojca

// method hiding (dotyczy statycznych) - when a subclass provides a static method with the same name as a static method in its parent class.


// class Marsupial {
//     public static boolean isBiped() {
//         return false;
//     }
//     public void getMarsupialDescription() {
//         System.out.println("Marsupial walks on two legs: " + isBiped());
//     }
// }

// class Kangaroo extends Marsupial {
//     public static boolean isBiped() { // hiding method isBiped
//         return true;
//     }
//     public void getKangarooDescription() {
//         System.out.println("Kangaroo hops on two legs: " + isBiped());
//     }
//     public static void main(String[] args) {
//         Kangaroo joey = new Kangaroo();
//         joey.getMarsupialDescription();
//         joey.getKangarooDescription();
//     }
// }

// Output:
// Marsupial walks on two legs: true
// Kangaroo hops on two legs: true


// Polymorphism - the ability of an object to take on many forms.
// To put this more precisely, a Java object may accessed:
// - using a reference with the same type as the object
// - using a reference that is a superclass of the object
// - using a reference that defines an interface the object implements, either directly or through a superclass


// Furthermore, a cast is not required if the object is being reassigned to a reference variable of a superclass or interface type.


// public class Primate {
//     public boolean hasHair() {
//         return true;
//     }
// }

// public interface HasTail {
//     public boolean isTailStriped();
// }

// public class Lemur extends Primate implements HasTail {
//     public int age = 10;
//     public int getAge() {
//         return age;
//     }
//     public boolean isTailStriped() {
//         return true;
//     }
// }

// 