package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class Doctor_Goal3Controller
{
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> diseaseCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> medicineCOL;
    @javafx.fxml.FXML
    private TextField diseaseTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine, LocalDate> isolationTentCOL;
    @javafx.fxml.FXML
    private TextField isolationTentTF;
    @javafx.fxml.FXML
    private TableView<Quarantine> quarantineTableView;
    @javafx.fxml.FXML
    private TextField symptomsTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> symptomsCOL;
    @javafx.fxml.FXML
    private TextField isolationTimeTF;
    @javafx.fxml.FXML
    private TextField medicineTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,LocalDate> isolationTimeCOL;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;

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
    public void createOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {

    }
}