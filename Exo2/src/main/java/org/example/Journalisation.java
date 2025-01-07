package org.example;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Journalisation {
    String file = "journal.txt";
    String fileDat = "journal_backup.dat";

    public void importfile(){
        File f = new File(file);
        if(!f.exists() )
        {
            System.out.println("Le fichier n'existe pas ... ");
            try {
                f.createNewFile();
                System.out.println("Fichier 'journal.text' créé!" );
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void addActivity(String activite){
        BufferedWriter bufWriter = null;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufWriter = new BufferedWriter(fileWriter);
            LocalDateTime dateHeureMaintenant = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateFormatee = dateHeureMaintenant.format(formatter);

            bufWriter.newLine();
            bufWriter.write(dateFormatee + " - " + activite);
            bufWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void txtToDat(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileDat))){
            String line;
            while ((line = reader.readLine()) != null) {
                // Convertir la ligne en tableau d'octets
                byte[] bytes = line.getBytes();
                // Écrire les octets dans le fichier binaire
                out.write(bytes);
                // Ajouter un saut de ligne pour séparer les lignes
                out.write(System.lineSeparator().getBytes());
            }
        }catch (IOException e){
            // e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public void readBackup(){
        File f = new File(fileDat);
        if(!f.exists()){
            System.out.println("Le fichier de backup n'existe pas !");
        }else{
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))){
                byte[] buffer = new byte[1024];
                int bytesRead;
                StringBuilder line = new StringBuilder();
                while ((bytesRead = in.read(buffer)) != -1){
                    line.append(new String(buffer, 0, bytesRead));
                }
                System.out.println(line);
            }catch (IOException e){
                // e.printStackTrace();
                System.err.println(e.getMessage());
            }
        }
    }
}
