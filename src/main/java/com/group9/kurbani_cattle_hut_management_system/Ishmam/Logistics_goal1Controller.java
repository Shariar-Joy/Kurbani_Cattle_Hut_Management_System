package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;

public class Logistics_goal1Controller
{
    @javafx.fxml.FXML
    private ComboBox<String> animalCB;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> animalCOL;
    @javafx.fxml.FXML
    private ComboBox<String> tentCB;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> idCOL;
    @javafx.fxml.FXML
    private TableView<Animalinfo> gateinfoTB;
    @javafx.fxml.FXML
    private TextField idTF;
    @javafx.fxml.FXML
    private TextField sellerNameTF;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> sellerNameCOL;

    private ObservableList<Animalinfo> dataList;
    private Animalinfo pendingSave;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> priceCOL;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> breedCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> tentCOL1;

    @javafx.fxml.FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();
        gateinfoTB.setItems(dataList);

        idCOL.setCellValueFactory(new PropertyValueFactory<>("id"));
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        sellerNameCOL.setCellValueFactory(new PropertyValueFactory<>("seller"));
        tentCOL1.setCellValueFactory(new PropertyValueFactory<>("tent"));
        breedCOL.setCellValueFactory(new PropertyValueFactory<>("breed"));
        priceCOL.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPrice())));

        ObservableList<String> animals = FXCollections.observableArrayList("Cow", "Sheep", "Goat", "Camel");
        animalCB.setItems(animals);

        ObservableList<String> tents = FXCollections.observableArrayList("Tent A", "Tent B", "Tent C", "Tent D");
        tentCB.setItems(tents);
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,"/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    @javafx.fxml.FXML
    public void confirmOA(ActionEvent actionEvent) {
        String id = idTF.getText();
        String animal = animalCB.getValue();
        String tent = tentCB.getValue();
        String seller = sellerNameTF.getText();
        String breed = breedTF.getText();
        String priceS = priceTF.getText();

        errorLabel.setText("");

        if (id == null || id.isEmpty()) {
            errorLabel.setText("Error: Animal ID cannot be empty!");
            return;
        }

        if (!id.matches("[0-9]+")) {
            errorLabel.setText("Error: Animal ID must contain only numbers!");
            return;
        }

        if (seller == null || seller.isEmpty()) {
            errorLabel.setText("Error: Seller name cannot be empty!");
            return;
        }

        if (!seller.matches("[a-zA-Z ]+")) {
            errorLabel.setText("Error: Seller name must contain only letters and spaces!");
            return;
        }

        if (animal == null) {
            errorLabel.setText("Error: Please select an animal type!");
            return;
        }

        if (tent == null) {
            errorLabel.setText("Error: Please select a tent!");
            return;
        }

        if (breed == null || breed.isEmpty()) {
            errorLabel.setText("Error: Breed cannot be empty!");
            return;
        }

        double price = 0.0;
        if (priceS == null || priceS.isEmpty()) {
            errorLabel.setText("Error: Price cannot be empty!");
            return;
        }
        try {
            price = Double.parseDouble(priceS);
            if (price < 0) {
                errorLabel.setText("Error: Price cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Error: Price must be a number!");
            return;
        }


        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = now.format(formatter);

        Animalinfo info = new Animalinfo(id, animal, breed, seller, tent, price, time);

        dataList.add(info);
        pendingSave = info;

        errorLabel.setText("Entry added successfully!");

        idTF.clear();
        animalCB.setValue(null);
        tentCB.setValue(null);
        sellerNameTF.clear();
        breedTF.clear();
        priceTF.clear();
    }

    @javafx.fxml.FXML
    public void clearOA(ActionEvent actionEvent) {
        idTF.clear();
        animalCB.setValue(null);
        tentCB.setValue(null);
        sellerNameTF.clear();
        breedTF.clear();
        priceTF.clear();

        int selectedIndex = gateinfoTB.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            dataList.remove(selectedIndex);
        }

        errorLabel.setText("Cleared!");
    }

    @javafx.fxml.FXML
    public void savedataOA(ActionEvent actionEvent) {

        Animalinfo toSave = pendingSave;

        if (toSave == null) {
            Object sel = gateinfoTB.getSelectionModel().getSelectedItem();
            if (sel instanceof Animalinfo) {
                toSave = (Animalinfo) sel;
            } else if (!dataList.isEmpty()) {
                toSave = dataList.get(dataList.size() - 1);
            }
        }

        if (toSave == null) {
            errorLabel.setText("Nothing to save!");
            return;
        }


        File file = new File("data/AnimalInfo.bin");
        try {
            boolean exists = file.exists();

            if (file.getParentFile() != null) file.getParentFile().mkdirs();

            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos = exists ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
            oos.writeObject(toSave);
            oos.close();

            if (toSave == pendingSave) pendingSave = null;

            System.out.println("Object stored successfully!");
            errorLabel.setText("Saved to bin.");
        } catch (IOException e) {
            System.out.println("Failed to write object!");
            errorLabel.setText("Error saving data: " + e.getMessage());
        }
    }


    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
    }
}