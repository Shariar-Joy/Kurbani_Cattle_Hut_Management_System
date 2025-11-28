package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class Hut_Manager_Goal3Controller
{
    @javafx.fxml.FXML
    private TableColumn tentIdCOL;
    @javafx.fxml.FXML
    private TableColumn ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn directionCOL;
    @javafx.fxml.FXML
    private TableColumn entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn ownerIdCOL;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private ComboBox animalTypeCB;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TableColumn totalCapacityCOL;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TableColumn animalTypeCOL;
    @javafx.fxml.FXML
    private TableColumn occupiedSlotsCOL;
    @javafx.fxml.FXML
    private TableView animalTableView;
    @javafx.fxml.FXML
    private TextField ownerAddressTF;
    @javafx.fxml.FXML
    private TableColumn askingPriceCOL;
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TableColumn ageCOL;
    @javafx.fxml.FXML
    private TextField ownerPhone;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private TextField askingPriceTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @javafx.fxml.FXML
    private TableColumn freeSlotsCOL;
    @javafx.fxml.FXML
    private TextField searchTF1;
    @javafx.fxml.FXML
    private TableColumn animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn ownerPhoneCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TableColumn weightCOL;
    @javafx.fxml.FXML
    private TableColumn statusCOL;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private ComboBox selectTentCB;
    @javafx.fxml.FXML
    private TableColumn breedCOL;

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
    public void searchOnActionButton(ActionEvent actionEvent) {
    }
}