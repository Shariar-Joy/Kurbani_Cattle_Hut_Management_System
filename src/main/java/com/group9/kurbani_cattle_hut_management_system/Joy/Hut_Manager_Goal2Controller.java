package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class Hut_Manager_Goal2Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> directionCB;
    @javafx.fxml.FXML
    private TableColumn<String,Tent> tentIdCOL;
    @javafx.fxml.FXML
    private TextField totalCapacityTF;
    @javafx.fxml.FXML
    private TextField removeTentIdTF;
    @javafx.fxml.FXML
    private TableColumn<String,Tent> directionCOL;
    @javafx.fxml.FXML
    private ComboBox<String> tentIdCB;
    @javafx.fxml.FXML
    private TableColumn<Integer, Tent> freeSlotsCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIdCB;
    @javafx.fxml.FXML
    private TextField reasonToRemoveTF;
    @javafx.fxml.FXML
    private TableColumn<Integer, Tent> totalCapacityCOL;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TableColumn<Integer, Tent> occupiedSlotsCOL;
    @javafx.fxml.FXML
    private TextField tentIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<String, Tent> statusCOL;
    @javafx.fxml.FXML
    private TextField totalCapacityTF1;

    @javafx.fxml.FXML
    public void initialize() {
        directionCB.getItems().addAll("East","West","North","South");
        statusCB.getItems().addAll("Full","Free","Maintenance","Occupied");
        animalIdCB.getItems().addAll("");
        tentIdCB.getItems().addAll("Tent 1","Tent 2", "Tent 3", "Tent 4", "Tent 5");

    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void AddOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void moveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void exportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }

    @javafx.fxml.FXML
    public void removeOnActionButton(ActionEvent actionEvent) {
    }
}