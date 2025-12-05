package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hut_Manager_Goal3_1Controller
{
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private TextField askingPriceTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalTypeCB;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;

    final private ArrayList<Animal> animalEditList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalTypeCB.getItems().addAll("Cow", "Goat", "Sheep", "Buffalo", "Camel");
    }

    @javafx.fxml.FXML
    public void goBackToGoal3OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3.fxml");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String animalID = animalIdTF.getText();
        String animalType = animalTypeCB.getValue();
        String breed = breedTF.getText();
        int weight = 0;
        int age = 0;
        int askingPrice = 0;
        String color = colorTF.getText();
        LocalDate entryDate = entryDateDatePicker.getValue();

        try {
            weight = Integer.parseInt(weightTF.getText().trim());
            age = Integer.parseInt(ageTF.getText().trim());
            askingPrice = Integer.parseInt(askingPriceTF.getText().trim());
        } catch (Exception e) {
            AlertUtil.showError("Invalid Input", "Please enter valid numbers for weight, age, and asking price.");
            return;
        }
        if (animalID.isEmpty() || animalType == null || breed.isEmpty() || entryDate == null || color.isEmpty() ||
                weightTF.getText().isEmpty() || ageTF.getText().isEmpty() || askingPriceTF.getText().isEmpty()) {
            AlertUtil.showError("Input Error", "Please fill all the required fields.");
            return;
        }
        Animal newAnimal = new Animal(animalID, animalType, breed, weight, age, askingPrice, entryDate, color, null, "Available");

        animalEditList.add(newAnimal);
        AlertUtil.showInfo("Success", "Animal information saved successfully.");

        File file = new File("data/animal-edit.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file); // NO appending
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(animalEditList);  // Save entire list
            oos.close();
            AlertUtil.showInfo("Success", "Saved to file");
        } catch (IOException e) {
            AlertUtil.showError("Error", "File error: " + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }
}