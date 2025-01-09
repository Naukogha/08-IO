package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrairieCharacter {
    private static final String FILE_PATH = "characters.dat";
    private static final String MONSTERS_FILE = "monster.txt";
    List<Character> persos = new ArrayList<>();

    public LibrairieCharacter(){
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(FILE_PATH)))) {
            persos = (List<Character>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //add
    public void addperso(Character perso){
        persos.add(perso);
        System.out.println("Personnage enregistré");
    }

    //get perso
    public Character getPerso(int id){
        return persos.get(id);
    }

    //sav
    // Sauvegarder les personnages dans un fichier
    public void saveCharacters() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(FILE_PATH)))) {
            oos.writeObject(persos);
            System.out.println("Personnages sauvegardés dans le fichier : " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Afficher tous les personnages
    public void displayAllCharacters() {
        if (persos.isEmpty()) {
            System.out.println("Aucun personnage enregistré.");
        } else {
            for (int i = 0; i < persos.size(); i++) {
                System.out.println("ID: " + i + " - " + persos.get(i));
            }
        }
    }

    public Character loadMonstersFromFile() {
        List<Character> monsters = new ArrayList<>();
        Character monstre = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(MONSTERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int force = Integer.parseInt(parts[1]);
                    int sante = Integer.parseInt(parts[2]);
                    monsters.add(new Character(name, force, sante));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        monstre = monsters.get((int) (Math.random() * monsters.size()));
        return monstre;
    }
}
