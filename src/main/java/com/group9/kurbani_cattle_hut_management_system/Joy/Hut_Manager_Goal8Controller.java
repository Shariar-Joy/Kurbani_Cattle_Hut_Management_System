package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Tent;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Booking;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.FilesUtil;
import javafx.event.ActionEvent;
import javafx.scene.chart.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Hut_Manager_Goal8Controller extends Hut_Manager_Goal1Controller {

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
    private TableColumn<Animal,String> ownerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> ownerIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> ownerNidCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> ownerPhoneCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> ownerAddressCOL;
    @javafx.fxml.FXML
    private TableView<Animal> ownerTableView;

    @javafx.fxml.FXML
    private TableColumn<Animal,LocalDate> entryDateCOl;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalTypeCOL;
    @javafx.fxml.FXML
    private TableView<Animal> animalTableView;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> askingPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> ageCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIdCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> weightCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> breedCOL;
    @javafx.fxml.FXML
    private BarChart<String,Number> barChart;
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

    @javafx.fxml.FXML
    public void ownerLoadOA(ActionEvent actionEvent) {
        List<Object> list2 = FilesUtil.readObjects("data/owners.bin");
        ownerTableView.getItems().add((Animal) list2 );
    }

    @javafx.fxml.FXML
    public void animalLoadOA(ActionEvent actionEvent) {
        List<Object> list = FilesUtil.readObjects("data/animals.bin");
        animalTableView.getItems().add((Animal) list );
    }

    @javafx.fxml.FXML
    public void bookingLoadOA(ActionEvent actionEvent) {
        List<Object> list3 = FilesUtil.readObjects("data/bookings.bin");
        bookingTableView.getItems().add((Booking) list3 );
    }

    @javafx.fxml.FXML
    public void tentLoadOA(ActionEvent actionEvent) {
        List<Object> list4 = FilesUtil.readObjects("data/tents.bin");
        tentTableView.getItems().add((Tent) list4 );
    }

    @javafx.fxml.FXML
    public void showChartOA(ActionEvent actionEvent) {
        barChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Profit (TK)");

        series.getData().add(new XYChart.Data<>("January", 55000));
        series.getData().add(new XYChart.Data<>("February", 60000));
        series.getData().add(new XYChart.Data<>("March", 45000));
        series.getData().add(new XYChart.Data<>("April", 72000));
        series.getData().add(new XYChart.Data<>("May", 68000));
        series.getData().add(new XYChart.Data<>("June", 75000));

        barChart.getData().add(series);
    }

    @javafx.fxml.FXML
    public void showChartOA1(ActionEvent actionEvent) {
        pieChart.getData().clear();

        pieChart.getData().add(new PieChart.Data("Food & Feed", 35000));
        pieChart.getData().add(new PieChart.Data("Medical & Vaccination", 12000));
        pieChart.getData().add(new PieChart.Data("Tent Maintenance", 8000));
        pieChart.getData().add(new PieChart.Data("Worker Salaries", 25000));
        pieChart.getData().add(new PieChart.Data("Water & Cleaning", 5000));
    }
}