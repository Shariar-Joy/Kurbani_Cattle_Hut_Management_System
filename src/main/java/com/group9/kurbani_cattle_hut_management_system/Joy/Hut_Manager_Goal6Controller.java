package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Hut_Manager_Goal6Controller
{
    @javafx.fxml.FXML
    private TextField recordAmountTF;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodCB;
    @javafx.fxml.FXML
    private TextField refundAmountTF;
    @javafx.fxml.FXML
    private ComboBox<String> recordBookingIDCB;
    @javafx.fxml.FXML
    private ComboBox<String> refundBookingIDCB;
    @javafx.fxml.FXML
    private TextField reasonToRefundTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }

    @javafx.fxml.FXML
    public void refundOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void recordPaymentOnActionButton(ActionEvent actionEvent) {
    }
}