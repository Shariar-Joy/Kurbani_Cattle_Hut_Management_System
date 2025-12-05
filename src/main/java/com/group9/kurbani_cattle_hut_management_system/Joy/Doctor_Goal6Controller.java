package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.IDStoreUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Doctor_Goal6Controller
{
    @javafx.fxml.FXML
    private TextField symptoms;
    @javafx.fxml.FXML
    private ComboBox<String> severityLevelCB;
    @javafx.fxml.FXML
    private ComboBox<String> tentIDCB;
    @javafx.fxml.FXML
    private ComboBox<String> outcomeCB;
    @javafx.fxml.FXML
    private TextField temperatureTF;
    @javafx.fxml.FXML
    private TextField immediateActionTF;
    @javafx.fxml.FXML
    private TextField notesTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;

    @javafx.fxml.FXML
    public void initialize() {
        outcomeCB.getItems().addAll("Recovered", "Under Treatment", "Deceased");
        severityLevelCB.getItems().addAll("Low", "Medium", "High", "Critical");
        tentIDCB.setItems(IDStoreUtil.loadIDs("tent_ids.txt"));
        animalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void completeOnActionButton(ActionEvent actionEvent) {
        String notes = notesTF.getText();
        String outcome = outcomeCB.getValue();

        if(notes.isEmpty() || outcome == null) {
            AlertUtil.showError("Error", "Please fill in all required fields.");
            return;
        }else {
            AlertUtil.showInfo("Success", "Medical report completed successfully.");
        }

    }


    @javafx.fxml.FXML
    public void emergencyReportOnActionButton(ActionEvent actionEvent) {
        String temperature = temperatureTF.getText();
        String symptomsText = symptoms.getText();
        String action = immediateActionTF.getText();

        if(temperature.isEmpty() || symptomsText.isEmpty() || action.isEmpty()) {
            AlertUtil.showError("Error", "Please fill in all required fields.");
            return;
        }else {
            AlertUtil.showInfo("Success", "Emergency report submitted successfully.");
        }
    }

    @javafx.fxml.FXML
    public void acknowledgeOnActionButton(ActionEvent actionEvent) {
        String tentID = tentIDCB.getValue();
        String severity = severityLevelCB.getValue();
        String animalID = animalIDCB.getValue();
        if(tentID == null || severity == null || animalID == null) {
            AlertUtil.showError("Error", "Please fill in all required fields.");
            return;
        }else {
            AlertUtil.showInfo("Success", "Quarantine acknowledged successfully."); }
    }
}