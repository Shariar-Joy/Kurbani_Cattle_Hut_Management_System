package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.AppendableObjectOutputStream;
import com.group9.kurbani_cattle_hut_management_system.BinFilePath;
import com.group9.kurbani_cattle_hut_management_system.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    @javafx.fxml.FXML
    private TextField breedTextField;
    @javafx.fxml.FXML
    private TextField sexTextField;
    @javafx.fxml.FXML
    private TextField ageTextField;
    @javafx.fxml.FXML
    private TextField weightTextField;
    @javafx.fxml.FXML
    private TextField expectedPriceTextField;
    @javafx.fxml.FXML
    private TextField filterBreedTextField;
    @javafx.fxml.FXML
    private ComboBox<String> filterSexComboBox;
    @javafx.fxml.FXML
    private TableView<Animal> inventoryTableView;
    @javafx.fxml.FXML
    private TableColumn<Animal, Integer> idTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Animal, String> breadTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Animal, String> sexTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Animal, String> ageTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Animal, Float> weightTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Animal, Float> expectedPriceTableColumn1;

    private final Alert alert = new Alert(Alert.AlertType.WARNING);

    private String sellerEmail = null;
    private final ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filterSexComboBox.getItems().addAll("All", "Male", "Female");

        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("animalId"));
        breadTableColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));
        sexTableColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        weightTableColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        expectedPriceTableColumn1.setCellValueFactory(new PropertyValueFactory<>("expectedPrice"));
    }

    public void setInitData(String sellerEmail) {
        this.sellerEmail = sellerEmail;

        try (
                FileInputStream fis = new FileInputStream(BinFilePath.ANIMAL.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                Animal animal = (Animal) ois.readObject();
                if (animal.getOwnerEmail().equals(sellerEmail)) {
                    animals.add(animal);
                }
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [Animal File Read]: %s\n", e.getMessage());
        }

        inventoryTableView.getItems().clear();
        inventoryTableView.getItems().addAll(animals);
    }

    @javafx.fxml.FXML
    public void handleAddAnimal() {
        String breed = breedTextField.getText();
        if (breed == null || breed.isEmpty()) {
            alert.setContentText("Please enter a Breed Name");
            alert.showAndWait();
            return;
        }

        String sex = sexTextField.getText();
        if (sex == null || sex.isEmpty()) {
            alert.setContentText("Please enter a sex value");
            alert.showAndWait();
            return;
        }

        String age = ageTextField.getText();
        if (age == null || age.isEmpty()) {
            alert.setContentText("Please enter a sex value");
            alert.showAndWait();
            return;
        }

        String weightText = weightTextField.getText();
        if (weightText == null || weightText.isEmpty()) {
            alert.setContentText("Please enter a weight value");
            alert.showAndWait();
            return;
        }
        float weight = -1;
        try {
            weight = Float.parseFloat(weightText);
        } catch (NumberFormatException e) {
            alert.setContentText("Please enter a valid weight");
            alert.showAndWait();
            return;
        }

        String expectedPriceText = expectedPriceTextField.getText();
        if (expectedPriceText == null || expectedPriceText.isEmpty()) {
            alert.setContentText("Please enter a expected price value");
            alert.showAndWait();
            return;
        }
        float expectedPrice = -1;
        try {
            expectedPrice = Float.parseFloat(expectedPriceText);
        } catch (NumberFormatException e) {
            alert.setContentText("Please enter a valid expected price");
            alert.showAndWait();
            return;
        }

        int animalCount = 0;
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.ANIMAL.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                ois.readObject();
                animalCount++;
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [Animal File Read]: %s\n", e.getMessage());
        }

        Animal newAnimal = new Animal(animalCount + 1, sellerEmail, breed, age, sex, weight, expectedPrice);
        File objectFile = new File(BinFilePath.ANIMAL.getFilePath());
        boolean append = objectFile.exists();
        try (
                FileOutputStream fos = new FileOutputStream(BinFilePath.ANIMAL.getFilePath(), append);
                ObjectOutputStream oos = append ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos);
        ) {
            oos.writeObject(newAnimal);
            animals.add(newAnimal);
            inventoryTableView.getItems().add(newAnimal);
            clearFields();
        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [Animal File Write]: %s\n]", e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void handleTableFilter() {
        String breed = filterBreedTextField.getText();
        String sex = filterSexComboBox.getValue();

        inventoryTableView.getItems().clear();
        inventoryTableView.getItems().addAll(animals.stream().filter(animal ->
                (breed == null || animal.getBreed().toLowerCase().contains(breed.toLowerCase()))
                        && (sex == null || sex.equals("All") || animal.getSex().equalsIgnoreCase(sex))
        ).toList());
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
    public void handleManageListing(ActionEvent actionEvent) throws IOException {
        Animal selectedAnimal = inventoryTableView.getSelectionModel().getSelectedItem();
        if (selectedAnimal == null) {
            alert.setContentText("Please select an animal");
            alert.showAndWait();
            return;
        }

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/animal-listing.fxml"));
        Scene scene = new Scene(loader.load());
        ((AnimalListingController)(loader.getController())).setInitData(selectedAnimal);
        stage.setScene(scene);
        stage.setTitle("Manage Listing");
        stage.centerOnScreen();
        stage.show();
    }

    private void clearFields() {
        breedTextField.clear();
        sexTextField.clear();
        ageTextField.clear();
        weightTextField.clear();
        expectedPriceTextField.clear();
    }
}