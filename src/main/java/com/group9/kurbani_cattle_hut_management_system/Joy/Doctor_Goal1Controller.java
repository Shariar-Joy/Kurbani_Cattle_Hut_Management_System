package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Utils.FilesUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.SearchUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
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
        List<Object> list = FilesUtil.readObjects("data/animals.bin");
        animalTableView1.getItems().clear();
        animalTableView1.getItems().add((Animal) list);

    }

    @javafx.fxml.FXML
    public void searchAnimalOnActionButton(ActionEvent actionEvent) {
        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchAnimalTF, animalTableView1.getItems(), Animal::getAnimalID);
        animalTableView1.getItems().clear();
        animalTableView1.getItems().addAll(searchAnimalResults);
    }
}