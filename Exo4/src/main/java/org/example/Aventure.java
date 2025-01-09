package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Aventure {
    private Character personnage;
    private Character monster;
    private LibrairieCharacter librairieCharacter = new LibrairieCharacter();
    private Journal journal = new Journal();
    private List<String> events= new ArrayList<>();
    private static final String EVENTS_FILE = "events.txt";
    Scanner scanner = new Scanner(System.in);

    public Aventure(){
        try (BufferedReader br = new BufferedReader(new FileReader(EVENTS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                events.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomEvent() {
        return events.get((int) (Math.random()*events.size()));
    }

    public void creerPersonnage() throws IOException {
        System.out.print("Entrez le nom de votre héros : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez la force (1-100) : ");
        int force = scanner.nextInt();
        System.out.print("Entrez la santé (1-100) : ");
        int sante = scanner.nextInt();

        personnage = new Character(nom, force, sante);
        librairieCharacter.addperso(personnage);
        librairieCharacter.saveCharacters();

    }

    public void chargerPersonnage() throws IOException, ClassNotFoundException {
        librairieCharacter.displayAllCharacters();
        System.out.println("Quel personnage choissez-vous?");
        int choix = scanner.nextInt();
        personnage=librairieCharacter.getPerso(choix);
    }

    public void jouer() throws IOException {
        System.out.println("Jouons!");
        for (int i = 0; i < 10; i++) {
            String resultat = "";
            String event = getRandomEvent();
            System.out.println("Evénement : " +event);
            if (event.contains("monstre")){
                System.out.println("Action : Combat");
                librairieCharacter.loadMonstersFromFile();
                if (personnage.getForce()> monster.getForce()){
                    System.out.println("Vous avez vaincu le monstre : force +5");
                    personnage.setForce(personnage.getForce()+5);
                }else {
                    System.out.println("Vous avez perdu contre le monstre : santé -20");
                    personnage.setSante(personnage.getSante()-20);
                }
            }else{
                double d = Math.random();
                System.out.println("dé : "+d);
                if (d >0.5){
                    System.out.println("Réussite");
                    resultat = "Réussite";
                }else {
                    System.out.println("Echec");
                    resultat = "Echec";
                    personnage.setSante(personnage.getSante()-10);
                }
            }
            System.out.println("Votre santé est à : " +personnage.getSante());
            journal.addEntry(event+ " - "+resultat);
            if (personnage.getSante()==0){
                System.out.println("Vous êtes mort !");
                break;
            }
            System.out.println("Partie terminé!");
            System.out.println(personnage.toString());

        }
        journal.save();
    }
}
