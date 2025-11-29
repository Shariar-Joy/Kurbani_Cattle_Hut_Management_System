package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Hut_Manager_Goal5Controller
{
    @javafx.fxml.FXML
    private DatePicker bookingDateDatePIcker;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> bookingIDCOL;
    @javafx.fxml.FXML
    private RadioButton unpaidRadioButton;
    @javafx.fxml.FXML
    private TextField reasonToRejectTF;
    @javafx.fxml.FXML
    private TableColumn<Booking, LocalDate> BookingDateCOL;
    @javafx.fxml.FXML
    private TextField ownerNameTF;
    @javafx.fxml.FXML
    private ComboBox<String> tentIDCB;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> paymentStatusCOL;
    @javafx.fxml.FXML
    private ComboBox<String> assignTentBookingIDCB;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TableColumn<Booking,Integer> paymentAmountCOL;
    @javafx.fxml.FXML
    private RadioButton paidRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup Payment;
    @javafx.fxml.FXML
    private TextField paymentAmountTF;
    @javafx.fxml.FXML
    private ComboBox<String> approveRejectBookingIDCB;
    @javafx.fxml.FXML
    private TableView<Booking> bookingTableView;
    @javafx.fxml.FXML
    private TextField bookingIDTF;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> tentCOL;
    @javafx.fxml.FXML
    private ComboBox<String> verifyPaymentBookingIDCB;

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
    public void rejectOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void savePaymentOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void assignTentOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }
}