package com.group9.kurbani_cattle_hut_management_system.tanvir.seller;

import com.group9.kurbani_cattle_hut_management_system.AppendableObjectOutputStream;
import com.group9.kurbani_cattle_hut_management_system.BinFilePath;
import com.group9.kurbani_cattle_hut_management_system.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class AnimalListingController {
    @javafx.fxml.FXML
    private Label animalIDLabel;
    @javafx.fxml.FXML
    private TextField breedTextField;
    @javafx.fxml.FXML
    private ComboBox<String> animalStatusCombobox;
    @javafx.fxml.FXML
    private TextField expectedPriceTextField;
    @javafx.fxml.FXML
    private TextField weightTextField;
    @javafx.fxml.FXML
    private TableView<BuyingOffer> buyingOfferTableView;
    @javafx.fxml.FXML
    private TableColumn<BuyingOffer, String> buyerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<BuyingOffer, Float> offeredPriceTableColumn;
    @javafx.fxml.FXML
    private TableColumn<BuyingOffer, String> phoneNumberTableColumn;

    private final Alert alert = new Alert(Alert.AlertType.WARNING);

    private Animal animal;
    private final ArrayList<BuyingOffer> buyingOffers = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        animalStatusCombobox.getItems().addAll(
                "Available",
                "Reserved",
                "Sold"
        );

        buyerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        offeredPriceTableColumn.setCellValueFactory(new PropertyValueFactory<>("offeredPrice"));
        phoneNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("buyerPhone"));
    }

    public void setInitData(Animal animal) {
        this.animal = animal;

        animalIDLabel.setText(String.valueOf(animal.getAnimalId()));
        breedTextField.setText(animal.getBreed());
        breedTextField.setText(animal.getBreed());
        animalStatusCombobox.setValue(animal.getSellStatus());
        expectedPriceTextField.setText(String.valueOf(animal.getExpectedPrice()));
        weightTextField.setText(String.valueOf(animal.getWeight()));

        loadBuyingOffers();
    }

    @javafx.fxml.FXML
    public void handleUpdateInformation(ActionEvent actionEvent) {
        String breed = breedTextField.getText();
        if (breed == null || breed.isEmpty()) {
            alert.setContentText("Breed cannot be empty");
            alert.showAndWait();
            return;
        }

        String sellStatus = animalStatusCombobox.getValue();
        if (sellStatus == null || sellStatus.isEmpty()) {
            alert.setContentText("Sell Status cannot be empty");
            alert.showAndWait();
            return;
        }

        String expectedPriceText = expectedPriceTextField.getText();
        if (expectedPriceText == null || expectedPriceText.isEmpty()) {
            alert.setContentText("Expected Price cannot be empty");
            alert.showAndWait();
            return;
        }
        float expectedPrice = -1;
        try {
            expectedPrice = Float.parseFloat(expectedPriceText);
        } catch (Exception ignored) {
            alert.setContentText("Expected Price must be a number");
            alert.showAndWait();
            return;
        }

        String weightText = weightTextField.getText();
        if (weightText == null || weightText.isEmpty()) {
            alert.setContentText("Weight cannot be empty");
            alert.showAndWait();
            return;
        }
        float weight = -1;
        try {
            weight = Float.parseFloat(weightText);
        } catch (Exception ignored) {
            alert.setContentText("Weight must be a number");
            alert.showAndWait();
            return;
        }

        if (breed.equals(animal.getBreed())
                && sellStatus.equals(animal.getSellStatus())
                && expectedPrice == animal.getExpectedPrice()
                && weight == animal.getWeight()
        ) {
            return;
        }

        animal.setBreed(breed);
        animal.setSellStatus(sellStatus);
        animal.setExpectedPrice(expectedPrice);
        animal.setWeight(weight);

        // Update bin file
        ArrayList<Animal> allAnimals = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(BinFilePath.ANIMAL.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                allAnimals.add((Animal) ois.readObject());
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [InventoryController] [MedicalRecord File Read]: %s\n", e.getMessage());
        }
        allAnimals.replaceAll(currAnimal -> currAnimal.getAnimalId() == animal.getAnimalId() ? animal : currAnimal);

        File objectFile = new File(BinFilePath.ANIMAL.getFilePath());
        if (objectFile.exists()) {
            objectFile.delete();
        }

        // Write the rest
        try (
                FileOutputStream fos = new FileOutputStream(BinFilePath.ANIMAL.getFilePath(), true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            allAnimals.forEach(currAnimal -> {
                try {
                    oos.writeObject(currAnimal);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            System.out.printf("[Error] [AnimalListingController] [Animal File Update]: %s\n", e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void handleSell(ActionEvent actionEvent) {
    }

    private void loadBuyingOffers() {
        if (!new File(BinFilePath.BUYING_OFFER.getFilePath()).exists()) {
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(BinFilePath.BUYING_OFFER.getFilePath());
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                BuyingOffer offer = (BuyingOffer) ois.readObject();
                if (offer.getAnimalId() == animal.getAnimalId()) {
                    buyingOffers.add(offer);
                }
            }
        } catch (EOFException ignored) {

        } catch (Exception e) {
            System.out.printf("[Error] [AnimalListingController] [BuyingOffer Read File] %s\n", e.getMessage());
        }

        buyingOfferTableView.getItems().clear();
        buyingOfferTableView.getItems().addAll(buyingOffers);
    }

    @javafx.fxml.FXML
    public void handleGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader(HelloApplication.class.getResource("tanvir/seller/inventory.fxml"));
        Scene scene = new Scene(loader.load());
        ((InventoryController)(loader.getController())).setInitData(animal.getOwnerEmail());
        stage.setScene(scene);
        stage.setTitle("Inventory");
        stage.centerOnScreen();
        stage.show();
    }
}