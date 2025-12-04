package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Utils.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hut_Manager_Goal6Controller
{
    @FXML
    private TextField recordAmountTF;
    @FXML
    private ComboBox<String> paymentMethodCB;
    @FXML
    private TextField refundAmountTF;
    @FXML
    private ComboBox<String> recordBookingIDCB;
    @FXML
    private ComboBox<String> refundBookingIDCB;
    @FXML
    private TextField reasonToRefundTF;
    @FXML
    private PieChart pieChart;

    @FXML
    public void initialize() {
        paymentMethodCB.getItems().addAll("Cash","Card","Online Banking","Mobile Payment");

        recordBookingIDCB.setItems(IDStoreUtil.loadIDs("booking_ids.txt"));
        refundBookingIDCB.setItems(IDStoreUtil.loadIDs("booking_ids.txt"));
    }

    @FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }

    @FXML
    public void refundOnActionButton(ActionEvent actionEvent) {
        String amount = refundAmountTF.getText();
        String bookingID = refundBookingIDCB.getValue();
        String reason = reasonToRefundTF.getText();

        if(amount.isEmpty() || bookingID == null || reason.isEmpty()) {
            AlertUtil.showError("Error", "Please fill in all fields to process a refund.");
            return;
        }

        AlertUtil.showInfo("Success", "Refund of " + amount + " processed successfully for Booking ID: " + bookingID);


    }

    @FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(recordAmountTF,refundAmountTF,reasonToRefundTF);
        RefreshUtil.clearComboBoxes(paymentMethodCB,recordBookingIDCB,refundBookingIDCB);

    }

    @FXML
    public void recordPaymentOnActionButton(ActionEvent actionEvent) {
        String amount = recordAmountTF.getText();
        String paymentMethod = paymentMethodCB.getValue();
        String bookingID = recordBookingIDCB.getValue();

        if(amount.isEmpty() || paymentMethod == null || bookingID == null) {
            AlertUtil.showError("Error", "Please fill in all fields to record a payment.");
            return;
        }
        AlertUtil.showInfo("Success", "Payment of " + amount + " recorded successfully for Booking ID: " + bookingID);



    }

    @FXML
    public void chartOnActionButton(ActionEvent actionEvent) {
        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("Received",5000));
        pieChart.getData().add(new PieChart.Data("Refund",3000));
        pieChart.getData().add(new PieChart.Data("Total",2000));
    }
}