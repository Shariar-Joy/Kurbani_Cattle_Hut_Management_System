package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Booking;
import com.group9.kurbani_cattle_hut_management_system.Utils.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private TableView<Booking> bookingTableView;
    @javafx.fxml.FXML
    private TextField bookingIDTF;
    @javafx.fxml.FXML
    private TableColumn<Booking,String> tentCOL;
    @javafx.fxml.FXML
    private TextField assignTentBookingIDTF;
    @javafx.fxml.FXML
    private TextField verifyPaymentBookingIDTF;
    @javafx.fxml.FXML
    private TextField approveRejectBookingIDTF;


    final private ArrayList<Booking> bookingList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        tentIDCB.setItems(IDStoreUtil.loadIDs("tent_ids.txt"));

        bookingIDCOL.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
        ownerNameCOL.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        paymentAmountCOL.setCellValueFactory(new PropertyValueFactory<>("paymentAmount"));
        BookingDateCOL.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        tentCOL.setCellValueFactory(new PropertyValueFactory<>("assignedTent"));
        paymentStatusCOL.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
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
        List<Booking> results = SearchUtil.searchAndValidate(searchTF, bookingList, Booking::getBookingID);
        bookingTableView.getItems().clear();
        bookingTableView.getItems().setAll(results);
    }

    @javafx.fxml.FXML
    public void rejectOnActionButton(ActionEvent actionEvent) {
        String bookingIDToRemove = approveRejectBookingIDTF.getText();

        if (bookingIDToRemove.isEmpty()) {
            AlertUtil.showError("Input Error", "Please select a Booking ID to reject.");
            return;
        }

        Booking bookingToRemove = null;
        for (Booking booking : bookingTableView.getItems()) {
            if (booking.getBookingID().equalsIgnoreCase(bookingIDToRemove)) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookingTableView.getItems().remove(bookingToRemove);
            bookingList.remove(bookingToRemove);

            AlertUtil.showInfo("Success",
                    "Booking with ID: " + bookingIDToRemove + " has been rejected and removed.");
        } else {
            AlertUtil.showError("Not Found",
                    "No booking found with ID: " + bookingIDToRemove);
        }
    }

    @javafx.fxml.FXML
    public void savePaymentOnActionButton(ActionEvent actionEvent) {
        String bookingID = verifyPaymentBookingIDTF.getText();
        if (bookingID.isEmpty()) {
            AlertUtil.showError("Input Error", "Please select a Booking ID to verify payment.");
            return;
        }

        String status;
        if (paidRadioButton.isSelected()) {
            status = "Paid";
        } else if (unpaidRadioButton.isSelected()) {
            status = "Unpaid";
        } else {
            AlertUtil.showError("Input Error", "Please select a payment status.");
            return;
        }
        boolean found = false;
        for (Booking booking : bookingTableView.getItems()) {
            if (booking.getBookingID().equalsIgnoreCase(bookingID)) {
                booking.setPaymentStatus(status);
                bookingTableView.refresh();
                AlertUtil.showInfo("Success", "Payment status of Booking ID: " + bookingID + " has been updated to " + status + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            AlertUtil.showError("Not Found", "No booking found with ID: " + bookingID);
        }
        FilesUtil.saveObject("data/bookings.bin", bookingList);
    }


    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {

        String bookingID = IDGenerator.generateBookingID();
        bookingIDTF.setText(bookingID);
        IDStoreUtil.saveID("booking_ids.txt", bookingID);

        String ownerName = ownerNameTF.getText().trim();
        int paymentAmount = 0;
        LocalDate bookingDate = bookingDateDatePIcker.getValue();
        try{
            paymentAmount = Integer.parseInt(paymentAmountTF.getText().trim());
        } catch (Exception e){
            AlertUtil.showError("Input Error","Please enter a valid payment amount.");
        }
        String tentID = null;
        String paymentStatus = null;


        if(bookingID.isEmpty() || ownerName.isEmpty() || paymentAmountTF.getText().trim().isEmpty() || bookingDate == null){
            AlertUtil.showError("Input Error","Please fill all the required fields.");
            return;
        }


        Booking newBooking = new Booking(bookingID, ownerName, paymentAmount, bookingDate, null, null);
        bookingList.add(newBooking);
        bookingTableView.getItems().add(newBooking);
        AlertUtil.showInfo("Success","Booking saved successfully.");
        FilesUtil.saveObject("data/bookings.bin", bookingList);
    }

    @javafx.fxml.FXML
    public void assignTentOnActionButton(ActionEvent actionEvent) {
        String assignBookingID = assignTentBookingIDTF.getText();
        String tentID = tentIDCB.getValue();
        if (assignBookingID.isEmpty() || tentID.isEmpty()) {
            AlertUtil.showError("Input Error", "Please select both Booking ID and Tent ID to assign.");
            return;
        }
        boolean found = false;
        for (Booking booking : bookingTableView.getItems()) {
            if (booking.getBookingID().equalsIgnoreCase(assignBookingID)) {
                booking.setAssignedTent(tentID);
                bookingTableView.refresh();
                AlertUtil.showInfo("Success", "Tent ID: " + tentID + " has been assigned to Booking ID: " + assignBookingID + ".");
                found = true;
                break;
            }
        }
        if (!found) {
            AlertUtil.showError("Not Found", "No booking found with ID: " + assignBookingID);
        }
        FilesUtil.saveObject("data/bookings.bin", bookingList);

    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(bookingIDTF,ownerNameTF,paymentAmountTF,reasonToRejectTF,searchTF,assignTentBookingIDTF,verifyPaymentBookingIDTF,approveRejectBookingIDTF);
        RefreshUtil.clearDatePickers(bookingDateDatePIcker);
        RefreshUtil.clearComboBoxes(tentIDCB);
        RefreshUtil.clearToggleGroups(Payment);
        bookingTableView.getItems().setAll(bookingList);


    }
}