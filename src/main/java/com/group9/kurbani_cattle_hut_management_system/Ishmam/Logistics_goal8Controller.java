package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class Logistics_goal8Controller {
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> animalCOL;
    @javafx.fxml.FXML
    private TextField searchAimalIDTF;
    @javafx.fxml.FXML
    private TableView<ProblemReport> problemReportTV;
    @javafx.fxml.FXML
    private RadioButton wrongDeliveryRB;
    @javafx.fxml.FXML
    private RadioButton otherIssueRB;
    @javafx.fxml.FXML
    private TextArea descriptionTA;
    @javafx.fxml.FXML
    private Button searchOA;
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> descriptionCOL;
    @javafx.fxml.FXML
    private RadioButton injuredAnimalRB;
    @javafx.fxml.FXML
    private ToggleGroup issueType;
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> dateCOL;
    @javafx.fxml.FXML
    private RadioButton refundRequestRB;
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> buyerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> animalIDCOL;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TableColumn<ProblemReport, String> issueTypeCOL;

    private final ObservableList<ProblemReport> dataList = FXCollections.observableArrayList();
    private final ObservableList<ProblemReport> allReports = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        errorLabel.setText("");
        errorLabel.setVisible(false);

        dateCOL.setCellValueFactory(new PropertyValueFactory<>("date"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalId"));
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        buyerNameCOL.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        descriptionCOL.setCellValueFactory(new PropertyValueFactory<>("description"));
        issueTypeCOL.setCellValueFactory(new PropertyValueFactory<>("issueType"));

        loadFromFile();
        problemReportTV.setItems(dataList);

        searchOA.setOnAction(event -> searchReport());
    }

    private void loadFromFile() {
        List<Object> objects = FileUtil.readObjects("ProblemReport.bin");
        for (Object obj : objects) {
            if (obj instanceof ProblemReport) {
                allReports.add((ProblemReport) obj);
                dataList.add((ProblemReport) obj);
            }
        }
    }

    private void searchReport() {
        String searchId = searchAimalIDTF.getText().trim();

        if (searchId.isEmpty()) {
            dataList.setAll(allReports);
            errorLabel.setVisible(false);
            return;
        }

        ObservableList<ProblemReport> filtered = FXCollections.observableArrayList();
        for (ProblemReport report : allReports) {
            if (report.getAnimalId().toLowerCase().contains(searchId.toLowerCase())) {
                filtered.add(report);
            }
        }

        if (filtered.isEmpty()) {
            showError("No reports found for Animal ID: " + searchId);
        } else {
            errorLabel.setVisible(false);
        }

        dataList.setAll(filtered);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    @javafx.fxml.FXML
    public void clearOA(ActionEvent actionEvent) {
        searchAimalIDTF.clear();
        descriptionTA.clear();

        if (issueType.getSelectedToggle() != null) {
            issueType.getSelectedToggle().setSelected(false);
        }

        errorLabel.setVisible(false);

        dataList.setAll(allReports);
    }

    @javafx.fxml.FXML
    public void addReportOA(ActionEvent actionEvent) {
        String animalId = searchAimalIDTF.getText().trim();
        String description = descriptionTA.getText().trim();

        if (animalId.isEmpty()) {
            showError("Please enter an Animal ID");
            return;
        }

        if (description.isEmpty()) {
            showError("Please enter a description");
            return;
        }

        RadioButton selectedRadioButton = (RadioButton) issueType.getSelectedToggle();
        if (selectedRadioButton == null) {
            showError("Please select an issue type");
            return;
        }

        String issueTypeText = selectedRadioButton.getText().trim();

        String animal = "Animal-" + animalId;
        String buyerName = "Buyer-" + animalId;

        ProblemReport report = new ProblemReport(animalId, animal, buyerName, description, issueTypeText);

        allReports.add(report);
        dataList.add(report);

        FileUtil.saveObject("ProblemReport.bin", report);

        showSuccess("Problem report added successfully!");

        clearOA(actionEvent);
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setVisible(true);
    }

    private void showSuccess(String message) {
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: green;");
        errorLabel.setVisible(true);
    }
}