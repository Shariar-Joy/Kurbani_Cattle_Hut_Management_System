package com.group9.kurbani_cattle_hut_management_system.Ishmam;

import com.group9.kurbani_cattle_hut_management_system.BaseController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logistics_goal5Controller
{

    @javafx.fxml.FXML
    private TextField buyerNameTF;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> totalPriceCOL;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> paymentCOL;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> buyerNameCOL;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> deliveryCOL;
    @javafx.fxml.FXML
    private TableColumn<CartItem, String> animalIDCOL;
    @javafx.fxml.FXML
    private TableView<CartItem> chalanTV;

    @FXML private RadioButton paymentCardRB;
    @FXML private RadioButton paymentBankRB;
    @FXML private RadioButton paymentCashRB;
    @FXML private RadioButton paymentOfflineRB;

    @FXML private RadioButton deliveryHomeRB;
    @FXML private RadioButton deliveryPickupRB;

    @FXML private Label infoLabel;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            if (animalIDCOL != null) animalIDCOL.setCellValueFactory(new PropertyValueFactory<>("id"));
            if (totalPriceCOL != null) totalPriceCOL.setCellValueFactory(cell -> {
                return new javafx.beans.property.SimpleStringProperty(String.valueOf(cell.getValue().getTotalPrice()));
            });
            if (buyerNameCOL != null) buyerNameCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(""));
            if (paymentCOL != null) paymentCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(""));
            if (deliveryCOL != null) deliveryCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(""));
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void signOutOnActionButton(ActionEvent actionEvent) throws IOException {
        BaseController.switchTo(actionEvent,
                "/com/group9/kurbani_cattle_hut_management_system/login.fxml");
    }

    @javafx.fxml.FXML
    public void goBackOnActionButton(ActionEvent actionEvent)throws IOException {
        BaseController.switchTo(actionEvent, "/com/group9/kurbani_cattle_hut_management_system/Ishmam/logistics-officer-view.fxml");
    }

    @javafx.fxml.FXML
    public void savePDFOA(ActionEvent actionEvent) {
    }

    @Deprecated
    public void chalanTV(Event event) {
    }

    @javafx.fxml.FXML
    public void clearOA(ActionEvent actionEvent) {
        if (chalanTV != null) chalanTV.getItems().clear();
        if (infoLabel != null) infoLabel.setText("");
    }

    @Deprecated
    public void saveDraftOA(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void loadOA(ActionEvent actionEvent) {
        String buyer = (buyerNameTF == null) ? "" : buyerNameTF.getText();
        if (buyer == null || buyer.trim().isEmpty()) {
            if (infoLabel != null) infoLabel.setText("Please enter buyer name.");
            System.out.println("Please enter buyer name.");
            return;
        }

        List<CartItem> items = new ArrayList<>();
        try {
            ObservableList<CartItem> repoItems = CartRepository.getInstance().getCartItems();
            if (repoItems != null && !repoItems.isEmpty()) {
                items.addAll(repoItems);
            } else {
                List<Object> objs = FileUtil.readObjects("data/CartItems.bin");
                for (Object o : objs) if (o instanceof CartItem) items.add((CartItem) o);
            }
        } catch (Exception e) {
        }

        String payment = CartRepository.getInstance().getPaymentMethod();
        if (payment == null || payment.isEmpty()) {
            if (paymentCardRB != null && paymentCardRB.isSelected()) payment = "CARD";
            else if (paymentBankRB != null && paymentBankRB.isSelected()) payment = "BANK";
            else if (paymentCashRB != null && paymentCashRB.isSelected()) payment = "CASH";
            else if (paymentOfflineRB != null && paymentOfflineRB.isSelected()) payment = "OFFLINE";
        }

        String delivery = CartRepository.getInstance().getDeliveryMethod();
        if (delivery == null || delivery.isEmpty()) {
            if (deliveryHomeRB != null && deliveryHomeRB.isSelected()) delivery = "HOME";
            else if (deliveryPickupRB != null && deliveryPickupRB.isSelected()) delivery = "PICKUP";
        }

        if (chalanTV != null) {
            ObservableList<CartItem> list = FXCollections.observableArrayList(items);
            chalanTV.getItems().clear();
            chalanTV.getItems().addAll(list);

            final String buyerFinal = buyer;
            final String paymentFinal = (payment == null) ? "" : payment;
            final String deliveryFinal = (delivery == null) ? "" : delivery;

            if (buyerNameCOL != null) buyerNameCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(buyerFinal));
            if (paymentCOL != null) paymentCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(paymentFinal));
            if (deliveryCOL != null) deliveryCOL.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(deliveryFinal));

            chalanTV.refresh();
        }

        System.out.println("Loaded " + items.size() + " items into challan for " + buyer + " | Payment:" + payment + " | Delivery:" + delivery);
        if (infoLabel != null) infoLabel.setText("Loaded " + items.size() + " items. Buyer:" + buyer);
    }
}