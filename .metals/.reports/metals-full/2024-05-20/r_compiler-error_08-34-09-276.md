file://<WORKSPACE>/Lab5/Kalendarz.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 239
uri: file://<WORKSPACE>/Lab5/Kalendarz.java
text:
```scala
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.function.Predicate;


public class Kalendarz {

    private ArrayList<ArrayList<Spotkanie>> spotkaniaTygodniowe;

    public Kalendarz() {
        this.spotkaniaTygod@@niowe = new ArrayList<>(7); 
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

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:36)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:366)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator