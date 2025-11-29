package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

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
    private TableColumn<Treatment,String> durationCOL;
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
    private TableColumn<Treatment,String> dosageCOL;
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
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateSaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void followUpSaveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void closeCaseOnActionButton(ActionEvent actionEvent) {
    }
}