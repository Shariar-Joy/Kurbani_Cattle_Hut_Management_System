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

public class Logistics_goal2Controller
{
    @javafx.fxml.FXML
    private TextField animalIDTF;
    @javafx.fxml.FXML
    private ComboBox animalCB;
    @javafx.fxml.FXML
    private TableColumn animalCOL;
    @javafx.fxml.FXML
    private TableView exitInfoTV;
    @javafx.fxml.FXML
    private TextField buyerNameTF;
    @javafx.fxml.FXML
    private TableColumn buyerCOL;
    @javafx.fxml.FXML
    private TableColumn reasonOfexitCOL;
    @javafx.fxml.FXML
    private ComboBox reasonCB;
    @javafx.fxml.FXML
    private TableColumn timeCOL;
    @javafx.fxml.FXML
    private TableColumn animalIDCOL;
    @javafx.fxml.FXML
    private Label errorLabel;

    private ObservableList<ExitData> dataList;


    @javafx.fxml.FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();
        exitInfoTV.setItems(dataList);

        timeCOL.setCellValueFactory(new PropertyValueFactory<>("time"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        buyerCOL.setCellValueFactory(new PropertyValueFactory<>("buyer"));
        reasonOfexitCOL.setCellValueFactory(new PropertyValueFactory<>("reason"));

        ObservableList<String> animals = FXCollections.observableArrayList("Cow", "Sheep", "Goat", "Camel");
        animalCB.setItems(animals);

        ObservableList<String> reasons = FXCollections.observableArrayList("Sold", "Quarantine", "Shift");
        reasonCB.setItems(reasons);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    @javafx.fxml.FXML
    public void authorizeOA(ActionEvent actionEvent) {
        String animalID = animalIDTF.getText();
        String animal = (String) animalCB.getValue();
        String buyer = buyerNameTF.getText();
        String reason = (String) reasonCB.getValue();

        if (animalID.isEmpty() || animal == null || buyer.isEmpty() || reason == null) {
            errorLabel.setText("Please fill all fields!");
            return;
        }

        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(formatter);

        ExitData data = new ExitData(time, animalID, animal, buyer, reason);
        dataList.add(data);

        animalIDTF.clear();
        animalCB.setValue(null);
        buyerNameTF.clear();
        reasonCB.setValue(null);

        errorLabel.setText("Entry added!");
    }

    public static class ExitData {
        private String time;
        private String animalID;
        private String animal;
        private String buyer;
        private String reason;

        public ExitData(String time, String animalID, String animal, String buyer, String reason) {
            this.time = time;
            this.animalID = animalID;
            this.animal = animal;
            this.buyer = buyer;
            this.reason = reason;
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

        public String getBuyer() {
            return buyer;
        }

        public String getReason() {
            return reason;
        }
    }
}