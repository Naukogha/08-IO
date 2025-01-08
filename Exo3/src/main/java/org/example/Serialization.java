package org.example;

import java.io.*;
import java.util.List;

public class Serialization {

    public static void runSerialization(List<Book> livres) {
        System.out.println("La sérialisation ....");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            oos.writeObject(livres);
            System.out.println("Objet sérialisé ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runDeSerialization() {
        System.out.println("La désérialisation ....");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"))) {
            List<Book> livres = (List<Book>) ois.readObject();
            System.out.println("Objet désérialisé .... " + livres);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
