package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class Logistics_goal6Controller
{
    @javafx.fxml.FXML
    private TableView<InspectionRecord> inspectionTV;
    @javafx.fxml.FXML
    private TableColumn<InspectionRecord, String> animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<InspectionRecord, String> inspectorCOL;
    @javafx.fxml.FXML
    private TableColumn<InspectionRecord, String> statusCOL;
    @javafx.fxml.FXML
    private TableColumn<InspectionRecord, String> issueCOL;

    @javafx.fxml.FXML
    private TextField animalIdTF;
    @javafx.fxml.FXML
    private TextField inspectorNameTF;
    @javafx.fxml.FXML
    private TextArea issueTA;

    @javafx.fxml.FXML
    private CheckBox checkbox1;
    @javafx.fxml.FXML
    private CheckBox checkbox2;
    @javafx.fxml.FXML
    private CheckBox checkbox3;
    @javafx.fxml.FXML
    private CheckBox checkbox4;
    @javafx.fxml.FXML
    private CheckBox checkbox5;

    private final ObservableList<InspectionRecord> dataList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableColumn <InspectionRecord, String> inspectionChecklistCOL;
    @javafx.fxml.FXML
    private Label inspectorTF;

    @javafx.fxml.FXML
    public void initialize() {
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalId"));
        inspectorCOL.setCellValueFactory(new PropertyValueFactory<>("inspectorName"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
        issueCOL.setCellValueFactory(new PropertyValueFactory<>("issueDescription"));
        inspectionChecklistCOL.setCellValueFactory(new PropertyValueFactory<>("checklistResult"));

        loadFromFile();
        inspectionTV.setItems(dataList);
    }

    private void loadFromFile() {
        List<Object> objects = FileUtil.readObjects("InspectionRecord.bin");
        for (Object obj : objects) {
            if (obj instanceof InspectionRecord) {
                dataList.add((InspectionRecord) obj);
            }
        }
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    private int countChecked() {
        int count = 0;
        if (checkbox1.isSelected()) count++;
        if (checkbox2.isSelected()) count++;
        if (checkbox3.isSelected()) count++;
        if (checkbox4.isSelected()) count++;
        if (checkbox5.isSelected()) count++;
        return count;
    }

    private void addInspectionRecord(String status) {
        String animalId = animalIdTF.getText();
        String inspector = inspectorNameTF.getText();
        String issue = issueTA.getText();

        if (animalId.trim().isEmpty()) {
            System.out.println("Animal ID required");
            return;
        }
        if (inspector.trim().isEmpty()) {
            System.out.println("Inspector name required");
            return;
        }

        int checked = countChecked();
        int total = 5;
        String checklist = checked + " out of " + total;

        InspectionRecord record = new InspectionRecord(animalId, inspector, status, issue, checklist);

        dataList.add(record);

        FileUtil.saveObject("InspectionRecord.bin", record);

        animalIdTF.clear();
        inspectorNameTF.clear();
        issueTA.clear();
        checkbox1.setSelected(false);
        checkbox2.setSelected(false);
        checkbox3.setSelected(false);
        checkbox4.setSelected(false);
        checkbox5.setSelected(false);
    }

    @javafx.fxml.FXML
    public void holdOA(ActionEvent actionEvent) {
        addInspectionRecord("HOLD");
    }

    @javafx.fxml.FXML
    public void approveExitOA(ActionEvent actionEvent) {
        addInspectionRecord("APPROVED");
    }

    @javafx.fxml.FXML
    public void flagIssueOA(ActionEvent actionEvent) {
        addInspectionRecord("FLAGGED");
    }
}