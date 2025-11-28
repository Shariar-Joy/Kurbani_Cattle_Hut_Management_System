package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Doctor_Goal2Controller
{
    @javafx.fxml.FXML
    private DatePicker dateAdministeredDatePiker;
    @javafx.fxml.FXML
    private TextField vaccineNameTF;
    @javafx.fxml.FXML
    private TextField doseNumberTF;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,Integer> doseNumberCOl;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, LocalDate> nextDueDateCOL;
    @javafx.fxml.FXML
    private TextField remarksTF;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,LocalDate> dateAdministeredCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> statusCOL;
    @javafx.fxml.FXML
    private TextField imageTF;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> vaccineNameCOL;
    @javafx.fxml.FXML
    private DatePicker nextDueDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationTableView;

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
    public void saveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }
}