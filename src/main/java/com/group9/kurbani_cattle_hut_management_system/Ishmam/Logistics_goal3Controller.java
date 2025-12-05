package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logistics_goal3Controller
{
    @javafx.fxml.FXML
    private ComboBox animalCB;
    @javafx.fxml.FXML
    private TableColumn animalCOL;
    @javafx.fxml.FXML
    private ComboBox tentCB;
    @javafx.fxml.FXML
    private TableView todaysEntryTB;
    @javafx.fxml.FXML
    private TableColumn sellerCOL;
    @javafx.fxml.FXML
    private ToggleGroup HealthStatus;
    @javafx.fxml.FXML
    private ToggleGroup EntryType;
    @javafx.fxml.FXML
    private TextField animalIDTf;
    @javafx.fxml.FXML
    private TableColumn healthCOL;
    @javafx.fxml.FXML
    private TableColumn entryTypeCOL;
    @javafx.fxml.FXML
    private TableColumn timeCOL;
    @javafx.fxml.FXML
    private TableColumn animalIDCOL;
    @javafx.fxml.FXML
    private TextField sellerNameTF;
    @javafx.fxml.FXML
    private Label totalEntryLabel;
    @javafx.fxml.FXML
    private Label errorLabel;

    private ObservableList<EntryData> dataList;
    @javafx.fxml.FXML
    private RadioButton healthyCB;
    @javafx.fxml.FXML
    private RadioButton newArrivalRB;
    @javafx.fxml.FXML
    private RadioButton returnRB;
    @javafx.fxml.FXML
    private RadioButton injuredRB;
    @javafx.fxml.FXML
    private RadioButton sickRB;

    @javafx.fxml.FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();
        todaysEntryTB.setItems(dataList);

        timeCOL.setCellValueFactory(new PropertyValueFactory<>("time"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        sellerCOL.setCellValueFactory(new PropertyValueFactory<>("seller"));
        entryTypeCOL.setCellValueFactory(new PropertyValueFactory<>("entryType"));
        healthCOL.setCellValueFactory(new PropertyValueFactory<>("health"));

        ObservableList<String> animals = FXCollections.observableArrayList("Cow", "Sheep", "Goat", "Camel");
        animalCB.setItems(animals);

        ObservableList<String> tents = FXCollections.observableArrayList("Tent A", "Tent B", "Tent C", "Tent D");
        tentCB.setItems(tents);

        updateTotalLabel();
    }

    @javafx.fxml.FXML
    public void comfirmEntryCOL(ActionEvent actionEvent) {
        String animalID = animalIDTf.getText();
        String animal = (String) animalCB.getValue();
        String seller = sellerNameTF.getText();
        String entryType = "";
        String health = "";

        errorLabel.setText("");

        if (animalID.isEmpty()) {
            errorLabel.setText("Error: Animal ID cannot be empty!");
            return;
        }

        if (!animalID.matches("[0-9]+")) {
            errorLabel.setText("Error: Animal ID must contain only numbers!");
            return;
        }

        if (seller.isEmpty()) {
            errorLabel.setText("Error: Seller name cannot be empty!");
            return;
        }

        if (!seller.matches("[a-zA-Z ]+")) {
            errorLabel.setText("Error: Seller name must contain only letters and spaces!");
            return;
        }

        if (animal == null) {
            errorLabel.setText("Error: Please select an animal type!");
            return;
        }

        RadioButton selectedEntryType = (RadioButton) EntryType.getSelectedToggle();
        if (selectedEntryType != null) {
            entryType = selectedEntryType.getText();
        } else {
            errorLabel.setText("Error: Please select entry type!");
            return;
        }

        RadioButton selectedHealth = (RadioButton) HealthStatus.getSelectedToggle();
        if (selectedHealth != null) {
            health = selectedHealth.getText();
        } else {
            errorLabel.setText("Error: Please select health status!");
            return;
        }

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(formatter);

        EntryData data = new EntryData(time, animalID, animal, seller, entryType, health);
        dataList.add(data);

        errorLabel.setText("");
        animalIDTf.clear();
        animalCB.setValue(null);
        sellerNameTF.clear();
        EntryType.selectToggle(null);
        HealthStatus.selectToggle(null);

        updateTotalLabel();
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent)  throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    @javafx.fxml.FXML
    public void clearOA(ActionEvent actionEvent) {
        int selectedIndex = todaysEntryTB.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            dataList.remove(selectedIndex);
            updateTotalLabel();
        } else {

        }
    }

    private void updateTotalLabel() {
        int total = dataList.size();
        totalEntryLabel.setText("Total Entries: " + total);
    }

    public static class EntryData {
        private String time;
        private String animalID;
        private String animal;
        private String seller;
        private String entryType;
        private String health;

        public EntryData(String time, String animalID, String animal, String seller, String entryType, String health) {
            this.time = time;
            this.animalID = animalID;
            this.animal = animal;
            this.seller = seller;
            this.entryType = entryType;
            this.health = health;
        }

        public String getTime() {
            return time;
        }

        public String getAnimalID() {
            return animalID;
        }

        public String getAnimal() {
            return animal;
        }

        public String getSeller() {
            return seller;
        }

        public String getEntryType() {
            return entryType;
        }

        public String getHealth() {
            return health;
        }
    }
}