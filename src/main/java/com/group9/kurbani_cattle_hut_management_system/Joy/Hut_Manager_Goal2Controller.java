package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Hut_Manager_Goal2Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> directionCB;
    @javafx.fxml.FXML
    private TableColumn<Tent,String> tentIdCOL;
    @javafx.fxml.FXML
    private TextField totalCapacityTF;
    @javafx.fxml.FXML
    private TextField removeTentIdTF;
    @javafx.fxml.FXML
    private TableColumn<Tent,String> directionCOL;
    @javafx.fxml.FXML
    private ComboBox<String> tentIdCB;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer> freeSlotsCOL;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIdCB;
    @javafx.fxml.FXML
    private TextField reasonToRemoveTF;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer>totalCapacityCOL;
    @javafx.fxml.FXML
    private TableColumn<Tent,Integer> occupiedSlotsCOL;
    @javafx.fxml.FXML
    private TextField tentIdTF;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<Tent, String> statusCOL;
    @javafx.fxml.FXML
    private TableView<Tent> tentTableView;
    @javafx.fxml.FXML
    private TextField occupiedSlotsTF;

    private final ArrayList<Tent> tentList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {
        directionCB.getItems().addAll("East","West","North","South");
        statusCB.getItems().addAll("Full","Free","Maintenance","Occupied");
        animalIdCB.getItems().addAll("");
        tentIdCB.getItems().addAll("Tent 1","Tent 2", "Tent 3", "Tent 4", "Tent 5");

        tentIdCOL.setCellValueFactory(new PropertyValueFactory<>("tentID"));
        occupiedSlotsCOL.setCellValueFactory(new PropertyValueFactory<>("occupiedSloats"));
        totalCapacityCOL.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        freeSlotsCOL.setCellValueFactory(new PropertyValueFactory<>("freeSlots"));
        directionCOL.setCellValueFactory(new PropertyValueFactory<>("direction"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        if(searchTF.getText().isEmpty()){
            showAlert("Error","Please enter Tent ID to search.");
            return;
        }
        if(tentTableView.getItems().isEmpty()){
            showAlert("No Data","No data available to search.");
            return;
        }
        ArrayList<Tent> searchResults = new ArrayList<>();
        String tentIdToSearch = searchTF.getText().trim();
        for(Tent tent : tentList) {
            if (tent.getTentID().equalsIgnoreCase(tentIdToSearch)) {
                searchResults.add(tent);
            }
        }
        if (searchResults.isEmpty()) {
            showAlert("Not Found", "No tent found with ID: " + tentIdToSearch);
        } else {
            tentTableView.getItems().setAll(searchResults);
        }

        tentTableView.getItems().clear();
        tentTableView.getItems().addAll(searchResults);

    }

    @javafx.fxml.FXML
    public void AddOnActionButton(ActionEvent actionEvent) {
        String tentID = tentIdTF.getText();
        int occupiedSlots = 0;
        int totalCapacity = 0;
        int freeSlots = 0;
        String direction = directionCB.getValue();
        String status = statusCB.getValue();
        try{
            totalCapacity = Integer.parseInt(totalCapacityTF.getText().trim());
            occupiedSlots = Integer.parseInt(occupiedSlotsTF.getText().trim());
            freeSlots = totalCapacity - occupiedSlots;
        } catch (Exception e){
            showAlert("Input Error", "Please enter valid numbers for capacity and occupied slots.");
            return;
        }

        if(tentID.isEmpty() || direction == null || status == null){
            showAlert("Input Error", "Please fill all the fields.");
            return;
        }

        for(Tent tent : tentList){
            if(tent.getTentID().equalsIgnoreCase(tentID)){
                showAlert("Duplicate Tent", "A tent with this ID already exists.");
                return;
            }
        }

        Tent newTent = new Tent(tentID, occupiedSlots, totalCapacity, freeSlots,direction, status);
        tentList.add(newTent);
        showAlert("Success", "Tent added successfully.");
        tentTableView.getItems().clear();
        tentTableView.getItems().addAll(tentList);
    }

    @javafx.fxml.FXML
    public void moveOnActionButton(ActionEvent actionEvent) {
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
    public void removeOnActionButton(ActionEvent actionEvent) {
        String tentIDToRemove = removeTentIdTF.getText().trim();

        if(tentIDToRemove.isEmpty()){
            showAlert("Input Error", "Please enter Tent ID to remove.");
            return;
        } else {
            boolean found = false;
            for(Tent tent : tentList){
                if(tent.getTentID().equalsIgnoreCase(tentIDToRemove)){
                    tentList.remove(tent);
                    showAlert("Success", "Tent with ID: " + tentIDToRemove + " removed successfully.");
                    tentTableView.getItems().clear();
                    tentTableView.getItems().addAll(tentList);
                    found = true;
                    break;
                }
            }
            if(!found){
                showAlert("Not Found", "No tent found with ID: " + tentIDToRemove);
            }
        }

    }


    public  void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}