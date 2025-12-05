package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
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
        String email = emailTF.getText();
        String password = passwordTF.getText();

        if(emailTF.getText() == null || emailTF.getText().trim().isEmpty() ||
                passwordTF.getText() == null || passwordTF.getText().trim().isEmpty()){
            showAlert("Error", "The Information is Missing");
            return;


        } if (email.equals("c") && password.equals("1234")) {
            com.group9.kurbani_cattle_hut_management_system.BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-view.fxml");


        } if (email.equals("l") && password.equals("1234")) {
            com.group9.kurbani_cattle_hut_management_system.BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");



        } else {
            showAlert("Error", "The Information is Invalid. Check your email and password.");
        }
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/signUp.fxml" );
    }


    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}