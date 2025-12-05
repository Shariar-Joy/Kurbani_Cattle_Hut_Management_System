package com.group9.kurbani_cattle_hut_management_system.Joy;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import com.group9.kurbani_cattle_hut_management_system.Joy.Class.Quarantine;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.AlertUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.FilesUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.IDStoreUtil;
import com.group9.kurbani_cattle_hut_management_system.Joy.Utils.RefreshUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Doctor_Goal3Controller
{
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> diseaseCOL;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> medicineCOL;
    @javafx.fxml.FXML
    private TextField diseaseTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine, String> isolationTentCOL;
    @javafx.fxml.FXML
    private TextField isolationTentTF;
    @javafx.fxml.FXML
    private TableView<Quarantine> quarantineTableView;
    @javafx.fxml.FXML
    private TextField symptomsTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> symptomsCOL;
    @javafx.fxml.FXML
    private TextField isolationTimeTF;
    @javafx.fxml.FXML
    private TextField medicineTF;
    @javafx.fxml.FXML
    private TableColumn<Quarantine,String> isolationTimeCOL;
    @javafx.fxml.FXML
    private ComboBox<String> animalIDCB;

    private final ArrayList<Quarantine> quarantineList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalIDCB.setItems(IDStoreUtil.loadIDs("animal_ids.txt"));

        symptomsCOL.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        diseaseCOL.setCellValueFactory(new PropertyValueFactory<>("disease"));
        medicineCOL.setCellValueFactory(new PropertyValueFactory<>("medicine"));
        isolationTentCOL.setCellValueFactory(new PropertyValueFactory<>("isolationTent"));
        isolationTimeCOL.setCellValueFactory(new PropertyValueFactory<>("isolationTime"));
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
    public void createOnActionButton(ActionEvent actionEvent) {
        String animalID = animalIDCB.getValue();
        String symptoms = symptomsTF.getText();
        String disease = diseaseTF.getText();
        String medicine = medicineTF.getText();
        String isolationTent = isolationTentTF.getText();
        String isolationTime = isolationTimeTF.getText();

        if(animalID == null || animalID.isEmpty() ||
                symptoms.isEmpty() || disease.isEmpty() || medicine.isEmpty() ||
                isolationTent.isEmpty() || isolationTime.isEmpty()) {
            System.out.println("Please fill in all fields.");
            return;
        }
        Quarantine quarantine = new Quarantine(null,symptoms, disease,medicine, isolationTent, isolationTime);
        quarantineList.add(quarantine);
        quarantineTableView.getItems().addAll(quarantineList);
        AlertUtil.showInfo("Success", "Quarantine record created successfully.");

        File file = new File("data/quarantines.bin");

        try {
            FileOutputStream fos = new FileOutputStream(file); // NO appending
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(quarantineList);  // Save entire list
            oos.close();
            AlertUtil.showInfo("Success", "Saved to file");
        } catch (IOException e) {
            AlertUtil.showError("Error", "File error: " + e.getMessage());
        }

    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
        RefreshUtil.clearFields(symptomsTF, diseaseTF, medicineTF, isolationTentTF, isolationTimeTF);
    }
}