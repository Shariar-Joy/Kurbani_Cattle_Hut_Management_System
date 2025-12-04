package com.group9.kurbani_cattle_hut_management_system;

import com.group9.kurbani_cattle_hut_management_system.tanvir.seller.DashboardController;
import com.group9.kurbani_cattle_hut_management_system.tanvir.seller.Seller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginController {
    @javafx.fxml.FXML
    private TextField emailTF;
    @javafx.fxml.FXML
    private TextField passwordTF;
    @javafx.fxml.FXML
    private ComboBox<String> roleCB;

    @javafx.fxml.FXML
    public void initialize() {
        roleCB.getItems().addAll("Hut Manager (Admin)", "Veterinary Doctor (Animal Health Expert)", "Logistics Officer (Transport & Exit-Entry)", "Customer (Buyer)", "Seller (Farmer/Cattle Trader)", "Booking Officer (Tent/Spot Bookings)", "IT System Operator (Technical Support)", "Cattle Data Analyst/Research Officer");
    }

    @javafx.fxml.FXML
    public void loginOnActionButton(ActionEvent actionEvent) throws IOException {
        String email = emailTF.getText();
        String password = passwordTF.getText();

        if (emailTF.getText() == null || emailTF.getText().trim().isEmpty() ||
                passwordTF.getText() == null || passwordTF.getText().trim().isEmpty()) {
            showAlert("Error", "The Information is Missing");
            return;
        }

        String role = roleCB.getSelectionModel().getSelectedItem();
        if (role != null) {
            if (role.equals("Seller (Farmer/Cattle Trader)")) {
                if (validateLogin(email, password, BinFilePath.SELLER.getFilePath())) {
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    FXMLLoader loader =  new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/dashboard.fxml"));
                    Scene scene = new Scene(loader.load());
                    ((DashboardController)(loader.getController())).setInitData(email);
                    stage.setScene(scene);
                    stage.setTitle("Seller Dashboard");
                    stage.centerOnScreen();
                    stage.show();
                } else {
                    showAlert("Error", "Invalid Credentials");
                }
            }
            return;
        }

        if (email.equals("a") && password.equals("1234")) {
            BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");

        } else if (email.equals("d") && password.equals("1234")) {
            BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");

        } else {
            showAlert("Error", "The Information is Invalid. Check your email and password.");
        }
    }

    @javafx.fxml.FXML
    public void signUpOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/signUp.fxml");
    }


    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean validateLogin(String email, String password, String binFilePath) {
        try (
                FileInputStream fis = new FileInputStream(binFilePath);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            Seller seller = null;
            while (true) {
                seller = (Seller) ois.readObject();
                if (seller.getSellerEmail().equals(email) && seller.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [Bin File Read] %s\n", e.getMessage());
        }
        return false;
    }
}