package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Certificate;
import com.group9.kurbani_cattle_hut_management_system.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.FilesUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.IDGenerator;
import com.group9.kurbani_cattle_hut_management_system.Utils.RefreshUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor_Goal5_1Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> overallConditionCB;
    @javafx.fxml.FXML
    private CheckBox requiredTestsCheckBox;
    @javafx.fxml.FXML
    private CheckBox vaccinationCheckBox;
    @javafx.fxml.FXML
    private TextField remarksTF;
    @javafx.fxml.FXML
    private CheckBox behaviorCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private CheckBox physicalInspectionCheckBox;
    @javafx.fxml.FXML
    private TextField finalWeightTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIdCB;
    @javafx.fxml.FXML
    private DatePicker dateDatepicker;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TextField doctorNameTF;

    final private ArrayList<Certificate> certificateList = new ArrayList<>();
    final private ArrayList<String> clearanceRecords = new ArrayList<>();
    @javafx.fxml.FXML
    private TextField certificateTF;

    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Fit to Sell","Unfit to Sell");
        overallConditionCB.getItems().addAll("1","2","3","4","5","6","7","8","9","10");

    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveClearanceOnActionButton(ActionEvent actionEvent) {
        String physicalInspection = physicalInspectionCheckBox.isSelected() ? "Yes" : "No";
        String behavior = behaviorCheckBox.isSelected() ? "Normal" : "Abnormal";
        String requiredTests = requiredTestsCheckBox.isSelected() ? "Completed" : "Pending";
        String vaccination = vaccinationCheckBox.isSelected() ? "Up to Date" : "Not Up to Date";
        String status = statusCB.getValue();

        if(animalIdCB.getValue() == null || overallConditionCB.getValue() == null || finalWeightTF.getText().isEmpty() || doctorNameTF.getText().isEmpty() || dateDatepicker.getValue() == null) {
            AlertUtil.showError("Error", "Please fill in all required fields.");
            return;
        }
        String record = "Animal ID: " + animalIdCB.getValue() +
                ", Physical Inspection: " + physicalInspection +
                ", Behavior: " + behavior +
                ", Required Tests: " + requiredTests +
                ", Vaccination: " + vaccination +
                ", Overall Condition: " + overallConditionCB.getValue() +
                ", Final Weight: " + finalWeightTF.getText() +
                ", Doctor Name: " + doctorNameTF.getText() +
                ", Date: " + dateDatepicker.getValue() +
                ", Status: " + status +
                ", Remarks: " + remarksTF.getText();
        clearanceRecords.add(record);
        AlertUtil.showInfo("Success", "Clearance record saved successfully.");

    }

    @javafx.fxml.FXML
    public void saveCertificateOnActionButton(ActionEvent actionEvent) {

        String certificateID = IDGenerator.generateCertificateID();
        certificateTF.setText(certificateID);
        String animalID = animalIdCB.getValue();
        String doctorName = doctorNameTF.getText();
        LocalDate date = dateDatepicker.getValue();
        String finalWeight = finalWeightTF.getText();
        String breed = breedTF.getText();
        String remarks = remarksTF.getText();
        int overallCondition = 0;

        try{
            overallCondition = Integer.parseInt(overallConditionCB.getValue());
        } catch (NumberFormatException e) {
            AlertUtil.showError("Error", "Overall Condition must be a number.");
            return;
        }

        if(animalID == null || doctorName.isEmpty() || date == null || finalWeight.isEmpty() || breed.isEmpty() || overallCondition == 0) {
            AlertUtil.showError("Error", "Please fill in all required fields.");
            return;
        }

        Certificate certificate = new Certificate(certificateID, finalWeight, breed,overallCondition, doctorName, date);
        certificateList.add(certificate);

        AlertUtil.showInfo("Success", "Certificate saved successfully.");

        FilesUtil.saveObject("data/certificates.bin", certificateList);
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(finalWeightTF,breedTF,doctorNameTF,remarksTF,certificateTF);
        RefreshUtil.clearComboBoxes(animalIdCB,overallConditionCB,statusCB);
    }

    @javafx.fxml.FXML
    public void goBackToGoal5OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal5.fxml");
    }
}