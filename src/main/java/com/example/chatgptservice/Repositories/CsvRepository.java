package com.example.chatgptservice.Repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Repository
public class CsvRepository {

    private static final String csvFilePath = "C:\\Users\\Achraf\\Desktop\\izicap\\ChatGPTQA.csv";

    private static final String CSV_HEADER = "Question;Answer";

    public void appendToCsv(String question, String answer) {
        try {
            File file = new File(csvFilePath);
            boolean fileExists = file.exists();
            FileWriter csvWriter = new FileWriter(csvFilePath, true);
            if (!fileExists) {
                csvWriter.append(CSV_HEADER);
                csvWriter.append("\n");
            }
            csvWriter.append(question);
            csvWriter.append(";");
            csvWriter.append(answer);
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            throw new RuntimeException("Error writing to CSV file: " + e.getMessage());
        }
    }
}
