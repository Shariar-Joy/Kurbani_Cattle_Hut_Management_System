package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Doctor_Goal1Controller
{
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalTypeCOL;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> animalTableView;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner, LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> tentCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalIdCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private Button refreshOnActionButton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void formOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal1_1.fxml");
    }
}