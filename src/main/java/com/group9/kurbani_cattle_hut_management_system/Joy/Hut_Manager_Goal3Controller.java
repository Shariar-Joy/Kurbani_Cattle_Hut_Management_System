package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Owner;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.SearchUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hut_Manager_Goal3Controller
{
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal, LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalTypeCOL;
    @javafx.fxml.FXML
    private TableView<Animal> animalTableView;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> askingPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> ageCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerPhoneCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> weightCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> breedCOL;
    @javafx.fxml.FXML
    private TableView<Owner> ownerTableView;
    @javafx.fxml.FXML
    private TableColumn<Owner,String> ownerAddressCOL;
    @javafx.fxml.FXML
    private TextField searchOwnerTF;
    @javafx.fxml.FXML
    private TextField searchAnimalTF;

    @javafx.fxml.FXML
    public void initialize() {
        animalIdCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalTypeCOL.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        weightCOL.setCellValueFactory(new PropertyValueFactory<>("weight"));
        ageCOL.setCellValueFactory(new PropertyValueFactory<>("age"));
        entryDateCOl.setCellValueFactory(new PropertyValueFactory<>("entryDate"));

        ownerIdCOL.setCellValueFactory(new PropertyValueFactory<>("ownerID"));
        ownerNameCOL.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        ownerNidCOL.setCellValueFactory(new PropertyValueFactory<>("ownerNID"));
        ownerAddressCOL.setCellValueFactory(new PropertyValueFactory<>("ownerAddress"));
        ownerPhoneCOL.setCellValueFactory(new PropertyValueFactory<>("ownerPhone"));

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
    public void ownerEditOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3_2.fxml");
    }

    @javafx.fxml.FXML
    public void animalEditOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3_1.fxml");
    }

    @javafx.fxml.FXML
    public void loadOnActionButton(ActionEvent actionEvent) {
        File file = new File("data/animal-edit.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Animal> list = (ArrayList<Animal>) ois.readObject();
            ois.close();
            animalTableView.getItems().setAll(list);  // THIS IS IMPORTANT
            AlertUtil.showInfo("Success", "Loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            AlertUtil.showError("Error", "Load error: " + e.getMessage());
        }

        File file1 = new File("data/owners_edit.bin");
        try {
            FileInputStream fis = new FileInputStream(file1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Owner> list1 = (ArrayList<Owner>) ois.readObject();
            ois.close();
            ownerTableView.getItems().setAll(list1);  // THIS IS IMPORTANT
            AlertUtil.showInfo("Success", "Loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            AlertUtil.showError("Error", "Load error: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void searchAnimalOnActionButton(ActionEvent actionEvent) {
        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchAnimalTF, animalTableView.getItems(), Animal::getAnimalID);
        animalTableView.getItems().clear();
        animalTableView.getItems().addAll(searchAnimalResults);
    }

    @javafx.fxml.FXML
    public void searchOwnerOnActionButton(ActionEvent actionEvent) {
        List<Owner> searchOwnerResults = SearchUtil.searchAndValidate(searchOwnerTF, ownerTableView.getItems(), Owner::getOwnerID);
        ownerTableView.getItems().clear();
        ownerTableView.getItems().addAll(searchOwnerResults);
    }
}