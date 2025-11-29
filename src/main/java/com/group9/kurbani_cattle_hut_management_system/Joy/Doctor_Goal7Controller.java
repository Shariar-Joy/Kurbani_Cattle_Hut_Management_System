package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class Doctor_Goal7Controller
{
    @javafx.fxml.FXML
    private TableColumn startCOL;
    @javafx.fxml.FXML
    private TableColumn statusCOL1;
    @javafx.fxml.FXML
    private TableColumn nextVisitCOL;
    @javafx.fxml.FXML
    private TableColumn medicineCOL;
    @javafx.fxml.FXML
    private TableView vaccinationTableView;
    @javafx.fxml.FXML
    private TableView quarantineTableView;
    @javafx.fxml.FXML
    private TableColumn durationCOL;
    @javafx.fxml.FXML
    private TableColumn tempCOl;
    @javafx.fxml.FXML
    private TableColumn pulseCOl;
    @javafx.fxml.FXML
    private TableColumn medicineCOL1;
    @javafx.fxml.FXML
    private TableColumn doseNumberCOl;
    @javafx.fxml.FXML
    private TableColumn diagnosisCOL;
    @javafx.fxml.FXML
    private TableView medicalRecordTableView;
    @javafx.fxml.FXML
    private TableColumn dateAdministeredCOL;
    @javafx.fxml.FXML
    private TableColumn timeCOL;
    @javafx.fxml.FXML
    private TableColumn medicalRecordAnimalIDCOL;
    @javafx.fxml.FXML
    private TableColumn expectedRecoveryCOL;
    @javafx.fxml.FXML
    private TableColumn diseaseCOL;
    @javafx.fxml.FXML
    private TableColumn dosageCOL;
    @javafx.fxml.FXML
    private TableColumn breathingCOL;
    @javafx.fxml.FXML
    private TableColumn isolationTentCOL;
    @javafx.fxml.FXML
    private TableColumn weightCOL;
    @javafx.fxml.FXML
    private TableColumn nextDueDateCOL;
    @javafx.fxml.FXML
    private TableColumn endCOL;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private TableColumn daysCOL;
    @javafx.fxml.FXML
    private TableView treatmentTableView;
    @javafx.fxml.FXML
    private TableColumn animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn vaccineNameCOL;
    @javafx.fxml.FXML
    private TableColumn symptomsCOL;
    @javafx.fxml.FXML
    private TableColumn isolationTimeCOL;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void medicalReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void treatmentReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void QuaratineReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void vaccinationReportOnActionButton(ActionEvent actionEvent) {
    }
}