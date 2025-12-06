package com.group9.kurbani_cattle_hut_management_system.Joy.Utils;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.User;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SignUpController {
    @javafx.fxml.FXML
    private TextField fullNameTF;
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private ComboBox<String> roleCB;
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField hutAddressTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private TextField confirmPasswordTF;

    private final ArrayList<User> userList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        roleCB.getItems().addAll("Admin","Doctor");

    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/login.fxml");
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) throws IOException {
        String fullName = fullNameTF.getText().trim();
        String phone = phoneTF.getText().trim();
        String role = roleCB.getValue();
        String email = emailTF.getText().trim();
        String hutAddress = hutAddressTF.getText().trim();
        String password = passwordTF.getText();
        String confirmPassword = confirmPasswordTF.getText();

        if (fullName.isEmpty() || phone.isEmpty() || role == null || email.isEmpty() || hutAddress.isEmpty() || password.isEmpty()) {
            AlertUtil.showError("Error", "All fields are required!");
        }
        if (!phone.matches("\\d{10,15}")) {
            AlertUtil.showError("Validation Error", "Phone number must be 10-15 digits!");
            return;

        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            AlertUtil.showError("Validation Error", "Please enter a valid email address!");
            return;
        }
        if (password.length() < 6) {
            AlertUtil.showError("Validation Error", "Password must be at least 6 characters long!");
            return;
        }
        if (!password.equals(confirmPassword)) {
            AlertUtil.showError("Validation Error", "Passwords do not match!");
            return;
        }
        User user = new User(fullName, phone, role, email, hutAddress, password);

        userList.add(user);

        File file = new File("data/users.bin");
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
            AlertUtil.showInfo("Success","File Saved");
        } catch (IOException e){
            e.getStackTrace();
        }

        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/login.fxml");


    }
}