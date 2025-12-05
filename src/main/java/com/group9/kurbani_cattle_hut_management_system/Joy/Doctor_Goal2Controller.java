package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Vaccination;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.*;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor_Goal2Controller
{
    @javafx.fxml.FXML
    private DatePicker dateAdministeredDatePiker;
    @javafx.fxml.FXML
    private TextField vaccineNameTF;
    @javafx.fxml.FXML
    private TextField doseNumberTF;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,Integer> doseNumberCOl;
    @javafx.fxml.FXML
    private TableColumn<Vaccination, LocalDate> nextDueDateCOL;
    @javafx.fxml.FXML
    private TextField remarksTF;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,LocalDate> dateAdministeredCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> statusCOL;
    @javafx.fxml.FXML
    private TextField imageTF;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> animalIDCOL;
    @javafx.fxml.FXML
    private TableColumn<Vaccination,String> vaccineNameCOL;
    @javafx.fxml.FXML
    private DatePicker nextDueDateDatePicker;
    @javafx.fxml.FXML
    private TableView<Vaccination> vaccinationTableView;

    private final ArrayList<Vaccination> vaccinationList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        animalIDCB.setItems(IDStoreUtil.loadIDs("animals_ids.txt"));

        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        vaccineNameCOL.setCellValueFactory(new PropertyValueFactory<>("vaccineName"));
        doseNumberCOl.setCellValueFactory(new PropertyValueFactory<>("doseNumber"));
        dateAdministeredCOL.setCellValueFactory(new PropertyValueFactory<>("vaccinationDate"));
        nextDueDateCOL.setCellValueFactory(new PropertyValueFactory<>("nextDueDate"));
        statusCOL.setCellValueFactory(new PropertyValueFactory<>("status"));
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
    public void searchOnActionButton(ActionEvent actionEvent) {
//        List<Animal> searchAnimalResults = SearchUtil.searchAndValidate(searchTF, vaccinationTableView.getItems(), Animal::getAnimalID);
//        vaccinationTableView.getItems().clear();
//        vaccinationTableView.getItems().addAll((Vaccination) searchAnimalResults);

    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {

        String animalID = animalIDCB.getValue();
        String vaccineName = vaccineNameTF.getText().trim();
        int doseNumber = 0;
        LocalDate vaccinationDate = dateAdministeredDatePiker.getValue();
        LocalDate nextDueDate = nextDueDateDatePicker.getValue();

        try{
            doseNumber = Integer.parseInt(doseNumberTF.getText().trim());
        } catch (Exception e){
            AlertUtil.showError("Input Error","Dose Number must be a valid integer.");
            return;
        }

        if (animalID == null || animalID.isEmpty() ||
                vaccineName.isEmpty() ||
                vaccinationDate == null ||
                nextDueDate == null) {
            AlertUtil.showError("Input Error","Please fill in all required fields.");

        }

        Vaccination vaccination = new Vaccination(animalID, vaccineName, doseNumber, vaccinationDate, nextDueDate);
        vaccinationList.add(vaccination);
        AlertUtil.showInfo("Success","Vaccination record saved successfully.");
        vaccinationTableView.getItems().clear();
        vaccinationTableView.getItems().addAll(vaccinationList);
        File file = new File("data/vaccinations.bin");
        try {
            FileOutputStream fos = new FileOutputStream(file); // NO appending
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vaccinationList);  // Save entire list
            oos.close();
            AlertUtil.showInfo("Success", "Saved to file");
        } catch (IOException e) {
            AlertUtil.showError("Error", "File error: " + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(vaccineNameTF,doseNumberTF,remarksTF,imageTF);
        RefreshUtil.clearDatePickers(dateAdministeredDatePiker,nextDueDateDatePicker);
        RefreshUtil.clearComboBoxes(animalIDCB);
    }

}