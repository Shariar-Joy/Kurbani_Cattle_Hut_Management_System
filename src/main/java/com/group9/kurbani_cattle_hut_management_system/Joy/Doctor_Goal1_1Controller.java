package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Medical_Records;
import com.group9.kurbani_cattle_hut_management_system.Utils.FilesUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.IDStoreUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.RefreshUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;

public class Doctor_Goal1_1Controller
{
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TextField temperatureTF;
    @javafx.fxml.FXML
    private TextField breathingRateTF;
    @javafx.fxml.FXML
    private TextField symptomsTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;
    @javafx.fxml.FXML
    private TextField initialTF;
    @javafx.fxml.FXML
    private TextField pulseRateTF;
    @javafx.fxml.FXML
    private TextField behaviorTF;

    private final ArrayList<Medical_Records> medicalRecordsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        animalIDCB.setItems(IDStoreUtil.loadIDs("animals_ids.txt"));
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String animalID = animalIDCB.getValue();
        String temperature = temperatureTF.getText();
        String pulseRate = pulseRateTF.getText();
        String breathingRate = breathingRateTF.getText();
        String weight = weightTF.getText();
        String behavior = behaviorTF.getText();
        String symptoms = symptomsTF.getText();
        String initialDiagnosis = initialTF.getText();

        Medical_Records record = new Medical_Records(animalID, temperature, pulseRate, breathingRate, weight, behavior, symptoms, initialDiagnosis);

        medicalRecordsList.add(record);

        FilesUtil.saveObject("data/medical_records.bin", medicalRecordsList);
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void goBackToGoal1OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal1.fxml");
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(temperatureTF, pulseRateTF, breathingRateTF, weightTF, behaviorTF, symptomsTF, initialTF);
        RefreshUtil.clearComboBoxes(animalIDCB);
    }
}