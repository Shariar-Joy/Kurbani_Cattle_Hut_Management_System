package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Hut_Manager_Goal3Controller
{
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner, LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalTypeCOL;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> animalTableView;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> askingPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> ageCOL;
    @javafx.fxml.FXML
    private TextField searchTF1;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerPhoneCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> weightCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> breedCOL;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> ownerTableView;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerAddressCOL;
    @javafx.fxml.FXML
    private TextField searchTF11;

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

    @javafx.fxml.FXML
    public void ownerEditOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3_2.fxml");
    }

    @javafx.fxml.FXML
    public void animalEditOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3_1.fxml");
    }
}