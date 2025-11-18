package com.group9.kurbani_cattle_hut_management_system;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField passwordTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");

    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/signUp.fxml" );
    }
}