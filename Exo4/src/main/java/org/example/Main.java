package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Character perso = new Character("Elrond", 70, 100);
//
//        LibrairieCharacter librairieCharacter = new LibrairieCharacter();
//
//        librairieCharacter.addperso(perso);
//        librairieCharacter.displayAllCharacters();
//        librairieCharacter.saveCharacters();

        Aventure aventure = new Aventure();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Bienvenue dans le jeu d'aventure textuelle ! ---");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Charger un personnage existant");
        System.out.print("Choisissez une option : ");
        int choix = scanner.nextInt();

        if (choix == 1) {
            aventure.creerPersonnage();
        } else if (choix == 2) {
            aventure.chargerPersonnage();
        }

        aventure.jouer();
    }

}