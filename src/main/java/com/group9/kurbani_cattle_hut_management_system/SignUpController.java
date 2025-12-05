package com.group9.kurbani_cattle_hut_management_system;

import com.group9.kurbani_cattle_hut_management_system.tanvir.seller.Seller;
import com.group9.kurbani_cattle_hut_management_system.tanvir.seller.SignupController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController
{
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

    private final Alert alert =  new Alert(Alert.AlertType.WARNING);

    @javafx.fxml.FXML
    public void initialize() {
        roleCB.getItems().addAll("Hut Manager (Admin)","Veterinary Doctor (Animal Health Expert)", "Logistics Officer (Transport & Exit-Entry)", "Customer (Buyer)","Seller (Farmer/Cattle Trader)","Booking Officer (Tent/Spot Bookings)","IT System Operator (Technical Support)","Cattle Data Analyst/Research Officer");
    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) {
        String name = fullNameTF.getText();
        if (name == null || name.isEmpty()) {
            alert.setContentText("Name cannot be empty");
            alert.showAndWait();
            return;
        }

        String email = emailTF.getText();
        if (email == null || email.isEmpty()) {
            alert.setContentText("Email cannot be empty");
            alert.showAndWait();
            return;
        }

        String phone = phoneTF.getText();
        if (phone == null || phone.isEmpty()) {
            alert.setContentText("Phone number cannot be empty");
            alert.showAndWait();
            return;
        }
        if (phone.length() != 11) {
            alert.setContentText("Phone number should be 11 digits");
            alert.showAndWait();
            return;
        }

        String address = hutAddressTF.getText();
        if (address == null || address.isEmpty()) {
            alert.setContentText("Address cannot be empty");
            alert.showAndWait();
            return;
        }

        String password = passwordTF.getText();
        if (password == null || password.isEmpty()) {
            alert.setContentText("Password cannot be empty");
            alert.showAndWait();
            return;
        }

        String confirmPassword = confirmPasswordTF.getText();
        if (confirmPassword == null || confirmPassword.isEmpty()) {
            alert.setContentText("Confirm Password cannot be empty");
            alert.showAndWait();
            return;
        }
        if (!password.equals(confirmPassword)) {
            alert.setContentText("Passwords don't match");
            alert.showAndWait();
            return;
        }

        String role = roleCB.getSelectionModel().getSelectedItem();
        if (role == null || role.isEmpty()) {
            alert.setContentText("Role cannot be empty");
            alert.showAndWait();
            return;
        }

        if (role.equals("Seller (Farmer/Cattle Trader)")) {
            Seller newSeller = new Seller(name, email, phone, address, password, null, null);
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/signup.fxml"));

            try {
                Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

                AnchorPane anchorPane = loader.load();
                ((SignupController)loader.getController()).setInitialSignupSeller(newSeller);

                Scene scene = new Scene(anchorPane);
                stage.setTitle("Continue Seller Signup");
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } catch (Exception e) {
                System.out.printf("[Error] [Seller Signup] %s\n", e.getMessage());
            }
        }
    }
}