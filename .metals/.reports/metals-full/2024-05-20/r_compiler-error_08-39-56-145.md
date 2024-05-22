file://<WORKSPACE>/Lab6/Spotkanie.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 160
uri: file://<WORKSPACE>/Lab6/Spotkanie.java
text:
```scala
import java.time.LocalTime;

public class Spotkanie {
    public static final LocalTime MIN_CZAS = LocalTime.of(8, 0);
    private String opis;
    private Loca@@lTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private int priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, int prioryet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = prioryet;
    }
    public String getOpis() {
        return opis;
    }
    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }
    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }
    public int getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie: " + opis + ", Czas rozpoczęcia: " + czasPoczatku + ", Czas zakończenia: " + czasZakonczenia + ", Priorytet: " + priorytet + "\n";
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