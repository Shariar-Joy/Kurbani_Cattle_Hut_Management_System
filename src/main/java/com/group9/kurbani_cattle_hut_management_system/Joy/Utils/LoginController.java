package com.group9.kurbani_cattle_hut_management_system.Joy.Utils;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController
{
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private PasswordField passwordTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) throws IOException {
        String email = emailTF.getText();
        String password = passwordTF.getText();
        
        if(emailTF.getText().trim().isEmpty() || passwordTF.getText().trim().isEmpty()){
                AlertUtil.showError("Error", "The Information is Missing");
                return;
        }
        if (email.equals("admin@gmail.com") && password.equals("12345")) {
            BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
        } else if (email.equals("doctor@gmail.com") && password.equals("12345")) {
            BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
        }else {
            AlertUtil.showError("Error", "The Information is Invalid. Check your email and password.");
        }
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/signUp.fxml");
    }
}