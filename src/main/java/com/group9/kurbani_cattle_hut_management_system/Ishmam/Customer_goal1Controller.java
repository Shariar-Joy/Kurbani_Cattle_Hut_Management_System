package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customer_goal1Controller {

    @javafx.fxml.FXML
    private TableColumn availableCOL;
    @javafx.fxml.FXML
    private ComboBox<String> animalCB;
    @javafx.fxml.FXML
    private TableView<Animalinfo> showProduct;
    @javafx.fxml.FXML
    private TableColumn<String, Animalinfo> animalCOL;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> cartQuantityCOL;
    @javafx.fxml.FXML
    private TableColumn<String, CartItem> cartAnimalIDCOL;
    @javafx.fxml.FXML
    private RadioButton deliveryHomeRB;
    @javafx.fxml.FXML
    private RadioButton paymentCardRB;
    @javafx.fxml.FXML
    private RadioButton paymentBankRB;
    @javafx.fxml.FXML
    private RadioButton paymentCashRB;
    @javafx.fxml.FXML
    private RadioButton paymentOfflineRB;
    @javafx.fxml.FXML
    private TextField searchAnimalTF;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> cartAnimalCOL;
    @javafx.fxml.FXML
    private RadioButton paymentOfflineRB2;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> cartTotalPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> priceCOL;
    @javafx.fxml.FXML
    private RadioButton deliveryPIckupRB;
    @javafx.fxml.FXML
    private TableView<CartItem> cartTV;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> tentCOL;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> breedCOL;
    @javafx.fxml.FXML
    private RadioButton paymentCashRB2;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField breedTF;
    @javafx.fxml.FXML
    private TableColumn<Animalinfo, String> animalIDCOL;

    private ObservableList<Animalinfo> products;
    private ObservableList<CartItem> cartItems = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        products = AnimalRepository.getInstance().getList();
        loadProductsFromFile();
        setupComboBox();
        setupTableColumns();

        showProduct.setItems(products);
        cartTV.setItems(cartItems);
        errorLabel.setText("");
    }

    private void loadProductsFromFile() {
        try {
            List<Object> data = FileUtil.readObjects("data/AnimalInfo.bin");
            products.clear();

            for (Object obj : data) {
                if (obj instanceof Animalinfo) {
                    products.add((Animalinfo) obj);
                }
            }
            System.out.println("Loaded " + products.size() + " animals");
        } catch (Exception e) {
            System.out.println("Could not load data: " + e.getMessage());
        }
    }

    private void setupComboBox() {
        animalCB.setItems(FXCollections.observableArrayList("Cow", "Sheep", "Goat", "Camel"));
    }

    private void setupTableColumns() {
        animalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        breedCOL.setCellValueFactory(new PropertyValueFactory<>("breed"));
        priceCOL.setCellValueFactory(cell ->
                new SimpleStringProperty(String.valueOf(cell.getValue().getPrice())));
        tentCOL.setCellValueFactory(new PropertyValueFactory<>("tent"));
        animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("id"));


        cartAnimalIDCOL.setCellValueFactory(new PropertyValueFactory<>("id"));
        cartAnimalCOL.setCellValueFactory(new PropertyValueFactory<>("animal"));
        cartQuantityCOL.setCellValueFactory(cell ->
                new SimpleStringProperty(String.valueOf(cell.getValue().getQuantity())));
        cartTotalPriceCOL.setCellValueFactory(cell ->
                new SimpleStringProperty(String.valueOf(cell.getValue().getTotalPrice())));
    }

    @javafx.fxml.FXML
    public void addToCartOA(ActionEvent actionEvent) {
        Animalinfo selected = showProduct.getSelectionModel().getSelectedItem();

        if (selected == null) {
            errorLabel.setText("Please select an animal first");
            return;
        }

        if (!isPaymentSelected()) {
            errorLabel.setText("Please select a payment method");
            return;
        }

        if (!isDeliverySelected()) {
            errorLabel.setText("Please select a delivery method");
            return;
        }

        addOrUpdateCart(selected);
        errorLabel.setText("Added to cart");
    }

    private boolean isPaymentSelected() {
        return (paymentCardRB != null && paymentCardRB.isSelected()) ||
                (paymentBankRB != null && paymentBankRB.isSelected()) ||
                (paymentCashRB != null && paymentCashRB.isSelected()) ||
                (paymentOfflineRB != null && paymentOfflineRB.isSelected());
    }

    private boolean isDeliverySelected() {
        return (deliveryHomeRB != null && deliveryHomeRB.isSelected()) ||
                (deliveryPIckupRB != null && deliveryPIckupRB.isSelected());
    }

    private void addOrUpdateCart(Animalinfo animal) {
        CartItem existingItem = findCartItem(animal.getId());

        if (existingItem != null) {
            existingItem.addQuantity(1, animal.getPrice());
            cartTV.refresh();
        } else {
            CartItem newItem = new CartItem(animal.getId(), animal.getAnimal(), 1, animal.getPrice());
            cartItems.add(newItem);
        }

        FileUtil.saveObject("data/CartItems.bin", new ArrayList<>(cartItems));
    }

    private CartItem findCartItem(String id) {
        for (CartItem item : cartItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @javafx.fxml.FXML
    public void searchOA(ActionEvent actionEvent) {
        String search = searchAnimalTF.getText().trim();

        if (search.isEmpty()) {
            errorLabel.setText("Please enter an animal name");
            return;
        }

        List<Animalinfo> results = new ArrayList<>();
        for (Animalinfo animal : products) {
            if (animal.getAnimal().toLowerCase().contains(search.toLowerCase())) {
                results.add(animal);
            }
        }

        if (results.isEmpty()) {
            errorLabel.setText("No results for: " + search);
        } else {
            errorLabel.setText("");
            showProduct.setItems(FXCollections.observableArrayList(results));
        }
    }

    @javafx.fxml.FXML
    public void filterItemsOA(ActionEvent actionEvent) {
        String animalType = animalCB.getValue();
        String breed = breedTF.getText().trim();
        String priceText = priceTF.getText().trim();

        Double targetPrice = null;
        if (!priceText.isEmpty()) {
            try {
                targetPrice = Double.parseDouble(priceText);
            } catch (NumberFormatException e) {
                errorLabel.setText("Price must be a number");
                return;
            }
        }

        List<Animalinfo> filtered = new ArrayList<>();
        for (Animalinfo animal : products) {
            boolean matches = true;

            if (animalType != null && !animalType.isEmpty()) {
                matches = animal.getAnimal().equalsIgnoreCase(animalType);
            }

            if (matches && !breed.isEmpty()) {
                matches = animal.getBreed().toLowerCase().contains(breed.toLowerCase());
            }

            if (matches && targetPrice != null) {
                matches = (animal.getPrice() == targetPrice);
            }

            if (matches) {
                filtered.add(animal);
            }
        }

        if (filtered.isEmpty()) {
            errorLabel.setText("No items match the filter");
        } else {
            errorLabel.setText("");
        }

        showProduct.setItems(FXCollections.observableArrayList(filtered));
    }

    @javafx.fxml.FXML
    public void proceedCheckOA(ActionEvent actionEvent) throws IOException {
        String payment = getSelectedPayment();
        String delivery = getSelectedDelivery();

        CartRepository.getInstance().setCartItems(new ArrayList<>(cartItems));
        CartRepository.getInstance().setPaymentMethod(payment);
        CartRepository.getInstance().setDeliveryMethod(delivery);

        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-goal5.fxml");
    }

    private String getSelectedPayment() {
        if (paymentCardRB != null && paymentCardRB.isSelected()) return "CARD";
        if (paymentBankRB != null && paymentBankRB.isSelected()) return "BANK";
        if (paymentCashRB != null && paymentCashRB.isSelected()) return "CASH";
        if (paymentOfflineRB != null && paymentOfflineRB.isSelected()) return "OFFLINE";
        return "";
    }

    private String getSelectedDelivery() {
        if (deliveryHomeRB != null && deliveryHomeRB.isSelected()) return "HOME";
        if (deliveryPIckupRB != null && deliveryPIckupRB.isSelected()) return "PICKUP";
        return "";
    }

    @javafx.fxml.FXML
    public void resetcartOA(ActionEvent actionEvent) {
        cartItems.clear();
        errorLabel.setText("Cart cleared");
    }

    @javafx.fxml.FXML
    public void reloadOA(ActionEvent actionEvent) {
        showProduct.setItems(products);
        errorLabel.setText("");
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/Ishmam/customer-view.fxml");
    }

    @Deprecated
    public void cartTV(Event event) {
    }
}