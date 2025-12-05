package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Animal;
import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Certificate;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.SearchUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor_Goal5Controller
{
    @javafx.fxml.FXML
    private TableColumn<Certificate,Integer> scoreCOL;
    @javafx.fxml.FXML
    private TableView<Certificate> certificateTableView;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<Certificate,String> doctorCOL;
    @javafx.fxml.FXML
    private TextField statusAnimalIdTF;
    @javafx.fxml.FXML
    private TableColumn<Certificate,String> weightCOL;
    @javafx.fxml.FXML
    private TableColumn<Certificate,String> dateCOL;
    @javafx.fxml.FXML
    private TableColumn<Certificate,String> certificateCOL;
    @javafx.fxml.FXML
    private TableColumn<Certificate,String>  breedCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String>  animalIDCOL;
    @javafx.fxml.FXML
    private TableView<Animal> animalTableView1;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> ageCOL;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> statusCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalTypeCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,LocalDate> entryDateCOl1;
    @javafx.fxml.FXML
    private TableColumn<Animal,Integer> weightCOL1;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> animalIdCOL1;
    @javafx.fxml.FXML
    private TextField searchAnimalTF;
    @javafx.fxml.FXML
    private TableColumn<Animal,String> tentCOL1;
    @javafx.fxml.FXML
    private TextField searchAnimalTF1;

    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Healthy","Sick","Under Treatment","Recovered","Deceased");

        certificateCOL.setCellValueFactory(new PropertyValueFactory<>("certificateID"));
        doctorCOL.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        dateCOL.setCellValueFactory(new PropertyValueFactory<>("dateIssued"));
        breedCOL.setCellValueFactory(new PropertyValueFactory<>("breed"));
        weightCOL.setCellValueFactory(new PropertyValueFactory<>("weight"));
        scoreCOL.setCellValueFactory(new PropertyValueFactory<>("healthScore"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
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
    public void generatePDFOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void inspectOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/Joy/doctor_goal5_1.fxml");
    }

    @javafx.fxml.FXML
    public void statusSaveOnActionButton(ActionEvent actionEvent) {
        String animalID = statusAnimalIdTF.getText();
        String status = statusCB.getValue();

        if(animalID.isEmpty() || status == null) {
            AlertUtil.showError("Error", "Please fill in all fields.");
            return;
        }
        boolean found = false;
        for(Animal animal : animalTableView1.getItems()) {
            if (animal.getAnimalID().equals(animalID)) {
                animal.setStatus(status);
                animalTableView1.refresh();
                found = true;
                AlertUtil.showInfo("Success", "Animal status updated successfully.");
                break;
            }
        }
        if(!found) {
            AlertUtil.showError("Error", "Animal ID not found.");
        }

    }

    @javafx.fxml.FXML
    public void loadAnimalOnActionButton(ActionEvent actionEvent) {
        File file = new File("data/animals.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Animal> list = (ArrayList<Animal>) ois.readObject();
            ois.close();
            animalTableView1.getItems().setAll(list);  // THIS IS IMPORTANT
            AlertUtil.showInfo("Success", "Loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            AlertUtil.showError("Error", "Load error: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void searchAnimalOnActionButton(ActionEvent actionEvent) {
        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchAnimalTF, animalTableView1.getItems(), Animal::getAnimalID);
        animalTableView1.getItems().clear();
        animalTableView1.getItems().addAll(searchAnimalResults);
    }

    @javafx.fxml.FXML
    public void searchAnimalOnActionButton1(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadAnimalOnActionButton1(ActionEvent actionEvent) {
        File file = new File("data/certificates.bin");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Certificate> list = (ArrayList<Certificate>) ois.readObject();
            ois.close();
            certificateTableView.getItems().setAll(list);  // THIS IS IMPORTANT
            AlertUtil.showInfo("Success", "Loaded from file");
        } catch (IOException | ClassNotFoundException e) {
            AlertUtil.showError("Error", "Load error: " + e.getMessage());
        }
    }
}