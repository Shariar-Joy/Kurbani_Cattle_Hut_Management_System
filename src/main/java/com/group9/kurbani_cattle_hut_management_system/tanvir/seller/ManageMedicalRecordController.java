package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.AppendableObjectOutputStream;
import com.group9.kurbani_cattle_hut_management_system.BinFilePath;
import com.group9.kurbani_cattle_hut_management_system.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageMedicalRecordController {
    @javafx.fxml.FXML
    private TextField diseaseTextField;
    @javafx.fxml.FXML
    private TextField animalIDTextField;
    @javafx.fxml.FXML
    private TableView<MedicalRecord> medicalRecordsTableView;
    @javafx.fxml.FXML
    private TableColumn<MedicalRecord, Integer> animalIDColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalRecord, String> diseaseTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalRecord, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalRecord, LocalDate> vetCheckRequestDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<MedicalRecord, String> lastUpdateDateTableColumn;

    private final Alert alert = new Alert(Alert.AlertType.WARNING);

    private String sellerEmail = null;
    private final ArrayList<Integer> animalIDs = new ArrayList<>();
    private final ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalIDColumn.setCellValueFactory(new PropertyValueFactory<>("animalID"));
        diseaseTableColumn.setCellValueFactory(new PropertyValueFactory<>("disease"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        vetCheckRequestDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("vetRequestDate"));
        lastUpdateDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("updatedAt"));
    }

    public void setInitData(String sellerEmail) {
        this.sellerEmail = sellerEmail;

        // Read animal ids
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.ANIMAL.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                Animal animal = (Animal) ois.readObject();
                if (animal.getOwnerEmail().equals(sellerEmail)) {
                    animalIDs.add(animal.getAnimalId());
                }
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [Animal File Read]: %s\n", e.getMessage());
        }

        // Read medical records
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.MEDICAL_RECORD.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                MedicalRecord mr = (MedicalRecord) ois.readObject();
                if (animalIDs.contains(mr.getAnimalID())){
                    medicalRecords.add(mr);
                }
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [MedicalRecord File Read]: %s\n", e.getMessage());
        }

        medicalRecordsTableView.getItems().clear();
        medicalRecordsTableView.getItems().addAll(medicalRecords);
    }

    @javafx.fxml.FXML
    public void handleRequestVetCheck(ActionEvent actionEvent) {
        String disease = diseaseTextField.getText();
        if (disease == null || disease.isEmpty()) {
            alert.setContentText("Disease cannot be empty");
            alert.showAndWait();
            return;
        }

        String animalIDText = animalIDTextField.getText();
        if (animalIDText == null || animalIDText.isEmpty()) {
            alert.setContentText("Animal ID cannot be empty");
            alert.showAndWait();
            return;
        }

        int animalId = -1;
        try {
            animalId = Integer.parseInt(animalIDText);
        } catch (NumberFormatException e) {
            alert.setContentText("Animal ID must be an integer");
            alert.showAndWait();
            return;
        }
        if (!animalIDs.contains(animalId)) {
            alert.setContentText("Animal ID does not exist");
            alert.showAndWait();
            return;
        }

        int medicalRecordCount = 0;
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.MEDICAL_RECORD.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                ois.readObject();
                medicalRecordCount++;
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [Animal File Read]: %s\n", e.getMessage());
        }

        MedicalRecord mr = new MedicalRecord(medicalRecordCount + 1, disease, animalId);
        File objectFile = new File(BinFilePath.MEDICAL_RECORD.getFilePath());
        boolean append = objectFile.exists();
        try (
                FileOutputStream fos = new FileOutputStream(BinFilePath.MEDICAL_RECORD.getFilePath(), append);
                ObjectOutputStream oos = append ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
        ) {
            oos.writeObject(mr);
            medicalRecords.add(mr);
            medicalRecordsTableView.getItems().clear();
            medicalRecordsTableView.getItems().addAll(medicalRecords);
            clearFields();
        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [MedicalRecord File Write]: %s\n", e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/dashboard.fxml"));
        Scene scene = new Scene(loader.load());
        ((DashboardController)(loader.getController())).setInitData(sellerEmail);
        stage.setScene(scene);
        stage.setTitle("Seller Dashboard");
        stage.centerOnScreen();
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleUpdateStatus(ActionEvent actionEvent) {
        MedicalRecord mr = medicalRecordsTableView.getSelectionModel().getSelectedItem();
        if (mr == null) {
            alert.setContentText("Please select a medical record");
            alert.showAndWait();
            return;
        }

        String newStatus = null;
        if (mr.getStatus().equals("Not Treated")) {
            newStatus = "Treated";
        } else {
            newStatus = "Not Treated";
        }

        MedicalRecord updatedMedicalRecord = null;
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getMedicalRecordId() == mr.getMedicalRecordId()) {
                medicalRecord.setStatus(newStatus);
                medicalRecord.setUpdatedAt(LocalDate.now());
                updatedMedicalRecord = medicalRecord;
                break;
            }
        }
        medicalRecordsTableView.getItems().clear();
        medicalRecordsTableView.getItems().addAll(medicalRecords);

        // Update bin file
        ArrayList<MedicalRecord> allMedicalRecords = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.MEDICAL_RECORD.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                allMedicalRecords.add((MedicalRecord) ois.readObject());
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [MedicalRecord File Read]: %s\n", e.getMessage());
        }

        for (MedicalRecord medicalRecord : allMedicalRecords) {
            if (medicalRecord.getMedicalRecordId() == updatedMedicalRecord.getMedicalRecordId()) {
                medicalRecord.setUpdatedAt(updatedMedicalRecord.getUpdatedAt());
                medicalRecord.setStatus(newStatus);
            }
        }

        File objectFile = new File(BinFilePath.MEDICAL_RECORD.getFilePath());
        if (objectFile.exists()) {
            objectFile.delete();
        }


        try (
                FileOutputStream fos = new FileOutputStream(BinFilePath.MEDICAL_RECORD.getFilePath(), true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            allMedicalRecords.forEach(medicalRecord -> {
                try {
                    oos.writeObject(medicalRecord);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [MedicalRecord File Update]: %s\n", e.getMessage());
        }
    }

    private void clearFields() {
        diseaseTextField.clear();
        animalIDTextField.clear();
    }
}