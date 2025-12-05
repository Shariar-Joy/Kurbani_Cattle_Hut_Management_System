package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Customer_goal8Controller
{
    @javafx.fxml.FXML
    private ToggleGroup selectStatusRB;
    @javafx.fxml.FXML
    private TableView searchResultTV;
    @javafx.fxml.FXML
    private TableColumn<Report, String> updateOrderIDCOL;
    @javafx.fxml.FXML
    private TableView orderUpdateTB;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private TableColumn <Order, String> searchOrderIDCOL;
    @javafx.fxml.FXML
    private TableColumn searchDateCOL;
    @javafx.fxml.FXML
    private TableColumn <Report, String> updateStatus;
    @javafx.fxml.FXML
    private TableColumn  <Report, String> updateDescriptionCOL;
    @javafx.fxml.FXML
    private ToggleGroup updateStatusRB;
    @javafx.fxml.FXML
    private TableColumn <Report, String> updateIssueTypeCOL;
    @javafx.fxml.FXML
    private TableColumn <Order, String> searchItemCOL;
    @javafx.fxml.FXML
    private ToggleGroup issueTypeRB;


    private ObservableList<Order> historyOrders = FXCollections.observableArrayList();
    private ObservableList<Order> searchResults = FXCollections.observableArrayList();
    private ObservableList<Report> reports = FXCollections.observableArrayList();


    public static class Order {
        public String id;
        public String date;
        public String items;
        public Order(String id, String date, String items) {
            this.id = id; this.date = date; this.items = items;
        }
    }

    public static class Report {
        public String orderId;
        public String issueType;
        public String description;
        public String status;
        public Report(String orderId, String issueType, String description, String status) {
            this.orderId = orderId; this.issueType = issueType; this.description = description; this.status = status;
        }
    }

    @javafx.fxml.FXML
    public void initialize() {

        historyOrders.add(new Order("1001", "2025-10-01", "Cow"));
        historyOrders.add(new Order("1002", "2025-10-05", "Camel"));
        historyOrders.add(new Order("1003", "2025-11-12", "Cow, Goat"));


        try {

            searchOrderIDCOL.setCellValueFactory(c -> new SimpleStringProperty(((Order)c.getValue()).id));
            searchItemCOL.setCellValueFactory(c -> new SimpleStringProperty(((Order)c.getValue()).items));
            updateOrderIDCOL.setCellValueFactory(c -> new SimpleStringProperty(((Report)c.getValue()).orderId));
            updateIssueTypeCOL.setCellValueFactory(c -> new SimpleStringProperty(((Report)c.getValue()).issueType));
            updateDescriptionCOL.setCellValueFactory(c -> new SimpleStringProperty(((Report)c.getValue()).description));
            updateStatus.setCellValueFactory(c -> new SimpleStringProperty(((Report)c.getValue()).status));
        } catch (Exception ex) {

            System.out.println("Column wiring issue: " + ex.getMessage());
        }


        searchResultTV.setItems(searchResults);
        orderUpdateTB.setItems(reports);


        searchResultTV.setOnMouseClicked((MouseEvent me) -> {

        });
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent)  throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent)throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-view.fxml");
    }

    @javafx.fxml.FXML
    public void cancelOA(ActionEvent actionEvent) {

        searchResults.clear();
        searchTF.clear();
        descriptionTA.clear();

        if (issueTypeRB != null) issueTypeRB.selectToggle(null);
        if (selectStatusRB != null) selectStatusRB.selectToggle(null);
    }

    @javafx.fxml.FXML
    public void submitOA(ActionEvent actionEvent) {

        Order sel = null;
        try {
            sel = (Order) searchResultTV.getSelectionModel().getSelectedItem();
        } catch (Exception e) {
        }
        if (sel == null) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("Please select an order from search results first.");
            a.showAndWait();
            return;
        }


        String issue = "Other";
        if (issueTypeRB != null && issueTypeRB.getSelectedToggle() != null) {
            Toggle t = issueTypeRB.getSelectedToggle();
            if (t instanceof RadioButton) issue = ((RadioButton)t).getText();
        }

        String desc = descriptionTA.getText();
        if (desc == null) desc = "";

        String status = "Submitted";
        if (selectStatusRB != null && selectStatusRB.getSelectedToggle() != null) {
            Toggle t2 = selectStatusRB.getSelectedToggle();
            if (t2 instanceof RadioButton) status = ((RadioButton)t2).getText();
        }


        Report r = new Report(sel.id, issue, desc, status);
        reports.add(r);


        searchResults.clear();
        searchTF.clear();
        descriptionTA.clear();
        if (issueTypeRB != null) issueTypeRB.selectToggle(null);
        if (selectStatusRB != null) selectStatusRB.selectToggle(null);
    }

    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
        String q = searchTF.getText();
        searchResults.clear();
        if (q == null || q.trim().isEmpty()) {

            searchResults.addAll(historyOrders);
            return;
        }
        q = q.trim();
        for (Order o : historyOrders) {

            if (o.id.equalsIgnoreCase(q) || o.id.contains(q)) {
                searchResults.add(o);
            }
        }
        if (searchResults.isEmpty()) {

            for (Order o : historyOrders) {
                if (o.items.toLowerCase().contains(q.toLowerCase())) {
                    searchResults.add(o);
                }
            }
        }

        if (searchResults.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("No matching orders found.");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void updateOA(ActionEvent actionEvent) {

        Report sel = null;
        try {
            sel = (Report) orderUpdateTB.getSelectionModel().getSelectedItem();
        } catch (Exception e) {

        }
        if (sel == null) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("Please select a report row to update.");
            a.showAndWait();
            return;
        }

        String newStatus = null;
        if (updateStatusRB != null && updateStatusRB.getSelectedToggle() != null) {
            Toggle t = updateStatusRB.getSelectedToggle();
            if (t instanceof RadioButton) newStatus = ((RadioButton)t).getText();
        }
        if (newStatus == null) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText(null);
            a.setContentText("Please select a status in Update Status group.");
            a.showAndWait();
            return;
        }


        sel.status = newStatus;


        int idx = reports.indexOf(sel);
        if (idx >= 0) {
            reports.set(idx, sel);
        }
    }
}