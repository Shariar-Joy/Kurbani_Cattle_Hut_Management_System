package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;

public class Hut_Manager_Goal8Controller
{
    @javafx.fxml.FXML
    private TableColumn<Booking, LocalDate> BookingDateCOL;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> ownerNameCOL1;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> tentCOL;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> paymentStatusCOL;
    @javafx.fxml.FXML
    private TableColumn<Booking,Integer> paymentAmountCOL;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> bookingIDCOL;
    @javafx.fxml.FXML
    private TableView<Booking> bookingTableView;

    @javafx.fxml.FXML
    private TableColumn<Tent,String> tentIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,String> directionCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer>  totalCapacityCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer>  occupiedSlotsCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer> freeSlotsCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,String> statusCOL;
    @javafx.fxml.FXML
    private TableView<Tent> tentTableView;


    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerPhoneCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> ownerAddressCOL;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> ownerTableView;

    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalTypeCOL;
    @javafx.fxml.FXML
    private TableView<AnimalOwner> animalTableView;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> askingPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> ageCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,String> animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> weightCOL;
    @javafx.fxml.FXML
    private TableColumn<AnimalOwner,Integer> breedCOL;


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
    public void ownerReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void animalReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void bookingReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void tentReportOnActionButton(ActionEvent actionEvent) {
    }
}