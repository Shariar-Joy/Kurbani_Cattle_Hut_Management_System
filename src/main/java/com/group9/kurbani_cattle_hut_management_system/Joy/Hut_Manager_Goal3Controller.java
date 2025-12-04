package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Owner;
import com.group9.kurbani_cattle_hut_management_system.Utils.FilesUtil;
import com.group9.kurbani_cattle_hut_management_system.Utils.SearchUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;
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
        List<Object> list = FilesUtil.readObjects("animals_edit.bin");
        animalTableView.getItems().add((Animal) list);
        List<Object> list1 = FilesUtil.readObjects("owners_edit.bin");
        ownerTableView.getItems().add((Owner) list1);
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