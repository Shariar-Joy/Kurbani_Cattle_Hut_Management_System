package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;

import java.io.IOException;

public class CustomerController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void goal8OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal8.fxml");
    }

    @javafx.fxml.FXML
    public void goal3OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal3.fxml");
    }

    @javafx.fxml.FXML
    public void goal5OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal5.fxml");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goal4OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal4.fxml");
    }

    @javafx.fxml.FXML
    public void goal7OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal7.fxml");
    }

    @javafx.fxml.FXML
    public void goal1OnActionButton(ActionEvent actionEvent) throws IOException {

        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal1.fxml");
    }

    @javafx.fxml.FXML
    public void goal6OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal6.fxml");
    }

    @javafx.fxml.FXML
    public void goal2OnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-goal2.fxml");
    }
}