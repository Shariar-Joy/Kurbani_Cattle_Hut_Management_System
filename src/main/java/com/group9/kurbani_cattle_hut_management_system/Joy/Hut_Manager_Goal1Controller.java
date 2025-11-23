package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class Hut_Manager_Goal1Controller
{
    @javafx.fxml.FXML
    private TableColumn<String,Owner> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<LocalDate,Animal> entryDateCOl;
    @javafx.fxml.FXML
    private TextField ownerNidTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalTypeCB;
    @javafx.fxml.FXML
    private TableColumn<String,Owner> ownerIdCOL;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TableColumn<String,Animal> animalTypeCOL;
    @javafx.fxml.FXML
    private DatePicker exitDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Owner> animalTableView;
    @javafx.fxml.FXML
    private TextField ownerAddressTF;
    @javafx.fxml.FXML
    private TableColumn<Integer,Animal> askingPriceCOL;
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TableColumn<Integer,Animal> ageCOL;
    @javafx.fxml.FXML
    private TextField ownerPhone;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private TextField removeAnimalIdTF;
    @javafx.fxml.FXML
    private TextField askingPriceTF;
    @javafx.fxml.FXML
    private TextField ownerIdTF;
    @javafx.fxml.FXML
    private TableColumn<String,Animal> animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Integer,Owner> ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn<String,Owner> ownerPhoneCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TableColumn<Integer,Animal> weightCOL;
    @javafx.fxml.FXML
    private TextField reasonToRemoveTF;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private ComboBox<String> selectTentCB;
    @javafx.fxml.FXML
    private TableColumn<String,Animal> breedCOL;

    @javafx.fxml.FXML
    public void initialize() {

        animalTypeCB.getItems().addAll("Cow","Goat","Camel","Sheep");
        selectTentCB.getItems().addAll("Tent 1","Tent 2", "Tent 3", "Tent 4", "Tent 5");
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

    @javafx.fxml.FXML
    public void cancleOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void removeOnActionButton(ActionEvent actionEvent) {
    }
}