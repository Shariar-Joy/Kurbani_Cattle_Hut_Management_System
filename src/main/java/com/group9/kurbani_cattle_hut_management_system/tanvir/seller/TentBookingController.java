package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.HelloApplication;
import com.group9.kurbani_cattle_hut_management_system.Joy.Tent;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TentBookingController implements Initializable {
    @javafx.fxml.FXML
    private TableView<Tent> tentRecordsTableView;
    @javafx.fxml.FXML
    private TableColumn<Tent, String> tentIDTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Tent, Integer> occupiedSlotTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Tent, Integer> totalCapacityTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Tent, String> directionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Tent, String> statusTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> directionComboBox;

    private String sellerEmail = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tentIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("tentID"));
        occupiedSlotTableColumn.setCellValueFactory(new PropertyValueFactory<>("occupiedSlots"));
        totalCapacityTableColumn.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        directionTableColumn.setCellValueFactory(new PropertyValueFactory<>("direction"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        directionComboBox.getItems().addAll(
                "South Facing",
                "North Facing",
                "East Facing",
                "West Facing"
        );
    }

    public void setInitData(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    @javafx.fxml.FXML
    public void handleTentFilter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBookTent(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/dashboard.fxml"));
        Scene scene = new Scene(loader.load());
        ((DashboardController) (loader.getController())).setInitData(sellerEmail);
        stage.setScene(scene);
        stage.setTitle("Seller Dashboard");
        stage.centerOnScreen();
        stage.show();
    }
}