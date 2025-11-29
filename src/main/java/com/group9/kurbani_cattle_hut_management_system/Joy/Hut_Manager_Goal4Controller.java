package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class Hut_Manager_Goal4Controller
{
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> treatmentCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> healthAnimalIDCOL;
    @javafx.fxml.FXML
    private ComboBox<String> healthAnimalIDCB;
    @javafx.fxml.FXML
    private TableView<Quarantine> healthTableView;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> healthStatusCOL;
    @javafx.fxml.FXML
    private TableView<Treatment> treatmentTableView;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> treatmentAnimalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,Integer> costCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> tentNoCOL;
    @javafx.fxml.FXML
    private ComboBox<String> treatmentAnimalIDCB;

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
    public void rejectOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void moveToQuarantineOnActionButton(ActionEvent actionEvent) {
    }
}