package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Customer_goal3Controller {

    @javafx.fxml.FXML
    private ComboBox<String> timeCB;
    @javafx.fxml.FXML
    private TableColumn<Visit, String> phoneCOL;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField phoneNumTF;
    @javafx.fxml.FXML
    private TableColumn<Visit, LocalDate> dateCOL;
    @javafx.fxml.FXML
    private TableColumn<Visit, String> nameCOL;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TableColumn<Visit, String> timeCOL;
    @javafx.fxml.FXML
    private TableView<Visit> visitTV;
    @javafx.fxml.FXML
    private Label errorMessage;

    private ObservableList<Visit> visits = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        setupComboBox();
        setupTable();
        loadVisitsFromFile();

        visitTV.setItems(visits);
        errorMessage.setText("");
    }

    private void setupComboBox() {
        timeCB.getItems().addAll("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00");
    }

    private void setupTable() {
        nameCOL.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCOL.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        dateCOL.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCOL.setCellValueFactory(new PropertyValueFactory<>("time"));
    }

    private void loadVisitsFromFile() {
        try {
            List<Object> data = FileUtil.readObjects("D:\\OOP alt\\Kurbani_Cattle_Hut_Management_System\\data\\Visit.bin");
            visits.clear();

            for (Object obj : data) {
                if (obj instanceof Visit) {
                    visits.add((Visit) obj);
                }
            }
            System.out.println("Loaded " + visits.size() + " visits from file");
        } catch (Exception e) {
            System.out.println("Could not load visits: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void addOA(ActionEvent actionEvent) {
        String name = nameTF.getText().trim();
        String phone = phoneNumTF.getText().trim();
        String time = timeCB.getValue();
        LocalDate date = dateDP.getValue();

        if (name.isEmpty() || phone.isEmpty() || time == null || date == null) {
            errorMessage.setText("All fields are required");
            return;
        }

        Visit newVisit = new Visit(name, phone, date, time);
        visits.add(newVisit);

        FileUtil.saveObject("D:\\OOP alt\\Kurbani_Cattle_Hut_Management_System\\data\\Visit.bin", newVisit);

        clearInputs();
        errorMessage.setText("Visit added successfully");
    }

    @javafx.fxml.FXML
    public void clearOA(ActionEvent actionEvent) {
        Visit selected = visitTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            errorMessage.setText("Please select a visit to remove");
            return;
        }

        visits.remove(selected);
        visitTV.refresh();
        errorMessage.setText("Visit removed");
    }

    private void clearInputs() {
        nameTF.clear();
        phoneNumTF.clear();
        timeCB.getSelectionModel().clearSelection();
        dateDP.setValue(null);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent)  throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-view.fxml");
    }
}