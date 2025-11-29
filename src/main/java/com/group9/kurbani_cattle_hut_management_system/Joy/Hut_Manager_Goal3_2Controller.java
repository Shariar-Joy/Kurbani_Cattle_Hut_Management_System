package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Hut_Manager_Goal3_2Controller
{
    @javafx.fxml.FXML
    private TextField ownerPhone;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private TextField ownerAddressTF;

    @javafx.fxml.FXML
    public void initialize() {
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
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }
}