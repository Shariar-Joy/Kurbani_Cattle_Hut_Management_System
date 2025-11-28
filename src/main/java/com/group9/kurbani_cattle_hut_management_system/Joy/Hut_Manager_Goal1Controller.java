package com.group9.kurbani_cattle_hut_management_system.Joy;


import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Hut_Manager_Goal1Controller {

    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalTypeCB;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalTypeCOL;
    @javafx.fxml.FXML
    private DatePicker exitDateDatePicker;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> animalTableView;
    @javafx.fxml.FXML
    private TextField ownerAddressTF;
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TextField ownerPhone;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private TextField removeAnimalIdTF;
    @javafx.fxml.FXML
    private TextField askingPriceTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @javafx.fxml.FXML
    private TextField statusAnimalIdTF;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalIdCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TextField reasonToRemoveTF;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> statusCOL;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private ComboBox<String> selectTentCB;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> tentCOL;

    private final ArrayList<AnimalOwner> animalOwnerList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalTypeCB.getItems().addAll("Cow", "Goat", "Sheep", "Buffalo", "Camel");
        selectTentCB.getItems().addAll("Tent 1", "Tent 2", "Tent 3", "Tent 4", "Tent 5");
        statusCB.getItems().addAll("Available", "Sold", "Reserved");

        animalIdCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalTypeCOL.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        entryDateCOl.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
        tentCOL.setCellValueFactory(new PropertyValueFactory<>("tent"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        ownerIdCOL.setCellValueFactory(new PropertyValueFactory<>("ownerID"));
        ownerNameCOL.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        if(searchTF.getText().isEmpty()){
            showAlert("Input Error","Please enter an Animal ID to search.");
            return;
        }

        if(animalTableView.getItems().isEmpty()){
            showAlert("No Data","No data available to search.");
            return;
        }

        ArrayList<AnimalOwner> searchResults = new ArrayList<>();
        String animalIdToSearch = searchTF.getText().trim();
        for (AnimalOwner ao : animalTableView.getItems()) {
            if (ao.getAnimalID().equalsIgnoreCase(animalIdToSearch)) {
                searchResults.add(ao);
            }
        }
        if (searchResults.isEmpty()) {
            showAlert("Not Found", "No animal found with ID: " + animalIdToSearch);
        } else {
            animalTableView.getItems().setAll(searchResults);
        }
        animalTableView.getItems().clear();
        animalTableView.getItems().addAll(searchResults);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String animalID = animalIdTF.getText().trim();
        String animalType = animalTypeCB.getValue();
        String breed = breedTF.getText().trim();
        int weight = 0;
        int age = 0;
        int askingPrice = 0;
        LocalDate entryDate = entryDateDatePicker.getValue();
        String color = colorTF.getText().trim();
        String tent = selectTentCB.getValue();
        String status = null;

        String ownerID = ownerIdTF.getText().trim();
        String ownerName = ownerNameTF.getText().trim();
        String ownerNID = ownerNidTF.getText().trim();
        String ownerAddress = ownerAddressTF.getText().trim();
        String ownerPhoneNumber = ownerPhone.getText().trim();

        try {
            weight = Integer.parseInt(weightTF.getText().trim());
            age = Integer.parseInt(ageTF.getText().trim());
            askingPrice = Integer.parseInt(askingPriceTF.getText().trim());
        } catch (Exception e) {
            showErrorAlert("Invalid Input", "Please enter valid numbers for weight, age, and asking price.");
            return;
        }

        if (animalID.isEmpty() || animalType == null || breed.isEmpty() || entryDate == null || color.isEmpty() || tent == null ||
                ownerID.isEmpty() || ownerName.isEmpty() || ownerNID.isEmpty() || ownerAddress.isEmpty() || ownerPhoneNumber.isEmpty()) {
            showAlert("Input Error", "Please fill all the required fields.");
            return;
        }
        for(AnimalOwner ao : animalTableView.getItems()) {
            if (ao.getAnimalID().equalsIgnoreCase(animalID)) {
                showAlert("Duplicate Entry", "An animal with ID: " + animalID + " already exists.");
                return;
            }
        }

        AnimalOwner newAnimalOwner = new AnimalOwner(animalID, animalType, breed, weight, age, askingPrice, entryDate, color, tent, null,
                ownerID, ownerName, ownerNID, ownerAddress, ownerPhoneNumber);
        animalOwnerList.add(newAnimalOwner);
        showAlert("Success", "Animal and Owner information saved successfully.");
        animalTableView.getItems().clear();
        animalTableView.getItems().addAll(animalOwnerList);
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }

    @javafx.fxml.FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {
        animalIdTF.clear();
        animalTypeCB.setValue(null);
        breedTF.clear();
        weightTF.clear();
        ageTF.clear();
        askingPriceTF.clear();
        entryDateDatePicker.setValue(null);
        colorTF.clear();
        selectTentCB.setValue(null);
        statusCB.setValue(null);
        ownerIdTF.clear();
        ownerNameTF.clear();
        ownerNidTF.clear();
        ownerAddressTF.clear();
        ownerPhone.clear();

    }

    @javafx.fxml.FXML
    public void statusSaveOnActionButton(ActionEvent actionEvent) {
        String animalIdToUpdate = statusAnimalIdTF.getText().trim();
        String status = statusCB.getValue();
        if (animalIdToUpdate.isEmpty() || status== null || status.isEmpty()) {
            showAlert("Input Error", "Please enter an Animal ID and select a new status.");
            return;
        }
        for(AnimalOwner ao : animalTableView.getItems()) {
            if (ao.getAnimalID().equalsIgnoreCase(animalIdToUpdate)) {
                ao.setStatus(status);
                animalTableView.refresh();
                showAlert("Success", "Status of Animal ID: " + animalIdToUpdate + " has been updated to " + status + ".");
                return;
            }
        }
        showAlert("Not Found", "No animal found with ID: " + animalIdToUpdate);
    }

    @javafx.fxml.FXML
    public void removeOnActionButton(ActionEvent actionEvent) {
        String animalIdToRemove = removeAnimalIdTF.getText().trim();
        if (animalIdToRemove.isEmpty()) {
            showAlert("Input Error", "Please enter an Animal ID to remove.");
            return;
        } else {
            boolean found = false;
            for (AnimalOwner ao : animalTableView.getItems()) {
                if (ao.getAnimalID().equalsIgnoreCase(animalIdToRemove)) {
                    animalTableView.getItems().remove(ao);
                    showAlert("Success", "Animal with ID: " + animalIdToRemove + " has been removed.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                showAlert("Not Found", "No animal found with ID: " + animalIdToRemove);
            }
        }
    }

    public  void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void showErrorAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
