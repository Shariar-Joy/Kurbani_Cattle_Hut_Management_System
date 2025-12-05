package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class Customer_goal2Controller {

    @javafx.fxml.FXML
    private TableView<Animalinfo> tentProfileTV;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> animalCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> tentNumCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> breedCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> sellerNameCOL;
    @javafx.fxml.FXML
    private TableColumn animalIDCOL;

    @javafx.fxml.FXML
    public void initialize() {
        setupTable();
        loadAnimals();
    }

    private void setupTable() {
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        breedCOL.setCellValueFactory(new PropertyValueFactory<>("breed"));
        tentNumCOL.setCellValueFactory(new PropertyValueFactory<>("tent"));
        sellerNameCOL.setCellValueFactory(new PropertyValueFactory<>("seller"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void loadAnimals() {
        List<Object> data = FileUtil.readObjects("AnimalInfo.bin");
        ObservableList<Animalinfo> animals = FXCollections.observableArrayList();

        for (Object obj : data) {
            if (obj instanceof Animalinfo) {
                animals.add((Animalinfo) obj);
            }
        }

        tentProfileTV.setItems(animals);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent)  throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-view.fxml");
    }

    @javafx.fxml.FXML
    public void refreshOA(ActionEvent actionEvent) {
        loadAnimals();
    }
}