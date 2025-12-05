package com.group9.kurbani_cattle_hut_management_system.Joy.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IDStoreUtil {

    // Save ID to file (append)
    public static void saveID(String filePath, String id) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(id);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load IDs for ComboBox
    public static ObservableList<String> loadIDs(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return FXCollections.observableArrayList(lines);
        } catch (IOException e) {
            e.printStackTrace();
            return FXCollections.observableArrayList();
        }
    }
}
