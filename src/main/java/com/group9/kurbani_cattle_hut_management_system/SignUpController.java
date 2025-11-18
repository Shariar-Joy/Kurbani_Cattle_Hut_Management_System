package com.group9.kurbani_cattle_hut_management_system;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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

    @javafx.fxml.FXML
    public void initialize() {
        roleCB.getItems().addAll("Hut Manager (Admin)","Veterinary Doctor (Animal Health Expert)", "Logistics Officer (Transport & Exit-Entry)", "Customer (Buyer)","Seller (Farmer/Cattle Trader)","Booking Officer (Tent/Spot Bookings)","IT System Operator (Technical Support)","Cattle Data Analyst/Research Officer");
    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) {
    }
}