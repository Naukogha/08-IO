package org.example;
import java.io.*;

public class Journal {
    private StringBuilder content;
    private static final String JOURNAL_FILE = "journal.txt";


    public Journal() {
        content = new StringBuilder();
    }

    public void addEntry(String entry) {
        content.append(entry).append("\n");
    }

    public void save() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE))) {
            writer.write(content.toString());
        }
    }
}

