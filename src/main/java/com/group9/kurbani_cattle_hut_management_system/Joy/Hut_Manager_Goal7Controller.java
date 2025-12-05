package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Hut_Manager_Goal7Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> reasonToFlagCB;
    @javafx.fxml.FXML
    private ComboBox<String> flagActionCB;
    @javafx.fxml.FXML
    private ComboBox<String> userTypeCB;
    @javafx.fxml.FXML
    private CheckBox licenseCheckBox;
    @javafx.fxml.FXML
    private CheckBox nationalIDCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> blockActionCB;
    @javafx.fxml.FXML
    private CheckBox addressCheckBox;
    @javafx.fxml.FXML
    private TextField evidenceTF;
    @javafx.fxml.FXML
    private TextField flagSuspiciousUserIDTF;
    @javafx.fxml.FXML
    private TextField blockUserIDTF;
    @javafx.fxml.FXML
    private TextField verificationMessageTF;
    @javafx.fxml.FXML
    private CheckBox photoCheckBox;
    @javafx.fxml.FXML
    private TextField requestKYCUserIDTF;
    @javafx.fxml.FXML
    private TextField reasonToActionTF;
    @javafx.fxml.FXML
    private TextArea unblockTF1;
    @javafx.fxml.FXML
    private TextArea unblockTF2;

    @javafx.fxml.FXML
    public void initialize() {
        reasonToFlagCB.getItems().addAll("Fake Profile", "Suspicious Activity", "Inappropriate Content", "Other");
        flagActionCB.getItems().addAll("Warn User", "Temporary Suspension", "Permanent Ban");
        userTypeCB.getItems().addAll("Buyer", "Seller", "Both");
        blockActionCB.getItems().addAll("Temporary Block", "Permanent Block");


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
    public void blockOnActionButton(ActionEvent actionEvent) {
        String userID = blockUserIDTF.getText();
        String action = blockActionCB.getValue();
        String reason = reasonToActionTF.getText();

        if(userID.isEmpty() || action == null || reason.isEmpty()) {
            AlertUtil.showError("Input Error", "Please fill in all fields to block a user.");
            return;
        }
        AlertUtil.showInfo("Successfully","User " + userID + " has been " + action.toLowerCase() + " for reason: " + reason);
    }

    @javafx.fxml.FXML
    public void flagUserOnActionButton(ActionEvent actionEvent) {
        String userID = flagSuspiciousUserIDTF.getText();
        String reason = reasonToFlagCB.getValue();
        String action = flagActionCB.getValue();
        String evidence = evidenceTF.getText();

        if(userID.isEmpty() || reason == null || action == null || evidence.isEmpty()) {
            AlertUtil.showError("Input Error", "Please fill in all fields to flag a user.");
            return;
        }
        AlertUtil.showInfo("User Flagged","User " + userID + " has been flagged for " + reason + ". Action: " + action);
    }

    @javafx.fxml.FXML
    public void sendKYCOnActionButton(ActionEvent actionEvent) {
        String userID = requestKYCUserIDTF.getText();
        String userType = userTypeCB.getValue();
        boolean license = licenseCheckBox.isSelected();
        boolean nationalID = nationalIDCheckBox.isSelected();
        boolean address = addressCheckBox.isSelected();
        boolean photo = photoCheckBox.isSelected();
        String message = verificationMessageTF.getText();

        if(userID.isEmpty() || userType == null || message.isEmpty() ||
                (!license && !nationalID && !address && !photo)) {
            AlertUtil.showError("Input Error", "Please fill in all fields and select at least one document type to request KYC.");
            return;
        }
        AlertUtil.showInfo("KYC Request Sent","KYC request sent to User " + userID + " (" + userType + ").");
    }

    @javafx.fxml.FXML
    public void unblockOnActionButton2(ActionEvent actionEvent) {
        unblockTF2.clear();
        AlertUtil.showInfo("Unblock Successful","The user has been unblocked successfully.");
    }

    @javafx.fxml.FXML
    public void unblockOnActionButton1(ActionEvent actionEvent) {
        unblockTF1.clear();
        AlertUtil.showInfo("Unblock Successful","The user has been unblocked successfully.");
    }
}