package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Treatment;
import com.group9.kurbani_cattle_hut_management_system.Utils.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor_Goal4Controller
{
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> startCOL;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> nextVisitCOL;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> medicineCOL;
    @javafx.fxml.FXML
    private ComboBox<String> followUpAnimalIDCB;
    @javafx.fxml.FXML
    private TableView<Treatment> treatmentTableView;
    @javafx.fxml.FXML
    private ComboBox<String> dosageDaysCB;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> diagnosisCOL;
    @javafx.fxml.FXML
    private TextField notesTF;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> timeCOL;
    @javafx.fxml.FXML
    private DatePicker nextVisitDatePicker;
    @javafx.fxml.FXML
    private TextField dosageTF;
    @javafx.fxml.FXML
    private ComboBox<String> updateAnimalIDCB;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> closeCaseAnimalIDCB;
    @javafx.fxml.FXML
    private ComboBox<String> expectedRecoveryCB;
    @javafx.fxml.FXML
    private TableColumn<Treatment, LocalDate> endCOL;
    @javafx.fxml.FXML
    private DatePicker durationStartDatePicker;
    @javafx.fxml.FXML
    private Button followUpOnActionButton;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> statusCOL;
    @javafx.fxml.FXML
    private ComboBox<String> dosageTimeCB;
    @javafx.fxml.FXML
    private TextField diagnosisTF;
    @javafx.fxml.FXML
    private TableColumn<Treatment,LocalDate> daysCOL;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> expectedRecoveryCOL;
    @javafx.fxml.FXML
    private ComboBox<String> updateCB;
    @javafx.fxml.FXML
    private TextField medicineTF;
    @javafx.fxml.FXML
    private DatePicker durationEndDatePicker;

    private final ArrayList<Treatment> treatmentList = new ArrayList<>();
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> dosageCOL;

    @javafx.fxml.FXML
    public void initialize() {
        animalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));
        followUpAnimalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));
        updateAnimalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));
        closeCaseAnimalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));

        dosageTimeCB.getItems().addAll("Morning", "Afternoon", "Evening", "Night");
        dosageDaysCB.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
        expectedRecoveryCB.getItems().addAll("Good", "Average", "Poor");
        updateCB.getItems().addAll("Recovered", "Under Treatment", "Critical");

        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        diagnosisCOL.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        medicineCOL.setCellValueFactory(new PropertyValueFactory<>("medication"));
        timeCOL.setCellValueFactory(new PropertyValueFactory<>("dosageTime"));
        daysCOL.setCellValueFactory(new PropertyValueFactory<>("dosageDays"));
        dosageCOL.setCellValueFactory(new PropertyValueFactory<>("dosage"));
        startCOL.setCellValueFactory(new PropertyValueFactory<>("durationStart"));
        endCOL.setCellValueFactory(new PropertyValueFactory<>("durationEnd"));
        nextVisitCOL.setCellValueFactory(new PropertyValueFactory<>("nextVisitDate"));
        expectedRecoveryCOL.setCellValueFactory(new PropertyValueFactory<>("expectedRecovery"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("updateStatus"));

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
    public void searchOnActionButton(ActionEvent actionEvent) {
        String id = searchTF.getText().trim();
        List<Treatment> results = SearchUtil.searchAndValidate(searchTF, treatmentList, Treatment::getAnimalID);
        treatmentTableView.getItems().setAll(results);
    }

    @javafx.fxml.FXML
    public void updateSaveOnActionButton(ActionEvent actionEvent) {
        String animalId = updateCB.getValue();
        String notes = notesTF.getText().trim();
        String updateStatus = updateCB.getValue();

        Treatment newUpdate = new Treatment(null, null, null, null, null, null, null, null, null, updateStatus);
        treatmentList.add(newUpdate);
        treatmentTableView.getItems().add(newUpdate);
        AlertUtil.showInfo("Success", "Treatment update record saved successfully.");

        FilesUtil.saveObject("data/treatments.bin", treatmentList);
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        String animalID = animalIDCB.getValue();
        String diagnosis = diagnosisTF.getText().trim();
        String medication = medicineTF.getText().trim();
        String dosage = dosageTF.getText().trim();
        String dosageTime = dosageTimeCB.getValue();
        String dosageDays = dosageDaysCB.getValue();
        LocalDate durationStart = durationStartDatePicker.getValue();
        LocalDate durationEnd = durationEndDatePicker.getValue();

        Treatment newTreatment = new Treatment(diagnosis, medication, dosage, dosageTime, dosageDays, durationStart, durationEnd, null, null, null);
        treatmentList.add(newTreatment);
        treatmentTableView.getItems().add(newTreatment);
        AlertUtil.showInfo("Success", "Treatment record saved successfully.");
        FilesUtil.saveObject("data/treatments.bin", treatmentList);
    }

    @javafx.fxml.FXML
    public void followUpSaveOnActionButton(ActionEvent actionEvent) {
        String animalID = followUpAnimalIDCB.getValue();
        LocalDate nextVisitDate = nextVisitDatePicker.getValue();
        String expectedRecovery = expectedRecoveryCB.getValue();
        String updateStatus = notesTF.getText().trim();

        Treatment newFollowUp = new Treatment(null, null, null, null, null, null, null, nextVisitDate, expectedRecovery, updateStatus);
        treatmentList.add(newFollowUp);
        treatmentTableView.getItems().add(newFollowUp);
        AlertUtil.showInfo("Success", "Follow-up record saved successfully.");
        FilesUtil.saveObject("data/treatments.bin", treatmentList);
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(diagnosisTF, medicineTF, dosageTF);
        RefreshUtil.clearComboBoxes(animalIDCB, dosageTimeCB, dosageDaysCB);
        RefreshUtil.clearDatePickers(durationStartDatePicker, durationEndDatePicker);
    }

    @javafx.fxml.FXML
    public void closeCaseOnActionButton(ActionEvent actionEvent) {
        String animalID = closeCaseAnimalIDCB.getValue();

        if(animalID == null || animalID.isEmpty()) {
            AlertUtil.showError("Input Error", "Please select an Animal ID to close case.");
            return;
        } else {
            Treatment treatmentToClose = null;
            for (Treatment treatment : treatmentTableView.getItems()) {
                if (treatment.getAnimalID().equalsIgnoreCase(animalID)) {
                    treatmentToClose = treatment;
                    break;
                }
            }
            if (treatmentToClose != null) {
                treatmentTableView.getItems().remove(treatmentToClose);
                treatmentList.remove(treatmentToClose);

                AlertUtil.showInfo("Success",
                        "Treatment case for Animal ID: " + animalID + " has been closed and removed.");
            } else {
                AlertUtil.showError("Not Found",
                        "No treatment record found for Animal ID: " + animalID);
            }
        }
    }
}