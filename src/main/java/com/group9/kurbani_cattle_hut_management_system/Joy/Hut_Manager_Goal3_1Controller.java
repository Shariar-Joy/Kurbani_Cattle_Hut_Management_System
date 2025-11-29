package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Hut_Manager_Goal3_1Controller
{
    @javafx.fxml.FXML
    private TextField weightTF;
    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TextField ageTF;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private TextField askingPriceTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalTypeCB;
    @javafx.fxml.FXML
    private TextField colorTF;
    @javafx.fxml.FXML
    private TextField breedTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goBackToGoal3OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager_goal3.fxml");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/hut-manager-view.fxml");
    }
}