package org.example;

import java.io.*;

public class CountTextJava {
    public void readFile(){
        System.out.println("Lecture de fichier");
        String filePath="result.txt";
        String path="src/main/java/org/example/input_file.txt";
        int countJava=0;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line;

            while ((line = reader.readLine()) != null){
                if (line.contains("Java")){
                    System.out.println("Ligne lue : "+line);
                    countJava+=1;
                }

            }
            System.out.println("il y a "+countJava+" ligne contenant java");
        }catch (IOException e){
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("il y a "+countJava+" ligne contenant java");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
