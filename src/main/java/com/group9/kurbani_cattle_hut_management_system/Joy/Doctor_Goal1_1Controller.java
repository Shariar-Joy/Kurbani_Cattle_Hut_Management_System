package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.*;

import java.io.IOException;

public class Doctor_Goal1_1Controller
{
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField temperatureTF;
    @javafx.fxml.FXML
    private Button refreshOnActionButton;
    @javafx.fxml.FXML
    private TextField breathingRateTF;
    @javafx.fxml.FXML
    private TextField symptomsTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;
    @javafx.fxml.FXML
    private TextField initialTF;
    @javafx.fxml.FXML
    private TextField pulseRateTF;
    @javafx.fxml.FXML
    private TextField behaviorTF;

    @javafx.fxml.FXML
    public void initialize() {
        animalIDCB.getItems().addAll("A001","A002","A003","A004","A005");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void goBackAnimalListOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal1.fxml");
    }
}