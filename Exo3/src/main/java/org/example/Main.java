package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book livre = new Book("Harry POtter","Toto");
        Book livre2 = new Book("Seigneur des annaux","Tata");

        List<Book> bibliotheque = new ArrayList();
        bibliotheque.add(livre);
        bibliotheque.add(livre2);

        Serialization.runSerialization(bibliotheque);
        Serialization.runDeSerialization();
    }
}