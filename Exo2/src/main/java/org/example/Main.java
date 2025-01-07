package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Journalisation journalisation = new Journalisation();

    public static void main(String[] args) {
        journalisation.importfile();
        while (true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("""
                --- Menu ---
                1. Ajouter une activité
                2. Afficher les activités
                3. Sauvegarder en binaire
                4. Lire le fichier binaire
                5. Quitter
                """);

        System.out.print("Entrez votre choix : ");
        int choix=scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> {
                System.out.print("Entrez une activité à ajouter : ");
                String activite = scanner.nextLine();
                journalisation.addActivity(activite);
            }
            case 2 -> journalisation.readFile();
            case 3 -> journalisation.txtToDat();
            case 4 -> journalisation.readBackup();
            case 5 -> {
                System.out.println("Au revoir !!!");
                System.exit(0); // Termine l'application
            }
            default -> System.out.println("Choix invalide !!!!");
        }
    }
}
