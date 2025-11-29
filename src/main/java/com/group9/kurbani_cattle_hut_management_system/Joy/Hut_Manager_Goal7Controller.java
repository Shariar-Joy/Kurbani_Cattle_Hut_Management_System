package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    public void blockOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void flagUserOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void sendKYCOnActionButton(ActionEvent actionEvent) {
    }
}