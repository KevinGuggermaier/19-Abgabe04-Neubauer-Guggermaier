# Lab Report

```
Abgabe 04
```

## Gruppenmitglieder:

```
Kevin Guggermaier
Dominik Neubauer
```

## Repository URL

```
https://github.com/KevinGuggermaier/19-Abgabe04-Neubauer-Guggermaier
```

--------------------------------------------------------------------------------

## Task list: (von GitHub)

- [x] transfer the task list to the Markdown Readme
- [x] add the template of the Queue implementation (Repository: <https://github.com/michaelulm/softwareconfiguration-management/tree/master/test-automation/Queue> )
- [x] Go through the tasks step by step

  - [x] commit all changes

- [x] correct the code

  - [x] find three mistakes
  - [x] optimise queue if necessary

- [x] add JavaDoc documentation for the whole project

  - [x] add a picture of the generated documentation in the report

- [x] add JUnit Tests

  - [x] different variations
  - [x] generate JavaDoc comments
  - [x] add a picture of the generated documentation in the report

- [x] update the pom.xml

  - [x] plugin for compiling
  - [x] plugin for documentation
  - [x] developer information
  - [x] log4j library with dependencies

- [x] log4j: add every Method in the log

  - [x] static logger for writing on the console
  - [x] configure the logger via a properties file
  - [x] info log-message always when a method is called
  - [x] error log-message always when a bug appears
  - [x] results (from the console) in form of a picture in the documentation

- [x] Maven site documentation

  - [x] with JavaDoc code and JavaDoc test classes
  - [x] including a menu with links to the manual generated pages

    - [x] page shows the functionality of a queue

  - [x] put a picture of the maven site documentation in the report

    - [x] content of the manual generated page has to be obvious

  - [x] Markdown lab report

  - [x] like the template

  - [x] all steps included

  - [x] GitHub Flavor

    - [x] three lines python and java source code correct pictured

  - [x] generate a pdf from Markdown

## Vorgehen

1. Task-List und das Repositorys erstellen und initial das Queue Beispiel auf GitHub laden.
2. Code auf Fehler untersuchen:

  - Uns fiel als erstes auf, dass "@Override" eine Fehlermeldung produzierte. Zur Behebung musste man unter "Project Structure/Project Settings/Modules/Project Language Level" das Language Level auf "Project Structure/Project Settings/Modules/Project Language Level" einstellen.
  - Im Interface wurde bei zwei Methoden nicht die gewünschte, geworfene Exception angegeben: remove() und element(). Die Signatur dieser Methoden wurden von uns daher durch "throws NoSuchElementException" ergänzt.
  - Im Konstruktor der StringQueue wurde der Übergabeparameter nicht richtig übergeben:

    ```java
    public StringQueue(int maxsize){
    maxSize = maxSize;
    }
    ```

    Dadurch würde man der Klassenvariable (maxSize) die Klassenvariable selbst zuweisen. Wir besserten dieses Problem wie folgt aus:

    ```java
    public StringQueue(int maxSize){
    this.maxSize = maxSize;
    }
    ```

    Damit wird der Wert richtig übergeben und in der Klassenvariable gespeichert.

  - Bei der Methode poll() muss die Abfrage verändert werden. Die ursprüngliche Abfrage:

    ```java
    if(elements.size() == 0){
    elements.remove(0);
    }
    ```

    würde aus der ArrayList nur dann ein Element löschen, wenn die Größe der List gleich Null währe (also leer). Wir haben sie daher wie folgt verändert:

    ```java
    if(elements.size() != 0){
    elements.remove(0);
    }
    ```

    Dadurch wird nur dann ein Element gelöscht (bzw. der Head) wenn eines existiert.

  - Bei der Methode remove() wird gleich am Anfang poll aufgerufen. Diese Methode löscht und retouniert das Head-Element, falls es Elemente in der Liste gibt (ansonsten wird null zurückgegeben). Jedoch wird der Rückgabewert in elemente gleich überschrieben:

    ```java
    String element = poll();
    element = "";
    ```

    Danach könnte die Funktion kein korrektes Ergebnis liefern. Daher wurde die Zeile mit "element = "" " von uns entfernt.

  - Eine Klassenvariable sollte von vorne herein kein Wert zugewiesen werden, weil dieser sowieso im Konstruktor mitübergeben wird.

3. Code optimieren/ergänzen

  - Von uns wurden im Queue Interface the Methoden size(), welche die maximale Größe der Queue zurückgibt, und filling(), welche die aktuelle Anzahl der Elemente in der zurückgibt, implementiert.
  - Weiters wurden die Signaturen der Methoden des Queue Interfaces dahingehend verändert, dass diese auf unterschiedlichesten Arten implementiert werden können. Etwa das man nicht nur eine StringQueue erstellen kann sondern auch eine IntQueue
  - Dadurch konnte eine weiter implementierung der Queue durchgeführt werden. Es wurde die Klasse IntQueue erstellt, welche eine Queue mit Integer-Elementen repräsentiert.

4. Für alle Klassen und Methoden eine API Dokumentation mittels JavaDoc erstellen: ![](javadoc_incode1.jpg)

  ![](javadoc_incode2.jpg)

  ![](javadoc1.jpg)

  ![](javadoc2.jpg)

  ![](javadoc3.jpg)

  ![](javadoc4.jpg)

  ![](javadoc5.jpg)

  Nachdem für alle Klassen und Methoden eine Dokumentation hinzugefügt wurde, generierten wir mittels IntelliJ die JavaDoc-Files. ![](filepath_javadoc.jpg)

5. JUnit Tests erstellen

  - Es wurden von uns unterschiedliche Test-Fälle geschrieben jeweils für die StringQueue Klasse (StringQueueTest) und für die IntQueue Klasse (IntQueueTest). Mit den Testfällen decken wir 100% des Codes.
  - Weiter wurden von uns die Test-Klassen für JavaDoc kommentiert und die jeweilgen Seiten generiert ![](javadoc_incode3.jpg)

    ![](javadoc6.jpg)

    ![](javadoc7.jpg)

6. Anpassen der pom.xml

  - Zunächst wurden die developer Informationen von uns hinzugefügt.
  - Weiters wurden folgende Pugins eingebunden:

    - maven-compiler-plugin: um den Source Code zu kompilieren
    - maven-site-plugin: um eine Maven-Site erstellen zu können
    - maven-project-info-plugin: für weiter Projekt Informationen
    - maven-javadoc-plugin: um von der Site auf die Java-Dokumentation zugreifen zu können
    - maven-surefire-report-plugin: um die Ergebnisse der Test-Fälle auf der Maven-Site anzuzeigen

  - Dependencies:

    - junit: um JUnit Tests ausführen zu können
    - log4j: um weiter Informationen zu Methoden-Aufrufe, Tests und Errors auf die Command-Line schreiben zu können (oder auch in Log-Dateien). Dafür kann man mit diesem Tool in Java ein eigenes Objekt erzeugen, das diese Aufgabe erledigt.

7. Log4j einfügen und konfigurieren:

  - Es wurde ein statischer Logger erstellt der die Log-Ergebnisse auf die Command-Line schreibt.
  - Konfiguriert wird der Logger über src/main/resources/log4j2-test.properties
  - Der Logger schreibt bei jedem Aufruf einer Methode, sowie beim werfen eines Errors auf die Konsole ![](logger1.jpg)

    ![](logger2.jpg)

8. Maven Site Documentation erstellen

  - Wie bereits unter 7\. erwähnt wurden einige Plugins zur pom.xml hinzugefügt, um diverse Informationen aus dem Projekt in die Maven Site einbinden zu können. Etwa:

    - JavaDoc
    - JUnit Test Resultate

  - Weiters wurde von uns eine eigene Seite "aboutQueue" erstellt (geschrieben als Markdown), welche die Funktionsweise einer Queue erörtert. Erreichbar ist diese Seite bei Maven-Site über das Menü in der linken Ecke unter "Overview". ![](mvn-site1.jpg)

    ![](mvn-site2.jpg)

9. GitHub Flavor

  - Dient dazu Elemente aus dem Markdown richtig auf der HTML Seite anzuzeigen, beispielsweise die Checkboxen der Tast-List oder, wie in den Beispielen unterhalb, den Code für die jeweilige Programmiersprache.

    - Flavor für Python

      ```python
      def convertRemoteFile (row, root):
      rowCsv = []
      rowCsv.extend(row)
      ```

    - Flavor für Java

      ```java
      public static int[] insertion_sort(int[] array) {
      for(int i = 1; i < array.length; i++) {
      int key=array[i];
      int j=i-1;
      while(array[j]>key && j>0) {
      array[j+1]=array[j];
      j--;
      }
      array[j+1]=key;
      }
      return array;
      }
      ```

10. Generieren eines PDFs aus einem Markdown

  - Das PDF für die Abgabe des Lab Reports wurde von uns mittels einem Atom Plugin (Package: markdown-pdf) erstellt.

--------------------------------------------------------------------------------

## Links

1. <http://www.rubycoloredglasses.com/2013/04/languages-supported-by-github-flavored-markdown/>

2. <https://maven.apache.org/plugins/maven-javadoc-plugin/usage.html>

3. <http://maven.apache.org/plugins/maven-site-plugin/>

4. <https://www.javaworld.com/article/2071733/get-the-most-out-of-maven-2-site-generation.html?page=2>

5. <http://maven.apache.org/plugins/maven-site-plugin/examples/multimodule.html>

6. <http://maven.apache.org/doxia/references/apt-format.html>
