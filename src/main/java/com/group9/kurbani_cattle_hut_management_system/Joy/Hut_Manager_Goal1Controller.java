package com.group9.kurbani_cattle_hut_management_system.Joy;


import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Owner;
import com.group9.kurbani_cattle_hut_management_system.Utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hut_Manager_Goal1Controller {

    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<Animal,LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalTypeCB;
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalTypeCOL;
    @javafx.fxml.FXML
    private DatePicker exitDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Animal> animalTableView;
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
    private TextField statusAnimalIdTF;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIdCOL;
    @javafx.fxml.FXML
    private TextField reasonToRemoveTF;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> statusCOL;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private ComboBox<String> selectTentCB;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> tentCOL;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @FXML
    private TextField searchOwnerTF;
    @FXML
    private TableColumn<Owner,String> ownerAddressCOL;
    @FXML
    private TextField searchAnimalTF;
    @FXML
    private TableColumn<Owner,String> ownerNIDCOL;
    @FXML
    private TableColumn<Animal,Integer> ageCOL;
    @FXML
    private TableView<Owner> ownerTableView;
    @FXML
    private TableColumn<Owner,String> ownerPhoneCOL;
    @FXML
    private TableColumn<Animal,Integer> weightCOL;


    private final ArrayList<Animal> animalList = new ArrayList<>();
    private final ArrayList<Owner> ownerList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalTypeCB.getItems().addAll("Cow", "Goat", "Sheep", "Buffalo", "Camel");
        selectTentCB.getItems().addAll("Tent 1", "Tent 2", "Tent 3", "Tent 4", "Tent 5");
        statusCB.getItems().addAll("Available", "Sold", "Reserved");

        animalIdCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalTypeCOL.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        weightCOL.setCellValueFactory(new PropertyValueFactory<>("weight"));
        ageCOL.setCellValueFactory(new PropertyValueFactory<>("age"));
        entryDateCOl.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
        tentCOL.setCellValueFactory(new PropertyValueFactory<>("tent"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));

        ownerIdCOL.setCellValueFactory(new PropertyValueFactory<>("ownerID"));
        ownerNameCOL.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        ownerNIDCOL.setCellValueFactory(new PropertyValueFactory<>("ownerNID"));
        ownerAddressCOL.setCellValueFactory(new PropertyValueFactory<>("ownerAddress"));
        ownerPhoneCOL.setCellValueFactory(new PropertyValueFactory<>("ownerPhone"));
    }



    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @FXML
    public void saveOnActionButton(ActionEvent actionEvent) {

        String animalID = IDGenerator.generateAnimalID();
        animalIdTF.setText(animalID);
        IDStoreUtil.saveID("animal_ids.txt", animalID);
        String animalType = animalTypeCB.getValue();
        String breed = breedTF.getText().trim();
        int weight = 0;
        int age = 0;
        int askingPrice = 0;
        LocalDate entryDate = entryDateDatePicker.getValue();
        String color = colorTF.getText().trim();
        String tent = selectTentCB.getValue();
        String status = null;
        try {
            weight = Integer.parseInt(weightTF.getText().trim());
            age = Integer.parseInt(ageTF.getText().trim());
            askingPrice = Integer.parseInt(askingPriceTF.getText().trim());
        } catch (Exception e) {
            AlertUtil.showError("Invalid Input", "Please enter valid numbers for weight, age, and asking price.");
            return;
        }

        String ownerID = IDGenerator.generateOwnerID();
        ownerIdTF.setText(ownerID);
        IDStoreUtil.saveID("owner_ids.txt", ownerID);

        String ownerName = ownerNameTF.getText().trim();
        String ownerNID = ownerNidTF.getText().trim();
        String ownerAddress = ownerAddressTF.getText().trim();
        String ownerPhoneNumber = ownerPhone.getText().trim();


        if (animalID.isEmpty() || animalType == null || breed.isEmpty() || entryDate == null || color.isEmpty() || tent == null ||
                ownerID.isEmpty() || ownerName.isEmpty() || ownerNID.isEmpty() || ownerAddress.isEmpty() || ownerPhoneNumber.isEmpty()) {
            AlertUtil.showError("Input Error", "Please fill all the required fields.");
            return;
        }

        Animal newAnimal = new Animal(animalID, animalType, breed, weight, age, askingPrice, entryDate, color, tent, null);
        Owner newOwner = new Owner(ownerID, ownerName, ownerNID, ownerAddress, ownerPhoneNumber);
        animalList.add(newAnimal);
        ownerList.add(newOwner);
        AlertUtil.showInfo("Success", "Animal and Owner information saved successfully.");
        animalTableView.getItems().clear();
        animalTableView.getItems().addAll(animalList);
        ownerTableView.getItems().addAll(ownerList);

        FilesUtil.saveObject("data/animals.bin", animalList);
        FilesUtil.saveObject("data/owners.bin", ownerList);

    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }

    @javafx.fxml.FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(breedTF,weightTF,ageTF,askingPriceTF,colorTF,
                ownerNameTF,ownerNidTF,ownerAddressTF,ownerPhone);
        RefreshUtil.clearDatePickers(entryDateDatePicker,exitDateDatePicker);
        RefreshUtil.clearComboBoxes(animalTypeCB,selectTentCB,statusCB);


    }

    @javafx.fxml.FXML
    public void statusSaveOnActionButton(ActionEvent actionEvent) {
        String animalIdToUpdate = statusAnimalIdTF.getText().trim();
        String newStatus = statusCB.getValue();
        if (animalIdToUpdate.isEmpty() || newStatus == null) {
            AlertUtil.showError("Input Error", "Please enter an Animal ID and select a new status.");
            return;
        }
        boolean found = false;
        for (Animal ao : animalTableView.getItems()) {
            if (ao.getAnimalID().equalsIgnoreCase(animalIdToUpdate)) {
                ao.setStatus(newStatus);
                animalTableView.refresh();
                AlertUtil.showInfo("Success", "Animal ID: " + animalIdToUpdate + " status updated to " + newStatus + ".");
                found = true;
                break;
            }
        }
        if(!found) {
            AlertUtil.showError("Not Found", "Animal ID: " + animalIdToUpdate + " not found.");
        }
        FilesUtil.saveObject("data/animals.bin", animalList);
    }

    @javafx.fxml.FXML
    public void removeOnActionButton(ActionEvent actionEvent) {
        String animalIdToRemove = removeAnimalIdTF.getText().trim();
        String reasonToRemove = reasonToRemoveTF.getText().trim();
        if (animalIdToRemove.isEmpty() || reasonToRemove.isEmpty()) {
            AlertUtil.showError("Input Error", "Please enter an Animal ID and reason to remove.");
            return;
        }
        boolean found = false;
        for (Animal ao : animalTableView.getItems()) {
            if (ao.getAnimalID().equalsIgnoreCase(animalIdToRemove)) {
                animalTableView.getItems().remove(ao);
                AlertUtil.showInfo("Success", "Animal ID: " + animalIdToRemove + " has been removed for reason: " + reasonToRemove + ".");
                found = true;
                break;
            }
        }
        if(!found) {
            AlertUtil.showError("Not Found", "Animal ID: " + animalIdToRemove + " not found.");
        }
        boolean ownerFound = false;
        for (Owner ow : ownerTableView.getItems()) {
            if (ow.getOwnerID().equalsIgnoreCase(animalIdToRemove)) {
                ownerTableView.getItems().remove(ow);
                ownerFound = true;
                break;
            }
        }
        if(!ownerFound) {
            AlertUtil.showError("Not Found", "Owner ID: " + animalIdToRemove + " not found.");
        }
    }

    @FXML
    public void searchAnimalOnActionButton(ActionEvent actionEvent) {
        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchAnimalTF, animalTableView.getItems(), Animal::getAnimalID);
        animalTableView.getItems().clear();
        animalTableView.getItems().addAll(searchAnimalResults);
    }

    @FXML
    public void searchOwnerOnActionButton(ActionEvent actionEvent) {
        List<Owner> searchOwnerResults = SearchUtil.searchAndValidate(searchOwnerTF, ownerTableView.getItems(), Owner::getOwnerID);
        ownerTableView.getItems().clear();
        ownerTableView.getItems().addAll(searchOwnerResults);
    }

    @FXML
    public void loadAnimalOnActionButton(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/animals.bin");
        animalTableView.getItems().addAll((Animal) list);
        List<Object> list1 = FilesUtil.readObjects("data/owners.bin");
        ownerTableView.getItems().addAll((Owner) list1);
    }

    @FXML
    public void loadOwnerOnActionButton(ActionEvent actionEvent) {
        /*        FileUtil.readText("owners.txt", ownerTableView);*/
    }
}
