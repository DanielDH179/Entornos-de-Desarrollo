# Maven Project - Eclipse for Java Developers

## Descripción

Realiza las siguientes actividades utilizando el IDE Eclipse:

1. **Instalar y configurar Maven** comprobando que está instalado.

2. **Crear un proyecto** llamado `fibonacci` del grupo `es.iessoterohernandez.daw.endes` con una clase que tenga un método fibonacci [(Sucesión de Fibonacci - Wikipedia, la enciclopedia libre)](https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci).

3. **Instalar el proyecto** con la clase fibonacci en el repositorio local y **crear un nuevo proyecto** llamado `fibonacciMain` del grupo `es.iessoterohernandez.daw.endes` que utilice el artefacto anterior (de la clase fibonacci).

4. **Crear un proyecto** llamado `HelloWorldPdf` del grupo `es.iessoterohernandez.daw.endes` con una clase que utilice la librería pdf de iText. Este proyecto debe generar un pdf con un contenido básico (Hola Mundo).

5. **Subir el código fuente** de los proyectos a tu repositorio público de [GitHub](https://github.com/DanielDH179/Entornos-de-Desarrollo).

## Sistema operativo

* macOS Ventura 13.6.1

## Paso a paso

### Proyecto fibonacci

Creamos el proyecto Maven utilizando [maven-archetype-quickstart](https://maven.apache.org/archetypes/maven-archetype-quickstart/), asignando estos valores en el archivo `pom.xml`:

```xml
<groupId>es.iessoterohernandez.daw.endes</groupId>
<artifactId>fibonacci</artifactId>
<version>0.0.1-SNAPSHOT</version>

<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

Con esta estructura podemos renombrar la clase `App.java` a `Fibonacci.java` y codificamos nuestro método, que genera y devuelve una secuencia de números de Fibonacci hasta la posición indicada.

```java
package es.iessoterohernandez.daw.endes;

public class Fibonacci {

	public static int[] fibonacci(int number) {

        int[] sequence = new int[number];
        sequence[0] = 0;

        if (number > 1) sequence[1] = 1;

        for (int i = 2; i < number; i++) {
        	sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        return sequence;

    }

}
```

Una vez codificada nuestra función, abrimos la terminal del sistema y ejecutamos los siguientes comandos:

```bash
cd eclipse-workspace/fibonacci
mvn compile
mvn package
mvn install
```

La última instrucción instala el JAR resultante en el repositorio local de Maven, donde se almacenan tanto dependencias como artefactos construidos de otros proyectos. Dicho repositorio se encuentra en un directorio oculto, el cual puede verse desde la aplicación Finder pulsando las teclas ⌘+⇧+G y escribiendo `~/.m2` en el cuadro de búsqueda.

### Proyecto fibonacciMain

Creamos otro proyecto Maven, esta vez el archivo `pom.xml` tiene esta estructura:

```xml
<groupId>es.iessoterohernandez.daw.endes</groupId>
<artifactId>fibonacciMain</artifactId>
<version>0.0.1-SNAPSHOT</version>

<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>

<dependencies>
  <dependency>
    <groupId>es.iessoterohernandez.daw.endes</groupId>
    <artifactId>fibonacci</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </dependency>
</dependencies>


<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.3.0</version>
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>es.iessoterohernandez.daw.endes.FibonacciMain</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

La inserción del JAR anterior en el bloque de dependencias nos permite usar la clase Fibonacci para la clase principal:

```java
package es.iessoterohernandez.daw.endes;

import java.util.Arrays;

public class FibonacciMain {

    public static void main(String[] args) {

    	final int NUMBER = 23;
        int[] sequence = Fibonacci.fibonacci(NUMBER);

        System.out.println("F(" + NUMBER + ") = " + Arrays.toString(sequence));

    }

}
```

Volvemos a la terminal anterior y nos desplazamos a la raíz del proyecto actual:

```bash
cd ../fibonacciMain
mvn compile
mvn package
```

Maven nos ofrece una herramienta para gestionar el classpath ejecutar la aplicación en lugar de ejecutar directamente el JAR:

```bash
mvn exec:java -Dexec.mainClass="es.iessoterohernandez.daw.endes.FibonacciMain"
```

Otra opción es lanzar la aplicación con Java desde el propio IDE. Hacemos clic derecho en `fibonacciMain` y elegimos <kbd>Run As</kbd> > <kbd>Java Application</kbd>:

```java
F(23) = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711]
```

### Proyecto HelloWorldPdf

Creamos otro proyecto Maven y añadimos la [librería pdf de iText](https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.5.13.3) al archivo `pom.xml`:

```xml
<groupId>es.iessoterohernandez.daw.endes</groupId>
<artifactId>HelloWorldPdf</artifactId>
<version>0.0.1-SNAPSHOT</version>

<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>

<dependencies>
  <!-- https://mvnrepository.com/artifact/com.itextpdf/itextpdf -->
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>itextpdf</artifactId>
    <version>5.5.13</version>
  </dependency>
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.11</version>
    <scope>test</scope>
  </dependency>
</dependencies>

<build>
  <pluginManagement>
    <plugins>
      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.3.0</version>
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <mainClass>es.iessoterohernandez.daw.endes.HelloWorldPdf</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </pluginManagement>
</build>
```

Escribimos el siguiente código con ayuda de las clases pertenecientes a la librería. El documento PDF será generado dentro de la carpeta raíz del proyecto:

```java
package es.iessoterohernandez.daw.endes;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class HelloWorldPdf {

    public static void main(String[] args) {

        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("Hola Mundo"));

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            document.close();

        }

    }

}
```

Lanzamos la aplicación desde el IDE y se creará el documento con el contenido especificado.

## Referencias

* [Maven Repository: Search/Browse/Explore](https://mvnrepository.com/)
* [Stack Overflow: Missing Maven dependencies in Eclipse project](https://stackoverflow.com/questions/4262186/missing-maven-dependencies-in-eclipse-project)
* [Adding locally hosted code to GitHub](https://docs.github.com/en/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github)
