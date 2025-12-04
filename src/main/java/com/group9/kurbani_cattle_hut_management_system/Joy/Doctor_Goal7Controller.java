package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Medical_Records;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Quarantine;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Treatment;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Vaccination;
import com.group9.kurbani_cattle_hut_management_system.Utils.FilesUtil;
import javafx.event.ActionEvent;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Doctor_Goal7Controller
{
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationTableView;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> vaccineNameCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,Integer> doseNumberCOl;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, LocalDate> dateAdministeredCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,LocalDate> nextDueDateCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> statusCOL;

    @javafx.fxml.FXML
    private TableView<Quarantine> quarantineTableView;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> symptomsCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> diseaseCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> isolationTimeCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> isolationTentCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> medicineCOL;

    @javafx.fxml.FXML
    private TableColumn<Medical_Records,String> tempCOl;
    @javafx.fxml.FXML
    private TableColumn<Medical_Records,String>  pulseCOl;
    @javafx.fxml.FXML
    private TableView<Medical_Records>  medicalRecordTableView;
    @javafx.fxml.FXML
    private TableColumn<Medical_Records,String>  medicalRecordAnimalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Medical_Records,String>  breathingCOL;
    @javafx.fxml.FXML
    private TableColumn<Medical_Records,String>  weightCOL;

    @javafx.fxml.FXML
    private TableColumn<Treatment,String> statusCOL2;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> expectedRecoveryCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,LocalDate> endCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> daysCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> medicineCOL2;
    @javafx.fxml.FXML
    private TableView<Treatment> treatmentTableView1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> animalIDCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> diagnosisCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> dosageCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,String> timeCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,LocalDate> nextVisitCOL1;
    @javafx.fxml.FXML
    private TableColumn<Treatment,LocalDate> startCOL1;

    @javafx.fxml.FXML
    private BarChart<String, Number> barChart;
    @javafx.fxml.FXML
    private PieChart pieChart;
    @javafx.fxml.FXML
    private NumberAxis barChartYAxis;
    @javafx.fxml.FXML
    private CategoryAxis barChartXAxis;


    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Joy/doctor-view.fxml");
    }

    @javafx.fxml.FXML
    public void medicalReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void treatmentReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void quarantineReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void vaccinationReportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadMedicalOA(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/medical_records.bin");
        medicalRecordTableView.getItems().clear();
        medicalRecordTableView.getItems().add((Medical_Records) list);
    }

    @javafx.fxml.FXML
    public void loadTreatmentOA(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/treatments.bin");
        treatmentTableView1.getItems().clear();
        treatmentTableView1.getItems().add((Treatment) list);
    }

    @javafx.fxml.FXML
    public void loadVaccinationOA(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/vaccinations.bin");
        vaccinationTableView.getItems().clear();
        vaccinationTableView.getItems().add((Vaccination) list);
    }

    @javafx.fxml.FXML
    public void loadQuarantineOA(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/quarantines.bin");
        quarantineTableView.getItems().clear();
        quarantineTableView.getItems().add((Quarantine) list);
    }

    @javafx.fxml.FXML
    public void showChartOA(ActionEvent actionEvent) {
        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("Healthy", 45));
        pieChart.getData().add(new PieChart.Data("Minor Injury", 12));
        pieChart.getData().add(new PieChart.Data("Severe Injury", 4));
        pieChart.getData().add(new PieChart.Data("Infection", 8));
        pieChart.getData().add(new PieChart.Data("Dehydration", 5));

    }

    @javafx.fxml.FXML
    public void showChartOA1(ActionEvent actionEvent) {
        barChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("This Week");

        series.getData().add(new XYChart.Data<>("FMD", 28));
        series.getData().add(new XYChart.Data<>("HS", 17));
        series.getData().add(new XYChart.Data<>("Black Quarter", 10));
        series.getData().add(new XYChart.Data<>("Deworming", 34));

        barChart.getData().add(series);

    }
}