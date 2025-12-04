package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    private String sellerEmail = null;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setInitData(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    @javafx.fxml.FXML
    public void handleManageInventory(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/inventory.fxml"));
        AnchorPane pane = loader.load();
        ((InventoryController)loader.getController()).setInitData(sellerEmail);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleManageMedicalRecords(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/manage-medical-record.fxml"));
        AnchorPane pane = loader.load();
        ((ManageMedicalRecordController)loader.getController()).setInitData(sellerEmail);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleTentBooking(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/manage-tent-booking.fxml"));
        AnchorPane pane = loader.load();
        ((TentBookingController)loader.getController()).setInitData(sellerEmail);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}