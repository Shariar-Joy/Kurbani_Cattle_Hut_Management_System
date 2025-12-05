package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Tent;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
        animalIdCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));
        tentIdCB.setItems(IDStoreUtil.loadIDs("tent_ids.txt"));

        tentIdCOL.setCellValueFactory(new PropertyValueFactory<>("tentID"));
        occupiedSlotsCOL.setCellValueFactory(new PropertyValueFactory<>("occupiedSloats"));
        totalCapacityCOL.setCellValueFactory(new PropertyValueFactory<>("totalCapacity"));
        freeSlotsCOL.setCellValueFactory(new PropertyValueFactory<>("freeSlots"));
        directionCOL.setCellValueFactory(new PropertyValueFactory<>("direction"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        List<Tent> searchResults = SearchUtil.searchAndValidate(searchTF, tentList, Tent::getTentID);
        tentTableView.getItems().clear();
        tentTableView.getItems().addAll(searchResults);

    }

    @javafx.fxml.FXML
    public void AddOnActionButton(ActionEvent actionEvent) {
        String tentID = IDGenerator.generateTentID();
        tentIdTF.setText(tentID);
        IDStoreUtil.saveID("tent_ids.txt", tentID);

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
            AlertUtil.showError("Input Error", "Please enter valid numbers for capacity and occupied slots.");
            return;
        }

        if(tentID.isEmpty() || direction == null || status == null){
            AlertUtil.showError("Input Error", "Please fill all the fields.");
            return;
        }

        for(Tent tent : tentList){
            if(tent.getTentID().equalsIgnoreCase(tentID)){
                AlertUtil.showError("Duplicate Tent", "A tent with this ID already exists.");
                return;
            }
        }

        Tent newTent = new Tent(tentID, occupiedSlots, totalCapacity, freeSlots,direction, status);
        tentList.add(newTent);
        AlertUtil.showInfo("Success", "Tent added successfully.");
        tentTableView.getItems().clear();
        tentTableView.getItems().addAll(tentList);
        File file = new File("data/tent.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file); // NO appending
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tentList);  // Save entire list
            oos.close();
            AlertUtil.showInfo("Success", "Saved to file");
        } catch (IOException e) {
            AlertUtil.showError("Error", "File error: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void moveOnActionButton(ActionEvent actionEvent) {
        String selectedAnimalID = animalIdCB.getValue();
        String selectedTentID = tentIdCB.getValue();

        if(selectedAnimalID == null || selectedTentID == null){
            AlertUtil.showError("Input Error", "Please select both Animal ID and Tent ID.");
            return;
        }

        boolean foundTent = false;
        for(Tent tent : tentList) {
            if (tent.getTentID().equalsIgnoreCase(selectedTentID)) {
                foundTent = true;
                if (tent.getFreeSlots() > 0) {
                    tent.setOccupiedSloats(tent.getOccupiedSloats() + 1);
                    tent.setFreeSlots(tent.getTotalCapacity() - tent.getOccupiedSloats());
                    AlertUtil.showInfo("Success", "Animal ID: " + selectedAnimalID + " moved to Tent ID: " + selectedTentID + " successfully.");
                    tentTableView.refresh();
                } else {
                    AlertUtil.showError("Full Tent", "The selected tent is full. Cannot move the animal.");
                }
                break;
            }
        }
        if(!foundTent){
            AlertUtil.showError("Not Found", "No tent found with ID: " + selectedTentID);
        }
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
            AlertUtil.showError("Input Error", "Please enter Tent ID to remove.");
            return;
        } else {
            boolean found = false;
            for(Tent tent : tentList){
                if(tent.getTentID().equalsIgnoreCase(tentIDToRemove)){
                    tentList.remove(tent);
                    AlertUtil.showInfo("Success", "Tent with ID: " + tentIDToRemove + " removed successfully.");
                    tentTableView.getItems().clear();
                    tentTableView.getItems().addAll(tentList);
                    found = true;
                    break;
                }
            }
            if(!found){
                AlertUtil.showError("Not Found", "No tent found with ID: " + tentIDToRemove);
            }
        }

    }
    @javafx.fxml.FXML
    public void cancelOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(tentIdTF,totalCapacityTF,occupiedSlotsTF, removeTentIdTF,reasonToRemoveTF);
        RefreshUtil.clearComboBoxes(directionCB,statusCB,animalIdCB,tentIdCB);


    }

}