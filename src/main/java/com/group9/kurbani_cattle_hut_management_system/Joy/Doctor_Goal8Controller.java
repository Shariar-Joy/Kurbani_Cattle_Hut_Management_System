package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

import java.io.IOException;

public class Doctor_Goal8Controller
{
    @javafx.fxml.FXML
    private CheckBox tuesdayCB;
    @javafx.fxml.FXML
    private CheckBox wednesdayCB;
    @javafx.fxml.FXML
    private CheckBox afternoonCB;
    @javafx.fxml.FXML
    private CheckBox eveningCB;
    @javafx.fxml.FXML
    private CheckBox mondayCB;
    @javafx.fxml.FXML
    private CheckBox thursdayCB;
    @javafx.fxml.FXML
    private CheckBox sundayCB;
    @javafx.fxml.FXML
    private CheckBox morningCB;

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
    public void saveOnActionButton(ActionEvent actionEvent) {
    }
}