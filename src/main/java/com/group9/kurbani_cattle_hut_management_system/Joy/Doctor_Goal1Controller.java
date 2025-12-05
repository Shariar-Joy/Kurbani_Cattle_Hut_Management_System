package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
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

public class Doctor_Goal1Controller
{

    @javafx.fxml.FXML
    private TableColumn<Animal,LocalDate> entryDateCOl1;
    @javafx.fxml.FXML
    private TableView<Animal> animalTableView1;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> ageCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> statusCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIdCOL1;
    @javafx.fxml.FXML
    private TextField searchAnimalTF;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> tentCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalTypeCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> weightCOL;

    @javafx.fxml.FXML
    public void initialize() {
        animalIdCOL1.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        animalTypeCOL1.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        weightCOL.setCellValueFactory(new PropertyValueFactory<>("weight"));
        ageCOL.setCellValueFactory(new PropertyValueFactory<>("age"));
        entryDateCOl1.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
        tentCOL1.setCellValueFactory(new PropertyValueFactory<>("tent"));
        statusCOL1.setCellValueFactory(new PropertyValueFactory<>("status"));

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
    public void formOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal1_1.fxml");
    }

    @javafx.fxml.FXML
    public void loadAnimalOnActionButton(ActionEvent actionEvent) {

        File file = new File("data/animals.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Animal> list = (ArrayList<Animal>) ois.readObject();
            ois.close();
            animalTableView1.getItems().setAll(list);  // THIS IS IMPORTANT
            AlertUtil.showInfo("Success", "Loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            AlertUtil.showError("Error", "Load error");
        }

    }

    @javafx.fxml.FXML
    public void searchAnimalOnActionButton(ActionEvent actionEvent) {
        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchAnimalTF, animalTableView1.getItems(), Animal::getAnimalID);
        animalTableView1.getItems().clear();
        animalTableView1.getItems().addAll(searchAnimalResults);
    }
}